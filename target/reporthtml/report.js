$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/SimplesLogin.feature");
formatter.feature({
  "name": "ação de Login",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "login bem-sucedido credenciais válidas",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que o usuário navegue",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepsDefinition.queOUsuárioNavegue()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "digite  email e senha",
  "keyword": "Quando "
});
formatter.match({
  "location": "StepsDefinition.digiteEmailESenha()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seguida a mensagem com sucesso",
  "keyword": "Então "
});
formatter.match({
  "location": "StepsDefinition.seguidaAMensagemComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Logout bem-sucedido",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "clicar sair",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepsDefinition.clicarSair()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a mensagem exibida Saiu",
  "keyword": "Então "
});
formatter.match({
  "location": "StepsDefinition.aMensagemExibidaSaiu()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});