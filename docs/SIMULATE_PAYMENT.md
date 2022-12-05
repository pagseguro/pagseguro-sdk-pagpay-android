## Simular pagamento no ambiente de Sandbox


Este endpoint possibilita a simulação de pagamento do deeplink, de acordo com os métodos de pagamento que o pagador queira utilizar (saldo ou cartão de crédito). Será possível simular o pagamento com sucesso e negado.


> :warning: Com o valor do parâmetro `deeplinkCode` iremos conseguir realizar a simulação dos pagamentos no ambiente de teste.

> :warning: No ambiente de simulação, os pedidos deverão ter valor entre R$ 1,00 e R$ 1.500,00.

### Simulando um pagamento com Saldo da Conta

Para simular o pagamento com Saldo da Conta, basta realizar a chamada abaixo onde o parametro `status-desejado` deve ser:

- `PAID` - para simular um pagamento com sucesso;
- `DECLINED` - para simular um pagamento rejeitado.

```console
curl --location --request POST 'https://sandbox.sdk.pagseguro.com/pagpay/balance/{deeplinkCode}' \
--header 'accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status":"{status-desejado}"
}'
```

### Simulando um pagamento com Cartão de Crédito

Para simular o pagamento com Cartão de crédito, basta realizar a chamada abaixo, onde o parametro `cartão-desejado` deve ser de acordo com a tabela a seguir:


| Número do cartão    |     Bandeira     | Status esperado da transação |
|---------------------|:----------------:|-----------------------------:|
| 4111111111111111    |       VISA       |                         PAID |
| 4242424242424242    |       VISA       |                     DECLINED |
| 5454555555555555    |    MASTERCARD    |                         PAID |
| 5454545454545454    |    MASTERCARD    |                     DECLINED |
| 378282246310005     | AMERICAN EXPRESS |                         PAID |
| 34343434343434      | AMERICAN EXPRESS |                         PAID |
| 3841001111222233334 |      HIPER       |                         PAID |
| 6550000000000001    |       ELO        |                         PAID |


```console
curl --location --request POST 'https://sandbox.sdk.pagseguro.com/pagpay/credit-card/{deeplinkCode}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "card_number": "{cartao_desejado}"
}'
```


### Tratamento de erros simulação de pagamento

Em caso de falhas no envio da requisição ou no processamento da mesma, é possível receber um código de erro 4XX ou 5XX com o seguinte payload:

```console
{
    "errors": [
        {
            "code": "<Código de erro>",
            "message": "<Mensagem do erro>"
        }
    ]
}
```

| Status Http | Código de Erro |                    Mensagem do erro |
|-------------|:--------------:|------------------------------------:|
| 400         |     40003      |                         Bad Request |
| 400         |     40005      | Invalid status payment confirmation |
| 400         |     40006      |         Invalid status mock payment |
| 400         |     40007      |          Invalid credit card number |
| 404         |     40401      |                    Object not found |
| 409         |     40901      |  Payment has already been processed |
| 410         |     41001      |    Deeplink is no longer accessible |
| 500         |     50001      |                    Unexpected error |
| 500         |     50002      |                   Integration error |
| 504         |     50401      |             Payment confirm timeout |