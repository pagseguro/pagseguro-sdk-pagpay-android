# PagPay Android SDK
## Introdução
O Pagar com PagBank é o produto do PagSeguro que permite aos vendedores utilizar o app PagBank como método de pagamento no checkout do seu próprio aplicativo. Este produto confere mais segurança aos vendedores devido aos padrões de validação de conta e cartões de crédito, adotados pelo PagBank.

## SDK
O SDK disponibiliza um botão de pagamentos que facilita a integração do Merchant, através de suas credenciais pode enviar os dados do seu pedido e nosso SDK irá realizar a integração com nossos serviços.

---

## Como Funciona

### Conceitos

Segue alguns termos usados nessa documentação:

**Integrador**: O desenvolvedor que vai usar o SDK em seu projeto para que possa oferecer para seus clientes o pagamento usando o PagBank

**Pagador**: O usuário que quer comprar algo usando o app do Integrador

O integrador que tem interesse em oferecer pagamento via PagBank adiciona o SDK no seu projeto e com isso disponibiliza um botão no seu app que redireciona o pagamento para o app do PagBank via um deeplink. Dentro do app do PagBank o usuário seleciona a forma de pagamento e prossegue com o pagamento normalmente. Essa etapa dentro do app PagBank é invísivel para o integrador.

## Pré-requisitos
Antes de fazer uso da biblioteca é importante que o integrador realize alguns procedimentos básicos. É necessário ter em mãos o token da conta PagSeguro que será configurado como vendedor (Seller), tal token pode ser obtido no ibanking do PagSeguro.

### Credenciais de Autenticação
As soluções públicas do PagSeguro requerem autenticação e através dela identificamos e autorizamos o integrador a utilizar nossas APIs e seus recursos, bem como eventuais configurações adicionais.


**Primeiro passo**: Ter uma conta PagSeguro
Para criar uma conta no nosso ambiente de Sandbox, acesse o link https://acesso.pagseguro.uol.com.br/sandbox

**Segundo passo**: Criar uma Aplicação para utilizar o pagar com PagBank.
acesse o link: https://dev.pagseguro.uol.com.br/reference/connect-create-client

---

## Integrando o PagPay
Para integrar a biblioteca (SDK) em seu projeto, siga os passos abaixo.
1. Faça o download da versão mais recente da biblioteca.
2. Abra o projeto do seu aplicativo pelo Android Studio.
3. Arraste a arquivo .aar para dentro da pasta libs do seu projeto.
4. Integrar o sdk ao projeto no build.gradle do seu projeto :

```
implementation files('libs/pagpay-1.0.0.aar')
```

___
## Instalação
Para utilizar o botão no app é possível declarar no layout:
```xml
<com.pagpay.checkout.presentation.button.PagPayPaymentButton
                android:id="@+id/btn_pagbank_yellow"
                app:colorScheme="yellow"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
```

No código

```java
val payWithPagPayClient = PagPay.newBuilder()
    .merchantInfo(createMerchantInfoRequest())
    .paymentRequest(createPaymentRequest(), this)
    .build()

payWithPagPayClient.redirectPagBank(this, Env.QA)

override fun onSuccessToRedirect(deepLinkCode: String) {
}

override fun onErrorToRedirect(error: ErrorApi) {
}
```

Primeiramente se cria um objeto do tipo `PagPay` usando um `PagPay.newBuilder()`. Os tipos `MerchantInfoRequest` e `PaymentRequest` estão sendo criados por funções utilitárias que preenchem esses tipos, que basicamente são [VOs](https://en.wikipedia.org/wiki/Value_object). Após criado o objeto `PagPay` se chama o método `redirectPagBank`, o this é uma referência à classe que implementa a interface `CheckoutContract.CallBack`. Importante notar que o método `redirectPagbank` por baixo faz uma chamada de networking e se chamada da thread principal causa uma exceção, esse método precisa ser chamado em outra thread.

___
## Copyright

Todos os direitos reservados. O UOL é uma marca comercial do UNIVERSO ONLINE S / A. O logotipo do UOL é uma marca comercial do UNIVERSO ONLINE S / A. Outras marcas, nomes, logotipos e marcas são de propriedade de seus respectivos proprietários. As informações contidas neste documento pertencem ao UNIVERSO ONLINE S/A. Todos os direitos reservados. UNIVERSO ONLINE S/A. - Av. Faria Lima, 1384, 6º andar, São Paulo / SP, CEP 01452-002, Brasil. O serviço PagSeguro não é, nem pretende ser comparável a serviços financeiros oferecidos por instituições financeiras ou administradoras de cartões de crédito, consistindo apenas de uma forma de facilitar e monitorar a execução das transações de comércio electrónico através da gestão de pagamentos. Qualquer transação efetuada através do PagSeguro está sujeita e deve estar em conformidade com as leis da República Federativa do Brasil. Aconselhamos que você leia os termos e condições cuidadosamente.
___
## Aviso Legal

O UOL não oferece garantias de qualquer tipo (expressas, implícitas ou estatutárias) com relação às informações nele contidas. O UOL não assume nenhuma responsabilidade por perdas e danos (diretos ou indiretos), causados por erros ou omissões, ou resultantes da utilização deste documento ou a informação contida neste documento ou resultantes da aplicação ou uso do produto ou serviço aqui descrito. O UOL reserva o direito de fazer qualquer tipo de alterações a quaisquer informações aqui contidas sem aviso prévio.
