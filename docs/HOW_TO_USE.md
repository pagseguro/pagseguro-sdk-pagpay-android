# Como usar

Esse arquivo entra em um pouco mais de detalhes da parte de código do SDK.

## Como trocar a cor do botão

O `PagPayPaymentButton` tem um atributo chamado `colorScheme` que aceita cores pré-definidas de acordo com a identidade visual do PagBank que você pode alterar para encaixar na identidade visual do seu aplicativo. É importante notar que ele só aceita essas cores e não cores determinadas pelo integrador. Para usar o atributo é simples:

```XML
<com.pagpay.checkout.presentation.button.PagPayPaymentButton
                app:colorScheme="yellow"
```

Segue a lista de possíveis valores e sua visualização:

### Yellow
![](images/example_yellow_button.png)

```xml
app:colorScheme="yellow"
```

### Light Green
![](images/example_light_green_button.png)

```xml
app:colorScheme="light_green"
```

### Green
![](images/example_green_button.png)

```xml
app:colorScheme="green"
```

### Dark
![](images/example_dark_button.png)

```xml
app:colorScheme="dark"
```

### Light
![](images/example_light_button.png)

```xml
app:colorScheme="light"
```

---

## Parâmetros de entrada das classes da requisição

|      Campo       |              Tipo               | Obrigatório |                                               Descrição                                               |
|------------------|---------------------------------|-------------|-------------------------------------------------------------------------------------------------------|
|   └──└──street   |    String (1-160 caracteres)    |     Sim     |                                 Rua do endereço de entrega do pedido                                  |
|   └──└──state    |             String              |     Sim     |                 Código do Estado do endereço de entrega do pedido. Padrão ISO 3166-2                  |
| └──└──postalCode |      String (8 caracteres)      |     Sim     |                                 CEP do endereço de entrega do pedido                                  |
|   └──└──number   |    String (1-20 caracteres)     |     Sim     |                                Número do endereço de entrega do pedido                                |
|  └──└──district  |    String (1-60 caracteres)     |     Sim     |                                Bairro do endereço de entrega do pedido                                |
|  └──└──country   |             String              |     Sim     |               Código do País do endereço de entrega do pedido. Padrão ISO 3166-1 alfa-3               |
| └──└──complement |    String (1-40 caracteres)     |     Não     |                             Complemento do endereço de entrega do pedido                              |
|    └──└──city    |    String (1-90 caracteres)     |     Sim     |                                Cidade do endereço de entrega do pedido                                |
|     └──value     | Int (min = 1, max = 999999900)  |     Sim     |                                            Valor do pedido                                            |
|  └──unitAmount   | Int (min = 1, max = 999999900 ) |     Sim     |                                             Valor do item                                             |
|     └──taxId     |    String (11/14 caracteres)    |     Sim     |                                   Documento do comprador (CPF/CNPJ)                                   |
|   └──reference   |    String (1-255 caracteres)    |     Não     |                             Identificador próprio atribuído para o item                               |
|   └──quantity    |    Int (min = 1, max = 999)     |     Sim     |                                          Quantidade do item                                           |
|     └──name      |    String (1-120 caracteres)    |     Sim     |                                           Nome do comprador                                           |
|     └──name      |   String (1-100  caracteres)    |     Sim     |                                             Nome do item                                              |
|     └──email     |    String (1-64 caracteres)     |     Sim     |                                          E-mail do comprador                                          |
|   └──currency    |             String              |     Sim     |                      Sigla da moeda que representa o valor do pedido. Fixo "BRL"                      |
|    └──address    |             Object              |     Sim     |                    Objeto contendo as informações de endereço de entrega do pedido                    |
|     shipping     |             Object              |     Não     |                          Objeto contendo as informações de entrega do pedido                          |
|   referenceId    |    String (1-200 caracteres)    |     Sim     |                             Identificador próprio atribuído para o pedido                             |
| notificationUrls |         Array of String         |     Sim     | Objeto contendo as urls que receberão as notificações do pedido (por ora, somente aceitamos uma url.) |
|      items       |         Array of Object         |     Sim     |                     Objeto contendo as informações dos itens inseridos no pedido                      |
|     customer     |             Object              |     Não     |                              Objeto contendo as informações do comprador                              |
|      amount      |             Object              |     Sim     |             Objeto contendo as informações do valor a ser utilizado na criação do pedido              |

