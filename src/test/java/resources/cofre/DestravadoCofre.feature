# language: en
Feature: destravadoCofre
  Funções quando o cofre esta destravado

  Scenario: teste de inicializacao
    Then o display deve apresentar "Entre com a senha 6 digitos"
    And destravar cofre

  Scenario: teste ao apertar o botão Clear
    When apertar o botão clear
    Then o display deve apresentar ""

  Scenario: teste de porta não fechada
    When abrir porta 
    Given apertar o botão 1
    Then o display deve apresentar "Feche a porta antes de digitar a senha"

  Scenario: teste de digitar um numero com a porta fechada
    When fechar porta
    Given apertar o botão 0
    Then o display deve apresentar "0"

  Scenario: teste de gravar senha valida com a porta fechada e destravada
    When fechar porta
    Given apertar o botão 1
    And apertar o botão 9
    And apertar o botão 3
    And apertar o botão 5
    And apertar o botão 6
    And apertar o botão 6
    When apertar o botão ok
    Then o display deve apresentar "Senha salva. Cofre trancado"
    And o cofre deve travar
    And gravar a senha "193566"

  Scenario: teste de digitar senha com menos de seis numeros
    When fechar porta
    Given apertar o botão 0
    And apertar o botão 1
    When apertar o botão ok
    Then o display deve apresentar "senha precisa de 6 digitos. Tente novamente"

  Scenario: teste de digitar numero com a porta fechada e depois abrir e digitar
    When fechar porta
    Given apertar o botão 9
    And apertar o botão 8
    Then o display deve apresentar "98"
    And abrir porta 
    Given apertar o botão 7
    Then o display deve apresentar "Feche a porta antes de digitar a senha"
    When fechar porta
    Given apertar o botão 7
    Then o display deve apresentar "7"
    
