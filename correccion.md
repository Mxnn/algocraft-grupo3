## Carpeta

### Generalidades

###### ¿Son correctos los supuestos y extensiones?
**SI**

###### ¿Es prolija la presentación? (hojas del mismo tamaño, numeradas y con tipografía uniforme)
**SI**
* La sección modelo de dominio debería detallar cuáles son las principales entidades (objetos) y sus responsabilidades.

### Modelo

###### ¿Está completo? ¿Contempla la totalidad del problema?
**SI**
* Nombres en botones del panel de acciones debería ser el de las construcciones según su raza (ej: _Barraca_ en vez de _Creador Unidades Basicas_)

###### ¿Respeta encapsulamiento?
**SI**
* Interfases de observadores deberían estar definidas en el paquete del modelo (de otra forma clases del modelo _conocen_ objetos de la vista violando uno de los principios de MVC)
* `ObservadorMapa` es invocado por objetos que no son el `Mapa` (ej: `Barraca.crearMarine`)
* No debería ser responsabilidad del `Ataque` decidir si un ataque influye sobre una unidad que todavía no está creada, debería ser responsabilidad de la unidad hacer esta validación (`Ataque.ejecutarAtaque()`)

###### ¿Hace un buen uso de excepciones?
**SI**

###### ¿Utiliza polimorfismo en las situaciones esperadas?
**SI**

## Diagramas

### Diagrama de clases

###### ¿Está completo?
**SI**
* Faltan asociaciones (ej: `SistemaDeTurnos` con `Jugador` y con `Mapa`, `Jugador` con `Raza`, etc.)
* Faltan métodos en clases de la vista (diagrama "Class Diagram acciones.png")

###### ¿Está bien utilizada la notación?
**SI**
* No se debe incluir el atributo si ya se incluye la asociación en el diagrama (ej: `Juego.sistemaDeTurnos`)
* Métodos abstractos se notan con _itálica_ (ej: `ComandoAccionPorTurno.ejecutar()` en diagrama "comandos.jpg")

### Diagramas de secuencia

###### ¿Está completo?
**SI**
* Falta emisor del mensaje a `ParcelaVolcan` para que se dispare el mensaje _2: absorberGasVespeno_
* Diagramas duplicados con varias versiones (ej: "Atacar.png" y "AtacarNuevo.jpg")
* Falta emisor de mensaje _2: tareasDeEntreturno()_ en diagrama "AtacarNuevo.jpg"
* Diagramas que no aportan demasiada información (ej: "Mapa Devolver Elemento en Parcela.jpg") mientras que faltan otros que demuestren como es la secuencia para un proceso complejo (ej: ataques especiales, naves de transporte, secuencia completa desde la vista hasta el modelo, etc.)

###### ¿Es consistente con el diagrama de clases?
**SI**

###### ¿Está bien utilizada la notación?
**SI**
* Nombres de objetos deben seguir la convención _<nombre de la instancia>:<nombre de la clase>_ (ej: diagrama "Absorción de Gas con Jugador Terran.jpg")
* No es necesario hacer la secuencia de _setup_ del escenario si no aporta información, con especificar que el diagrama representa un escenario en _tal estado inicial_ es suficiente (ej: diagrama "Creacion Marine.png")

## Código

### Generalidades

###### ¿Respeta estándares de codificación?
**SI**
* Para implementar el patrón Singleton el método que crea la instancia debe ser privado (ej: `VistaJuego.createInstance()`)
* TODOs (ej: `ParcelaListener.actionPerformed()`)
* Mucho código comentado
* Nombres de clases no deberían hacer referencia a su implementación (ej: `VistaBotonAcceso` está diciendo que la vista está implementada con un botón lo cuál no es relevante para los objetos que lo utilicen)
* Tabulación del código inconsistente (a veces se usan espacios, a veces tabs)

###### ¿Está correctamente documentado?
**SI**
* Nombres de métodos de observadores no deberían hacer referencia la acción que se disparará de acuerdo a lo que sucedió (ej: `ObservadorMapa.crearVistaParcela(ParcelaEspacio parcela)` debería haber sido algo como `ObservadorMapa.nuevaParcelaCreada(ParcelaEspacio parcela)`), sino el modelo tiene un conocimiento ímplicito de que acciones desencadena en la vista un evento en el modelo.
* Nombres de clases deberían ser consistentes con sus responsabilidades, `ClickEnParcelaListener` no es un _listener_
* Clases en paquetes incorrectos (ej: `VistaJuego` pertenece al paquete `fiuba.algo3.algocraft.vista.observadores.juego` pero no es un _observador_)
* Código de observadores en el modelo no testeado

**NOTA: 8**