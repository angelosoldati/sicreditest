Para efetuar os testes da tarefa proposta foram mapeados os casos mais importantes de utilização do usuário. 
Após detectar os cenários, para estes, foram escritos testes funcionais com a utilização de BDD, para que fique documentado de forma prática para automatizar. 
A automação foi feita com o Java + Junit + Selenium, assim, sempre que necessário, os casos de testes podem ser executados novamente, sem a necessidade de teste manual
Também foram criados testes automatizados para a API, utilizando Java + RestAssured, para garantir que mudanças de infra e lógica não impactem nos serviços

Cenários Detectados: 

1- Simulação com dados válidos
2- Simulação sem dados obrigatórios
3- Simulação com dados inválidos
4- Simulação básica pessoa juridica
5- Simulação básica tempo em anos
6- Botão Limpar Dados
7- Validação valor de investimento inferior há 20 reais
8- Validação valor de recorrencia inferior há 20 reais

((Sugestão - na validação de anos, informar para o usuário o tempo máximo que ele pode colocar no campo))

Forám criados BDD de três cenários, apenas para demonstrar os conhecimentos. 

-------------------------------------------------------------------------------------------
Critério de Aceite 1: Simulação com dados válidos
Cenário: Associado faz uma simulação preenchendo todos os dados válidos

Dado: que sou associado
E: o valor de aplicação é ígual há R$20,00
E: o valor poupado é ígual há R$20,00
E: o tempo de aplicação seja de 1 mês
Quando: eu efetuar uma simulação
Então: devo visualizar o valor que terei guardado nesse periodo
E: uma lista com tempo em meses e valor de rendimento projetado
--------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------
Critério de Aceite 2: Simulação com dados inválidos
Cenário: Associado faz uma simulação preenchendo todos os dados inválidos

Dado: que sou associado
E: no valor de aplicação é digitado texto
E: no valor poupado é digitado texto
E: no tempo de aplicação é digitado texto
Quando: eu efetuar uma simulação
Então: o sistema deve criticar os campos de preenchimento obrigatório
--------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------
Critério de Aceite 3: Simulação sem dados obrigatórios
Cenário: Associado faz uma simulação não preenchendo todos os dados obrigatórios

Dado: que sou associado
E: o valor de aplicação é inferior há R$20,00
E: o valor poupado é inferior há R$20,00
Quando: eu efetuar uma simulação
Então: o sistema deve criticar que o valor mínimo de aplicação é de R$20,00 reais
E: criticar que o valor mínimo poupado é de R$20,00 reais
--------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------
Na pasta SimuladorSicredi estão três testes automatizados desenvolvidos em java

- testaSimulacaoCorreta
- testaValidaçãoValorMinimo
- testaLimparDados
--------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------
Na pasta RestSicredi estão três testes de serviço desenvolvidos em java

- ValidarStatus
- ValidarHeader
- ValidarResposta
--------------------------------------------------------------------------------------------
