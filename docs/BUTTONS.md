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