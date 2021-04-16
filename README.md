![LogoPagSeguro](https://user-images.githubusercontent.com/68859160/114778858-c77e8e00-9d4b-11eb-8c67-e97eade6534f.png)


# PagPay Android SDK
---
## Introdução
O PagPay é o produto do PagSeguro que permite aos vendedores utilizar o app PagBank como método de pagamento no checkout do seu próprio aplicativo. Este produto confere mais segurança aos vendedores devido aos padrões de validação de conta e cartões de crédito, adotados pelo PagBank. 

![botoesPagPay](https://user-images.githubusercontent.com/68859160/114779051-fb59b380-9d4b-11eb-8f93-23b4c7e7c0d9.png)

---
## Conceitos Básicos

Antes de fazer uso da biblioteca é importante que o desenvolvedor realize alguns procedimentos básicos, além de assimilar alguns conceitos importantes para o correto funcionamento de sua aplicação. É necessário ter em mãos o token da conta PagSeguro que será configurado como vendedor (Seller), tal token pode ser obtido no ibanking do PagSeguro.

___
## Históricos de Versão
* 0.0.1 : **Versão inicial publicada** - 25/05/2021

---
## Pré-requisitos
* Para utilizar o PagPay, é necessário que o seu aplicativo seja desenvolvido em Kotlin ou Java.

---
## Integrando o PagPay
Para integrar a biblioteca (SDK) em seu projeto, siga os passos abaixo.
1. Faça o download da versão mais recente da biblioteca.
2. Abra o projeto do seu aplicativo pelo Android Studio.
3. Arraste a arquivo pagpay.aar para dentro da pasta libs do seu projeto.
4. Integrar o sdk ao projeto no build.gradle do seu projeto :

   dependencies {
      implementation project(':pagpay')
   }
___
## Instalação
Saiba como utilizar o PagPay no seu aplicativo Android lendo esta [documentação](https://confluence.intranet.uol.com.br/confluence/pages/viewpage.action?spaceKey=PSPAGDIG&title=Integrando+com+a+wallet+app2app).

___
## Copyright

Todos os direitos reservados. O UOL é uma marca comercial do UNIVERSO ONLINE S / A. O logotipo do UOL é uma marca comercial do UNIVERSO ONLINE S / A. Outras marcas, nomes, logotipos e marcas são de propriedade de seus respectivos proprietários. As informações contidas neste documento pertencem ao UNIVERSO ONLINE S/A. Todos os direitos reservados. UNIVERSO ONLINE S/A. - Av. Faria Lima, 1384, 6º andar, São Paulo / SP, CEP 01452-002, Brasil. O serviço PagSeguro não é, nem pretende ser comparável a serviços financeiros oferecidos por instituições financeiras ou administradoras de cartões de crédito, consistindo apenas de uma forma de facilitar e monitorar a execução das transações de comércio electrónico através da gestão de pagamentos. Qualquer transação efetuada através do PagSeguro está sujeita e deve estar em conformidade com as leis da República Federativa do Brasil. Aconselhamos que você leia os termos e condições cuidadosamente.
___
## Aviso Legal

O UOL não oferece garantias de qualquer tipo (expressas, implícitas ou estatutárias) com relação às informações nele contidas. O UOL não assume nenhuma responsabilidade por perdas e danos (diretos ou indiretos), causados por erros ou omissões, ou resultantes da utilização deste documento ou a informação contida neste documento ou resultantes da aplicação ou uso do produto ou serviço aqui descrito. O UOL reserva o direito de fazer qualquer tipo de alterações a quaisquer informações aqui contidas sem aviso prévio.
