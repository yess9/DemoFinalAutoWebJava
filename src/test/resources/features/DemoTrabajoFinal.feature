Feature: Búsqueda de productos y marcas en página de Inkafarma

  Background:
    Given que el usuario se encuentra en la página de búsqueda

  @HP
  Scenario Outline: Buscar producto existente por nombre exacto en Inkafarma
    When usuario busca el producto "<producto>"
    And presiono el boton buscar
    Then valido resultados encontrados

    Examples:
      | producto              |
      | Panadol 500mg Tableta |

  @HP
  Scenario Outline: Buscar utilizando una palabra parcial del producto en Inkafarma
    When usuario busca el producto "<producto>"
    And presiono el boton buscar
    Then valido resultados encontrados

    Examples:
      | producto |
      | panado   |

  @HP
  Scenario Outline: Buscar producto por marca exitente en Inkafarma
    When usuario busca el producto "<marca>"
    And presiono el boton buscar
    Then valido resultados encontrados

    Examples:
      | marca   |
      | eucerin |

  @HP
  Scenario Outline: Buscar utilizando una marca con mayúsculas y minúsculas diferentes
    When usuario busca el producto "<marca>"
    And presiono el boton buscar
    Then valido resultados encontrados

    Examples:
      | marca   |
      | Eucerin |


  @NP
  Scenario Outline: Buscar por producto que no existe en el catalogo
  When usuario busca el producto "<producto>"
  Then debería mostrar el mensaje "No encontramos productos que coincidan con “github”"

    Examples:
      | producto |     
      | github   |

  @NP
  Scenario Outline: Buscar con caracteres especiales no permitidos
  When busca el producto "<producto>"
  Then debería mostrar el mensaje "No encontramos productos que coincidan con “!@#$%^&*()”"

    Examples:
      | producto   |
      | !@#$%^&*() |

  @NP
  Scenario Outline: Buscar un producto descontinuado
    When busca el producto "<producto>"
    Then debería mostrar el mensaje "No encontramos productos que coincidan con “hibiclean espuma”"

    Examples:
      | producto         |
      | hibiclean espuma |

  @VN
  Scenario Outline: Validar que los productos muestran precio
    When busca el producto "<producto>"
    Then cada resultado deberia mostrar el nombre del producto
    And cada resultado deberia mostrar un precio mayor a cero

    Examples:
      | producto              |
      | Panadol 500mg Tableta |


  @VN
  Scenario Outline: Validar que el carrito muestra resumen de compra
    When busca el producto "<producto>"
    And agrega el primer producto disponible al carrito
    Then el icono del carrito deberia reflejar que tiene al menos un producto
    And da clic en el carrito
    And el resumen del carrito deberia mostrar el subtotal del pedido

    Examples:
      | producto              |
      | Panadol 500mg Tableta |




