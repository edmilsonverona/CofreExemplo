# language: en
Feature: validação
Verificar se é numero e se a senha é válida

    Scenario: testar se ehNumero
      Given que eu entrei com o valor "123"
      Then o resultado deve ser true

    Scenario: testar se ehSenhaValida
      Given que eu entrei com o valor "123456"
      Then se senha deve ser valida
