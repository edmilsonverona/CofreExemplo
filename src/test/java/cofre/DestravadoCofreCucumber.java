package cofre;

import cofre.CofrePM;
import cofre.CofrePMTest;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ed_ve
 */
public class DestravadoCofreCucumber extends CofrePMTest {

    public DestravadoCofreCucumber() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);
    }

    @Then("^destravar cofre$")
    public void destravar_cofre() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        verify(sensorMock).destravar();
    }

    @Then("^o display deve apresentar \"([^\"]*)\"$")
    public void o_display_deve_apresentar(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(arg1, cofrePM.getDisplay());
    }

    @When("^apertar o botão clear$")
    public void apertar_o_botão_clear() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        cofrePM.clear();
    }

    @Given("^apertar o botão (\\d+)$")
    public void apertar_o_botão(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        cofrePM.pressButton(arg1);
    }

    @When("^apertar o botão ok$")
    public void apertar_o_botão_ok() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        cofrePM.ok();
    }

    @Given("^abrir porta$")
    public void abrir_porta() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
    }

    @Given("^fechar porta$")
    public void fechar_porta() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
    }

    @Then("^o cofre deve travar$")
    public void o_cofre_deve_travar() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        verify(sensorMock).travar();
    }

    @Then("^gravar a senha \"([^\"]*)\"$")
    public void gravar_a_senha(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        verify(memoriaMock).salvarSenha(arg1);
    }

}
