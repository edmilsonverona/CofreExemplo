package cofre;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
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
public class TravadoCofreCucumber extends CofrePMTest {

    public TravadoCofreCucumber() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.TRUE);
    }

    @When("^definir senha armazenada \"([^\"]*)\"$")
    public void definir_senha_armazenada(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        when(memoriaMock.getSenha())
                .thenReturn(arg1);
    }

    @Given("^teclar o numero (\\d+)$")
    public void teclar_o_numero(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        cofrePM.pressButton(arg1);
    }

    @When("^teclar o botão ok$")
    public void teclar_o_botão_ok() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        cofrePM.ok();
    }

    @Then("^o display deve mostrar \"([^\"]*)\"$")
    public void o_display_deve_mostrar(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(arg1, cofrePM.getDisplay());
    }


}
