package stepdefinition;

import interaction.CargarPaginaPrincipal;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import page.YoutubePage;
import questions.ElementoEsVisible;
import task.EscribeTexto;
import task.clicks.DarClick;
import util.FormatoConsola;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginDefinition {

    @Managed
    WebDriver navegador;

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    private static final String BASE_URL_YOUTUBE = "https://www.youtube.com";

    @Given("usuario ingresa a la pagina de Youtube")
    public void UsuarioIngresaPaginaYoutube() {
        String entorno = BASE_URL_YOUTUBE;
        FormatoConsola.banner("ENTORNO DE PRUEBA : " + entorno);
        theActorCalled("Usuario").wasAbleTo(
                CargarPaginaPrincipal.EnLaUrl(
                        navegador,
                        entorno,
                        YoutubePage.CAMPO_BUSQUEDA,
                        2,
                        1
                )
        );
    }

    @When("usuario busca el video {string}")
    public void usuarioBuscaUnVideo(String video) {
        theActorInTheSpotlight().attemptsTo(EscribeTexto.enElElemento(YoutubePage.CAMPO_BUSQUEDA,video));
    }

    @When("presiono el boton buscar del video")
    public void PresionoBuscar(){
        theActorInTheSpotlight().attemptsTo(DarClick.enElElemento(YoutubePage.BOTON_BUSCAR));
    }

    @Then("valido los resultados del video encontrados")
    public void validoResultadosEncontrados() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(YoutubePage.RESULTADOS_CONTENEDOR_COMPLETO, 20, 3)),
                seeThat(ElementoEsVisible.EnElPage(YoutubePage.RESULTADO_PRIMERA_POSICION, 20, 3)));
    }
}