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
