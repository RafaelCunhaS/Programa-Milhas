### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

## Programa de fidelidade (milhas)

Que jornada até aqui, hein? 🤩

Olha... Estamos adorando ver sua evolução. Depois de tantas horas de Java e algumas de Quarkus, queremos te propor um desafio um pouco maior agora. Simbora?

Você foi contratado por uma empresa que está criando o seu programa de fidelidade, nos moldes de um programa de milhagem. Clientes da empresa podem receber milhas, transferir para outra pessoa ou resgatar em algum produto ou serviço.

O sistema tem cinco tabelas:
- Pessoa
- Lancamento
- TipoLancamento
- Produto
- Parceiro

Essas tabelas estão disponíveis num banco H2 em memória que sobe junto com a aplicação. Caso queira conferir a criação e os dados iniciais de cada tabela, veja o arquivo `cargainicial.sql`, dentro da pasta de resources. Os domínios "TipoLancamento", "Produto" e "Parceiro" já estão com seus dados cadastrados. Para facilitar os testes e o uso, o sistema inicia com duas pessoas e um lançamento de crédito de 10 mil milhas para cada uma:

- Login huguinho / Senha: root
- Login zezinho / Senha: senha

Você vai receber o sistema em um estágio mediano de desenvolvimento, e sua tarefa é implementar as funcionalidades necessárias para que todos os testes passem. Fechou?

Existem três papéis de uso do sistema: admin, pessoa usuária e público. 

O papel de admin é usado por outro sistema para se comunicar com o seu. Os endpoints de admin incluem listagem dos domínios (um domínio é uma lista de código e nome/descrição), consulta de todos os saldos de todas as pessoas usuárias, resgate de pontos com valor variável e crédito de pontos. Os endpoints de admin possuem um parâmetro de query chamado "token", cujo valor deve ser **sempre** `4dmt0k3n!`.

O papel de pessoa usuária dá acesso aos endpoints de gestão de sua própria conta: depois de usar o endpoint de login para criar um token pessoal, é possível transferir pontos para outra conta, resgatar pontos na aquisição de produtos ou serviços, consultar saldo, extrato e encerrar conta. Esse papel só permite alterações na conta na qual foi feito o login!

No modo público, apenas o endpoint/echo que responde `Olá!` serve para garantirmos que a aplicação está funcionando.

Vamos aos requisitos (que listamos aqui, mas você pode também inferir dos testes!):

- Tentativa de acessar endpoints fechados com o token ausente ou inválido devem resultar em erro 500 com a mensagem `Acesso não autorizado.`
- Tentativa de login com qualquer informação incorreta deve resultar em erro 500 com a mensagem `Autenticacão inválida.`
- Tentativa de retirada em conta com saldo inferior ao da retirada deve resultar em erro 500 com a mensagem `Saldo insuficiente.`
- Lançamentos podem possuir valores **positivos** ou **negativos** na base de dados, mas na nossa API sempre vão chegar **positivos**. Tome cuidado com retiradas e transferências!
- O arquivo `openapi-programa-milhas.txt` na raiz do projeto é a especificação Open API completa para o sistema.



Pronto? Então valendo! 🕗

---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---