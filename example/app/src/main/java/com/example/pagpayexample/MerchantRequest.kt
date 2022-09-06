package com.example.pagpayexample

import com.pagpay.checkout.repository.remote.api.requests.*

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

    val amount = Amount(value = 5500, currency = "BRL")

    return PaymentsRequest(
        referenceId = "PEDIDO_123",
        amount = amount,
        shipping = shipping,
        notificationUrls = notificationUrls,
        items = items,
        redirectUrl = "https://meusite.com/pedidos/redirect"
    )
}