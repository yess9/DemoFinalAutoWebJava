package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InkafarmaPage extends PageObject {
    //BARRA BUSQUEDA//

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo para buscar producto")
            .located(By.xpath("//input[contains(@placeholder,'Busca') or contains(@class,'search') or @type='search'][1]"));
    
    public static final Target BOTON_BUSCAR = Target.the("Boton busqueda de productos")
            .located(By.xpath("//button[@type='submit' or contains(@class,'search')][1]"));

    //RESULTADOS DE BUSQUEDA//
    public static final Target LISTA_PRODUCTOS = Target.the("Lista de productos")
            .located(By.xpath("//body//div[@class or @id][contains(@class, 'product') or contains(@class, 'result') or contains(@id, 'product')]"));

    public static final Target PRIMER_PRODUCTO = Target.the("Primer producto")
            .located(By.xpath("(//body//div[@class or @id][contains(@class, 'product') or contains(@class, 'result') or contains(@id, 'product')])[1]"));

    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre del producto")
            .located(By.xpath("//p[contains(@class,'product')] | //h2 | //h3 | //span[@class='product-name']"));

    public static final Target PRECIO_PRODUCTO = Target.the("El precio del producto")
            .located(By.xpath("//span[contains(text(),'S/')] | //span[contains(@class,'price')] | //div[@class='price']"));


    //MENSAJE SIN RESULTADO//

    public static final Target MENSAJE_SIN_RESULTADOS = Target.the("Mensaje sin resultados")
            .located(By.xpath("//body//*[contains(., 'productos')]"));

    //CARRRITO//

    public static final Target BOTON_AGREGAR_CARRITO = Target
            .the("Botón agregar al carrito")
            .located(By.xpath("(//button[.//div[contains(text(),'Agregar al carrito')]])[1]"));

    public static final Target ICONO_CARRITO = Target
            .the("Ícono del carrito en el header")
            .located(By.xpath("//i[contains(@class,'cart')] | //svg[contains(@class,'cart')] | //button[contains(@class,'cart')]"));

    public static final Target CONTADOR_CARRITO = Target
            .the("Contador de ítems en el carrito")
            .located(By.xpath("//span[contains(@class,'count') or contains(@class,'badge')] | //*[@id='cart-count']"));

    public static final Target SUBTOTAL_CARRITO = Target
            .the("Subtotal del carrito")
            .located(By.xpath("//div[contains(text(),'Subtotal')]"));

}
