## 17/6

* Métodos que devuelven `null` en `Raza` deberían ser abstractos?
* Paquetes: sería probablemente más clara la separación si se usa un único paquete raíz para todas las clases del modelo
* Generación del mapa hardcodeada (sería bueno que fuera aleatoriamente generado)
* Métodos `getConstrucciones()` / `getUnidades()` / `getAtaques()` de `Jugador` rompen encapsulamiento y permiten que se modifique el estado del objeto (modificando el atributo colección) sin utilizar el comportamiento definido por el objeto.
* Son necesarios los métodos `getListDeUnidadesQueDebenMoverEnElTurno()` y `getListDeUnidadesQueDebenMoverEnElProximoTurno` de `Jugador`?
* Usar `@Override` en métodos heredados sobreescritos

## 10/6

* Abstracciones `CreadorDeSoldados`, `CreadorDeUnidadesAereas` y `CreadorDeUnidadesTerrestres` no parece que vaya a funcionar sin preguntar de alguna forma de que raza es el jugador
* Paquetes no consistentes (ej: construcciones Protoss están definidas bajo `fiuba.algo3.algocraft.ConstruccionesProtoss` pero no existe un paquete equivalente para las construcciones Terran)
* Nombres de paquetes deben contener [solo minúsculas](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html). Asimismo, el nombre debería ser representativo de las clases que contiene (ej: `RazaProtoss` no contiene todos los objetos propios de los Protoss sino que solo contiene sus unidades)
* Nombres de clases deben ser representativos (ej: `Estado` habla más de la implementación del patrón que de su rol en el modelo)
* Qué diferencia hay entre `TipoDeConstruccion.CREADOR_DE_SOLDADOS` y `TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES`?
* Se sigue usando directamente los atributos protegidos de `Interactuable` al inicializar cada construcción
* Getters y setters deben seguir la convención `getXXX` y `setXXX` donde _XXX_ es el nombre del atributo (ej: `Unidad.obtenerPropietario()`)
* `Juego` sigue siendo el responsable de validar la longitud del nombre del `Jugador` (`Juego.crearJugador()`)
* Sería bueno que las pruebas de integración esten diferenciadas de pruebas unitarias
* Utilizar accesores a métodos (ej: no es correcto que los métodos `incrementarCapacidadDePoblacion()` / `decrementarPoblacion()` de `Jugador` sean público ya que rompe el encapsulamiento)
* Evitar usar atributos para valores calculables (ej: `Jugador.capacidadDePoblacion`)
* Por qué es necesario que `Barraca.crearMarine()` reciba por parámetro el objeto `Mapa`?
* Clase abstracta `CreadorDeSoldados` no define ningún método ni atributo, podría ser interfaz (o ser directamente eliminada?)
* Nombres de variables empiezan siempre en minúsculas (ej: `Mapa.calcularItinerario()` -> `ParcelaPartida`)
* No debería ser `Mapa` quien calcule el itinerario para mover una unidad entre 2 puntos

### Estado entregables:

* Diagramas actualizados?
* Faltan tests de integración de creación de unidades
* Ataques especiales de `NaveCiencia` no implementados
* Movimiento de unidades no implementado
* Transporte de unidades no está implementado

## 3/6

* Por qué se necesitan las clases `ExtractorGas` y `ExtractorMineral`?
* Idem para `ConstruccionExtractora`
* Usar constantes para "números mágicos" (ej: constructor de `Refineria`)
* Pensaron cómo van a implementar el escudo de las construcciones Protoss?
* Para inicializar atributos heredados usar constructor de la clase base (ej: `Construccion.propietario`)
* Por qué es necesario que las unidades conozcan sus coordenadas? Tendría sentido que tenga una referencia a la `Parcela` en vez de a la `Coordenada`?
* Validación de longitud de nombre de jugador debería estar en `Jugador`, no en `Juego`
* Usar objetos `Coordenada` en vez de integers para X e Y
* Cada clase del modelo tiene que tener sus correspondientes tests unitarios (la cobertura es buena, pero más que nada por los tests de integración)
* Usar constantes siempre que se pueda en los tests (ej: `RefineriaTest.unaRefineriaAbsorbeGasVespenoYSeLoSumaAlJugadorPropietario`)

### Estado entregables:

* Pruebas unitarias al mapa, que pueda generar escenarios para que empiecen los jugadores **OK**
* Pruebas de recolección de minerales y gas con los edificios correspondientes. **OK**
* Pruebas de creación de unidades:
  * Haber construido primero el edificio que me habilite a construirla **FALTA**
  * Contar con recursos (mineral y/o gas) necesarios **FALTA**
  * Contar con límite de población para crearla **FALTA**

### Otros comentarios

* Agregar badge de Travis (http://docs.travis-ci.com/user/status-images/)
* Acceso al repositorio (anero)
