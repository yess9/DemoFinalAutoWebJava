Proyecto de automatización web, desarrollado con **Serenity BDD**, **Screenplay Pattern**, **Selenium WebDriver**, **Cucumber** y **Maven**, usando **Java 17**.


//📁 Estructura del Proyecto//

DEMOFINALAUTOWEBJAVA
│
├── src
│   ├── main
│   │   └── java
│   │       ├── task/                
│   │       └── util/                 
│   │
│   └── test
│       ├── java
│       │   ├── runner/              
│       │   └── stepdefinition/     
│       │
│       └── resources
│           ├── drivers/            
│           ├── features/            
│           └── serenity.conf       
│
├── target/                          
└── README.md                       

## 🧾 Escenarios de Prueba

### ✅ Casos Positivos (4)

| ID   | Descripción                                                         |
|----- |---------------------------------------------------------------------|
| HP01 | Buscar producto existente por nombre exacto en Inkafarma            | 
| HP02 | Buscar utilizando una palabra parcial del producto en Inkafarmau    | 
| HP03 | Buscar producto por marca exitente en Inkafarma                     |
| HP04 | Buscar utilizando una marca con mayúsculas y minúsculas diferentes |

### ❌ Casos Negativos (3)

| ID   | Descripción                                                          | 
|----- |----------------------------------------------------------------------|
| NP01 | Buscar por producto que no existe en el catalogo                     |
| NP02 | Buscar con caracteres especiales no permitidos                       |
| NP03 | Buscar un producto descontinuado                                     |

### 💼 Validaciones de Negocio (2)

| ID   | Descripción                                                          | 
|------|----------------------------------------------------------------------|
| VN01 | Validar que los productos muestran precio                            |
| VN02 | Validar que el carrito muestra resumen de compra                     |

---

## ✅ Prerrequisitos

- **Java 17** o superior instalado
- **Maven 3.9+** instalado
- **Google Chrome** instalado (WebDriverManager descarga el driver automáticamente)
- **Git** instalado
- **Github** instalado

Verificar instalaciones:
```bash
java -version
mvn -version
google-chrome --version
```

---

## 🚀 Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/AUTOMATIZACION-WEB-JAVA.git
```

### 2. Instalar dependencias

```bash
mvn clean install -DskipTests
```

### 3. Ejecutar todos los escenarios

```bash
mvn clean verify
```

### 4. Ejecutar por tag específico

```bash
# Solo casos positivos
mvn clean verify -Dcucumber.filter.tags="@HP"

# Solo casos negativos
mvn clean verify -Dcucumber.filter.tags="@NP"

# Solo validaciones de negocio
mvn clean verify -Dcucumber.filter.tags="@VN"

```

### 5. Ejecutar en modo headless

```bash
mvn clean verify -Denvironment=headless
```

---

## 📊 Reporte Serenity

Al finalizar la ejecución, Serenity genera el reporte automáticamente en:

```
target/site/serenity/index.html
```


Para regenerar el reporte sin ejecutar los tests:
```bash
mvn serenity:aggregate
```

---

## 👤 Autor

Proyecto desarrollado como ejercicio académico de QA Automatización.
