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

* [Como usar os botões](/docs/BUTTONS.md)
* [Como criar uma requisição de pagamento](/docs/HOW_TO_USE.md)

---

## Ambientes disponíveis
​
Temos dois ambientes disponíveis, um para realizar os testes de integração e o de produção.

:warning: Para realizar a troca do ambiente, é só mudar o parâmetro no método `redirectPagBank` que é usado no momento da requisição
​
| Ambiente | Parâmetro|
|----------|----------|
| Sandbox | `payWithPagPayClient.redirectPagBank(this, Env.SANDBOX)` |
| Produção | `payWithPagPayClient.redirectPagBank(this, Env.PROD)` |

:warning: Depois da criação do pedido no ambiente de `SANDBOX`, você pode simular o pagamento seguindo essa [documentação](https://dev.pagseguro.uol.com.br/reference/pagando-um-pedido-com-deeplink-em-sandbox) :warning:​
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

Para mais informações sobre outra forma de integração acesse nossa [documentação](https://dev.pagseguro.uol.com.br/reference/criando-um-pedido-com-deeplink-pagar-com-pagbank)

<br>

Licença
=======

    Copyright 2022 PagSeguro Internet LTDA.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
