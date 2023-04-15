# language: pt

Funcionalidade: ação de Login

Cenário: login bem-sucedido credenciais válidas 
Dado que o usuário navegue
Quando digite  email e senha
Então seguida a mensagem com sucesso

Cenário: Logout bem-sucedido
Dado clicar sair
Então a mensagem exibida Saiu
