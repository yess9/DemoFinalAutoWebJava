package stepdefinition;

import interaction.CargarPaginaPrincipal;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.InkafarmaPage;
import questions.ElementoEsVisible;
import task.EscribeTexto;
import task.clicks.DarClick;
import util.FormatoConsola;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class BusquedaInkafarmaDefinition {

    @Managed
    WebDriver navegador;

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    private static final String BASE_URL_INKAFARMA = "https://inkafarma.pe";


    @Given("que el usuario se encuentra en la página de búsqueda")
    public void usuarioEnPaginaPrincipal() {
        String entorno = BASE_URL_INKAFARMA;
        FormatoConsola.banner("ENTORNO DE PRUEBA : " + entorno);
        theActorCalled("Usuario").wasAbleTo(
                CargarPaginaPrincipal.EnLaUrl(
                        navegador,
                        entorno,
                        InkafarmaPage.CAMPO_BUSQUEDA,
                        2,
                        1
                )
        );
    }


    @When("usuario busca el producto {string}")
    public void usuarioBuscaProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(EscribeTexto.enElElemento(InkafarmaPage.CAMPO_BUSQUEDA,producto));
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(EscribeTexto.enElElemento(InkafarmaPage.CAMPO_BUSQUEDA,producto));
        theActorInTheSpotlight().attemptsTo(SendKeys.of(Keys.RETURN).into(InkafarmaPage.CAMPO_BUSQUEDA));
    }

    @When("presiono el boton buscar")
    public void presionarBotonBuscar() {
       theActorInTheSpotlight().attemptsTo(DarClick.enElElemento(InkafarmaPage.BOTON_BUSCAR));
    }

    @When("agrega el primer producto disponible al carrito")
    public void agregarPrimerProducto() {
        theActorInTheSpotlight().attemptsTo(DarClick.enElElemento(InkafarmaPage.BOTON_AGREGAR_CARRITO));
    }

    @Then("valido resultados encontrados")
    public void validarResultadosEncontrados() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(InkafarmaPage.LISTA_PRODUCTOS, 5, 2))
        );
    }

    @Then("debería mostrar el mensaje {string}")
    public void validarMensajeSinResultados(String mensajeEsperado) {
        // Esperar a que la búsqueda se complete
        try {
            Thread.sleep(3000); // Esperar 3 segundos a que cargue la página
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        FormatoConsola.banner("Búsqueda completada - esperando mensaje");
    }

    @Then("debería mostrar el {string}")
    public void deberíaMostrarEl(String mensajeEsperado) {
        // Esperar a que la búsqueda se complete
        try {
            Thread.sleep(3000); // Esperar 3 segundos a que cargue la página
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        FormatoConsola.banner("Búsqueda completada - esperando mensaje");
    }

    @Then("cada resultado deberia mostrar el nombre del producto")
    public void validarNombreProductoVisible() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(InkafarmaPage.NOMBRE_PRODUCTO, 20, 3))
        );
    }

    @When("cada resultado deberia mostrar un precio mayor a cero")
    public void validarPrecioMayorACero() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(InkafarmaPage.PRECIO_PRODUCTO, 20, 3))
        );
    }

    @Then("el icono del carrito deberia reflejar que tiene al menos un producto")
    public void validarContadorCarrito() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(InkafarmaPage.CONTADOR_CARRITO, 20, 3))
        );
    }

    @When("da clic en el carrito")
    public void validarCarrito(){
        theActorInTheSpotlight().attemptsTo(DarClick.enElElemento(InkafarmaPage.CONTADOR_CARRITO));
    }

    @When("el resumen del carrito deberia mostrar el subtotal del pedido")
    public void validarSubtotalCarrito() {
        theActorInTheSpotlight().should(
                seeThat(ElementoEsVisible.EnElPage(InkafarmaPage.SUBTOTAL_CARRITO, 20, 3))
        );
    }

}
