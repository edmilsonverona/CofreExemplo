package cofre;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ed_ve
 */
public class ValidacaoHelperCucumber {

    ValidacaoHelper validacaoHelper;
    String valor;

    @Given("^que eu entrei com o valor \"([^\"]*)\"$")
    public void que_eu_entrei_com_o_valor(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        valor = arg1;
    }

    @Then("^o resultado deve ser true$")
    public void o_resultado_deve_ser_true() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(ValidacaoHelper.ehNumero(valor));
    }

    @Then("^se senha deve ser valida$")
    public void se_senha_deve_ser_valida() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(ValidacaoHelper.ehSenhaValida(valor));
    }

}
