# Pagar com PagBank Android SDK
​
## Introdução
O Pagar com PagBank é o produto do PagSeguro que permite aos vendedores utilizar o app PagBank como método de pagamento no checkout do seu próprio aplicativo. Este produto confere mais segurança aos vendedores devido aos padrões de validação de conta e cartões de crédito, adotados pelo PagBank.

![](docs/images/example_light_button.png)​

## SDK
O SDK disponibiliza um botão de pagamentos que facilita a integração do Merchant, através de suas credenciais pode enviar os dados do seu pedido e nosso SDK irá realizar a integração com nossos serviços.

---
​
## Como Funciona

### Conceitos
​
Segue alguns termos usados nessa documentação:
​

**Integrador**: O desenvolvedor que vai usar o SDK em seu projeto para que possa oferecer para seus clientes o pagamento usando o PagBank
​

**Pagador**: O usuário que quer comprar algo usando o app do Integrador
​
O integrador que tem interesse em oferecer pagamento via PagBank adiciona o SDK no seu projeto e com isso disponibiliza um botão no seu app que redireciona o pagamento para o app do PagBank via um deeplink. Dentro do app do PagBank o usuário seleciona a forma de pagamento e prossegue com o pagamento normalmente. Essa etapa dentro do app PagBank é invísivel para o integrador.
​
### Credenciais de Autenticação
As soluções públicas do PagSeguro requerem autenticação e através dela identificamos e autorizamos o integrador a utilizar nossas APIs e seus recursos, bem como eventuais configurações adicionais.
​

**Primeiro passo**: Ter uma conta PagSeguro
​
- Para criar uma conta no nosso ambiente de Sandbox [acesse o link](https://acesso.pagseguro.uol.com.br/sandbox)
​

**Segundo passo**: Criar uma aplicação para utilizar o pagar com PagBank.
- Mais informações sobre criação de aplicação [acesse o link](https://dev.pagseguro.uol.com.br/reference/connect-create-client)
​
___
​
## Requisitos
- Android 5.0+ (API 21)
​
## Instalação
Para integrar a biblioteca (SDK) em seu projeto, siga os passos abaixo.
1. Faça o download da versão mais recente da biblioteca.
2. Abra o projeto do seu aplicativo pelo Android Studio.
3. Arraste a arquivo .aar para dentro da pasta libs do seu projeto.
4. Integrar o sdk ao projeto no build.gradle do seu projeto :
​
```
implementation files('libs/pagpay-1.0.0.aar')
```
​
___
​
## Utilização
​
Para utilizar o botão no seu app realize a declaração em seu layout ([documentação](/docs/HOW_TO_USE.md) sobre como alterar as cores)
​
```xml
<com.pagpay.checkout.presentation.button.PagPayPaymentButton
                android:id="@+id/btn_pagbank_yellow"
                app:colorScheme="yellow"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
```

Realizando chamada do serviço:
​
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
​
1 - Primeiramente se cria um objeto do tipo `PagPay` usando um `PagPay.newBuilder()`.
​

2 - Os tipos `MerchantInfoRequest` e `PaymentRequest` estão sendo criados por funções utilitárias que preenchem esses tipos, que basicamente são [VOs](https://en.wikipedia.org/wiki/Value_object). Para entender o que é o objeto criado veja na [documentação](/docs/HOW_TO_USE.md).
​

3 - Após criado o objeto `PagPay` se chama o método `redirectPagBank`, o this é uma referência à classe que implementa a interface `CheckoutContract.CallBack`. Importante notar que o método `redirectPagbank` por baixo faz uma chamada de networking e se chamada da thread principal causa uma exceção, esse método precisa ser chamado em outra thread.
​​
## Ambientes disponíveis
​
Temos dois ambientes disponíveis, um para realizar os testes de integração e o de produção.

:warning: Para realizar a troca do ambiente, é só mudar o parâmetro no método `redirectPagBank` que é usado no momento da requisição
​
| Ambiente | Parâmetro|
|----------|----------|
| Sandbox | `payWithPagPayClient.redirectPagBank(this, Env.SANDBOX)` |
| Produção | `payWithPagPayClient.redirectPagBank(this, Env.PROD)` |

Para mais informações siga essa [documentação](/docs/SANDBOX.md).
​
## Verificação do status do pagamento
​
O PagSeguro poderá enviar notificações via webhook para seu ambiente sempre que um evento (uma mudança de status de transação) acontecer, possibilitando a automação de seus processos de gestão de vendas.
Para que isso aconteça basta atribuir suas urls de notificação no atributo `notificationUrls` do objeto `PaymentRequest`
​
Para mais informações de qual payload é enviado via url de notificação acesse o [link](https://dev.pagseguro.uol.com.br/reference/charge-webhook) para mais informações.

## Como realizar o estorno um pagamento recebido?

1. Acessando o iBanking no [link](https://acesso.pagseguro.uol.com.br/).
2. Você pode através do menu "Extratos e Relatórios" 
3. Acessar a opção "Extrato de Transações" e identificar a transação que deseja realizar o estorno. 
4. Ao acessar os detalhes da transação a opção de estorno estará disponível.