

PagPay Android SDK

Introdução
O PagPay é o produto do PagSeguro que tem como foco auxiliar aos vendedores utilizar o app PagBank como método de pagamento no checkout do seu próprio aplicativo. Este produto confere mais praticidade e segurança aos vendedores devido aos padrões de validação de conta e cartões de crédito, adotados pelo PagBank.

Históricos de Versão
0.0.1 : Versão inicial publicada – 25/05/2021

Pré-requisitos
Para utilizar o PagPay, é necessário que o seu aplicativo seja desenvolvido em Kotlin Android.

Integrando o PagPay
Aqui vamos explicar como integrar a biblioteca (SDK) para o seu aplicativo.

1. Faça o download da versão mais recente da biblioteca.
2. Abra o projeto do seu aplicativo pelo Android Studio.
3. Arraste a arquivo pagpay.aar para dentro da pasta libs do seu projeto.
4. Integrar o sdk ao projeto no build.gradle do seu projeto :
   dependencies {
      implementation project(':pagpay')
   }

Implementando o botão Pagar com o PagBank
1. Importar o modulo PagPayPaymentButton dentro do seu layout XML:

    <com.pagpay.checkout.presentation.button.PagPayPaymentButton
        android:id="@+id/btpagbank"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
    </com.pagpay.checkout.presentation.button.PagPayPaymentButton>
           
2. Utilizando estilos do botão pagpay LIGHT e DARK:

// color defaut: PagBankpayColorScheme.WHITE
btpagbank.colorScheme = PagPayButtonScheme.SETUP_LIGHT_SCHEME
btpagbank.colorScheme = PagPayButtonScheme.SETUP_DARK_SCHEME

3. Criar um payload do tipo PagPayRequest.

val items: List<Items> = listOf(
  Items(
        reference = "REFERENCIA_123",
        name = "mochila",
        quantity = 1,
        unitAmount = 1000
    )
)

val notificationUrls: List<String> = listOf("https://meusite.com/pedidos/pagamentos")

val shipping: Shipping = Shipping(
    address = Address(
        street = "rua teste",
        number = "123",
        complement = "casa 1",
        city = "Salvador",
        country = "BRA",
        district = "BA",
        postalCode = "12345678",
        state = "BA"
    )
)
val customer: Customer = Customer("teste", "teste@samara.com.br", "32685508600")

val amount: Amount = Amount(value = 3500, currency = "BRL")

val paymentsRequest: PaymentsRequest = PaymentsRequest(
    referenceId = "PEDIDO_123",
    amount = amount,
    customer = null,
    shipping = shipping,
    notificationUrls = notificationUrls,
    items = items
)
4.Criar o payWithPagPayClient para acesso ao redirectPagBank.
       Obs: 'token' da PagSeguro que será configurado como vendedor (Seller).

val payWithPagPayClient = PagPay.newBuilder()
.clientPayments(paymentsRequest, "token", this)
    .build()
5. Dentro da função de clique do botão, chamar a função redirectPagBank .

btpagbank.setOnClickListener {
    payWithPagPayClient.redirectPagBank(this, Env.QA)
}
     6. Implementar o CheckouContract.CallBack na activity

override fun onSuccessToRedirect() {
}

override fun onErrorToRedirect(error: ErrorApi) {
}


Copyright
Todos os direitos reservados. O UOL é uma marca comercial do UNIVERSO ONLINE S / A. O logotipo do UOL é uma marca comercial do UNIVERSO ONLINE S / A. Outras marcas, nomes, logotipos e marcas são de propriedade de seus respectivos proprietários. As informações contidas neste documento pertencem ao UNIVERSO ONLINE S/A. Todos os direitos reservados. UNIVERSO ONLINE S/A. - Av. Faria Lima, 1384, 6º andar, São Paulo / SP, CEP 01452-002, Brasil. O serviço PagSeguro não é, nem pretende ser comparável a serviços financeiros oferecidos por instituições financeiras ou administradoras de cartões de crédito, consistindo apenas de uma forma de facilitar e monitorar a execução das transações de comércio electrónico através da gestão de pagamentos. Qualquer transação efetuada através do PagSeguro está sujeita e deve estar em conformidade com as leis da República Federativa do Brasil. Aconselhamos que você leia os termos e condições cuidadosamente.

Aviso Legal
O UOL não oferece garantias de qualquer tipo (expressas, implícitas ou estatutárias) com relação às informações nele contidas. O UOL não assume nenhuma responsabilidade por perdas e danos (diretos ou indiretos), causados por erros ou omissões, ou resultantes da utilização deste documento ou a informação contida neste documento ou resultantes da aplicação ou uso do produto ou serviço aqui descrito. O UOL reserva o direito de fazer qualquer tipo de alterações a quaisquer informações aqui contidas sem aviso prévio.

Conceitos Básicos
Antes de fazer uso da biblioteca é importante que o desenvolvedor realize alguns procedimentos básicos, além de assimilar alguns conceitos importantes para o correto funcionamento de sua aplicação. É necessário ter em mãos o token da PagSeguro que será configurado como vendedor (Seller).
UOL - O melhor conteúdo
© 1996-2021 O melhor conteúdo. Todos os direitos reservados. UNIVERSO ONLINE S/A - CNPJ/MF 01.109.184/0001-95 - Av. Brigadeiro Faria Lima, 1.384, São Paulo - SP - CEP 01452-002




