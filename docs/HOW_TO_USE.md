# Criando uma requisição

1 - Primeiramente se utiliza a classe `PagPayPaymentButton` no layout:

```xml
<com.pagpay.checkout.presentation.button.PagPayPaymentButton
                android:id="@+id/btn_pagbank_yellow"
                app:colorScheme="yellow"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
```
​​
2 - Criar os objetos `MerchantInfoRequest` e `PaymentRequest`, aqui isso é feito através de um método chamado `createPaymentRequest` que será utilizado em um step mais abaixo:

```java
fun createMerchantInfoRequest(): MerchantInfoRequest {
    return MerchantInfoRequest(
        appName = "SDK App example",
        clientId = "SEU_CLIENT_ID_AQUI"
    )
}

fun createPaymentRequest(): PaymentsRequest {
    val items: List<Items> = listOf(
        Items(
            reference = "REFERENCIA_123",
            name = "mochila",
            quantity = 1,
            unitAmount = 1000
        )
    )
    val notificationUrls: List<String> = listOf("https://meusite.com/pedidos/pagamentos")
    val shipping = Shipping(
        address = Address(
            street = "rua teste",
            number = "123",
            complement = "casa 1",
            city = "São Paulo",
            country = "BRA",
            district = "SP",
            postalCode = "12345678",
            state = "SP"
        )
    )

    val customer = Customer("André Luis dos Santos", "anluis@pagseguro.com", "32685508600")
    val amount = Amount(value = 5500, currency = "BRL")

    return PaymentsRequest(
        referenceId = "PEDIDO_123",
        amount = amount,
        customer = customer,
        shipping = shipping,
        notificationUrls = notificationUrls,
        items = items,
        redirectUrl = "https://meusite.com/pedidos/redirect"
    )
}
```
​
3 - Criar um objeto do tipo `PagPay` usando um `PagPay.newBuilder()`.

3 - Após criado o objeto `PagPay` se chama o método `redirectPagBank`, o this é uma referência à classe que implementa a interface `CheckoutContract.CallBack`. Importante notar que o método `redirectPagbank` por baixo faz uma chamada de networking e se chamada da thread principal causa uma exceção, esse método precisa ser chamado em outra thread.

```java
val payWithPagPayClient = PagPay.newBuilder()
    .merchantInfo(createMerchantInfoRequest())
    .paymentRequest(createPaymentRequest(), this)
    .build()
​
payWithPagPayClient.redirectPagBank(this, Env.PROD)
​
override fun onSuccessToRedirect(deepLinkCode: String) {
}
​
override fun onErrorToRedirect(error: ErrorApi) {
}
```


---

## Tabela com informações de cada campo do payload


|      Campo          |              Tipo               | Obrigatório |                                               Descrição                                               |
|---------------------|---------------------------------|-------------|-------------------------------------------------------------------------------------------------------|
|   referenceId       |    String (1-200 caracteres)    |     Sim     |                             Identificador próprio atribuído para o pedido                             |
|   items             |    Array of Object              |     Sim     |                      Objeto contendo as informações dos itens inseridos no pedido                     |
|   └──reference      |    String (1-255 caracteres)    |     Não     |                             Identificador próprio atribuído para o item                               |
|   └──name           |    String (1-100  caracteres)   |     Sim     |                                             Nome do item                                              |
|   └──quantity       |    Int (min = 1, max = 999)     |     Sim     |                                          Quantidade do item                                           |
|   └──unitAmount     | Int (min = 1, max = 999999900 ) |     Sim     |                                             Valor do item                                             |
|   shipping          |             Object              |     Não     |                         Objeto contendo as informações de entrega do pedido                           |
|    └──address       |             Object              |     Sim     |                    Objeto contendo as informações de endereço de entrega do pedido                    |
|    └──└──street     |    String (1-160 caracteres)    |     Sim     |                                 Rua do endereço de entrega do pedido                                  |
|    └──└──number     |    String (1-20 caracteres)     |     Sim     |                                Número do endereço de entrega do pedido                                |
|    └──└──complement |    String (1-40 caracteres)     |     Não     |                             Complemento do endereço de entrega do pedido                              |
|    └──└──district   |    String (1-60 caracteres)     |     Sim     |                                Bairro do endereço de entrega do pedido                                |
|    └──└──city       |    String (1-90 caracteres)     |     Sim     |                                Cidade do endereço de entrega do pedido                                |
|    └──└──state      |             String              |     Sim     |                 Código do Estado do endereço de entrega do pedido. Padrão ISO 3166-2                  |
|    └──└──country    |             String              |     Sim     |               Código do País do endereço de entrega do pedido. Padrão ISO 3166-1 alfa-3               |
|    └──└──postalCode |      String (8 caracteres)      |     Sim     |                                 CEP do endereço de entrega do pedido                                  |
|    amount           |             Object              |     Sim     |             Objeto contendo as informações do valor a ser utilizado na criação do pedido              |
|     └──value        | Int (min = 1, max = 999999900)  |     Sim     |                                            Valor do pedido                                            |
|     └──currency     |             String              |     Sim     |                      Sigla da moeda que representa o valor do pedido. Fixo "BRL"                      |
|    notificationUrls |         Array of String         |     Sim     | Objeto contendo as urls que receberão as notificações do pedido (por ora, somente aceitamos uma url.) |
|    redirectUrl      |             String              |     Não     |                      URL onde o usuário será redirecionado após o pagamento ser efetuado              |