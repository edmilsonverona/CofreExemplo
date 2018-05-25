# language: en
Feature: travadoCofre
  Funções quando o cofre esta travado

  Scenario: teste de digitar senha invalida
    When definir senha armazenada "123456"
    Given teclar o numero 1
    And teclar o numero 2
    And teclar o numero 3
    And teclar o numero 4
    And teclar o numero 5
    And teclar o numero 6
    And teclar o numero 6
    When apertar o botão ok
    Then o display deve mostrar "1234566"
    When teclar o botão ok
    Then o display deve mostrar "senha errada. Tente novamente"

  Scenario: teste de digitar senha com menos de seis numeros
    When definir senha armazenada "123456"
    Given teclar o numero 1
    Then o display deve mostrar "1"
    When teclar o botão ok
    Then o display deve mostrar "senha errada. Tente novamente"
    Given teclar o numero 1
    And teclar o numero 1
    Then o display deve mostrar "11"
    When teclar o botão ok
    Then o display deve mostrar "senha errada. Tente novamente"

  Scenario: teste de digitar senha valida
    When definir senha armazenada "1234566"
    Given teclar o numero 1
    And teclar o numero 2
    And teclar o numero 3
    And teclar o numero 4
    And teclar o numero 5
    And teclar o numero 6
    And teclar o numero 6
    Then o display deve mostrar "1234566"
    When teclar o botão ok
    Then o display deve mostrar "senha correta. Cofre aberto"
    And destravar cofre
    
