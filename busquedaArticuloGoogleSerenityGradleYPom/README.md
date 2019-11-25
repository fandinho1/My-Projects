Billetera Movil

El proyecto tiene como objetivo exponer las tarjetas con la que cada uno de los clientes cuenta para poder realizar
pagos por medio del escaneo de QR ya sea estatico o dinamico. Actualmente la billetera soporta pagos con tarjetas
debito maestro, masterdebit e e-prepago, proximamente se podran realizar pagos con tarjetas de credito.

Esta aplicación de billetera cuenta actualmente con 5 transacciones las cuales son:

* Autenticación.
* Registro.
* Terminos y condiciones.
* Listar tarjetas.
* Pagos.

Requerimientos
Para correr el proyecto es necesario lo siguiente:

* [Java JDK].
* [Appium 1.8.1 en adelante].
* Conexión a la red interna WIFIBC.
* Algun IDE con cucumber instalado.
* Gradle.

Estos requerimientos son necesarios ya que la automatización esta desarrollada en el lenguaje Java y teniendo como
gestor de dependencias gradle el cual se puede ejecutar como wrapper, por lo tanto es indispensable estar conectato
a la red interna WIFIBC para descargar las dependencias y el gradle wrapper que estan sobre el repositorio de
dependencias de Artifactory .

Se utiliza BDD como framework de automatización sobre el patrón de arquitectura de ScreenPlay donde segregamos las
capas de automatización.

### Compilador
Se crea el proyecto sobre Gradle, es una herramienta de automatización de la construcción de nuestro código, es la
versión mejorada de Maven, pero intenta llevarlo a un paso mas alla. Para empezar, se apoya en Groovy y en un DSL
(Domain Specific Language) para trabajar con un lenguaje sencillo y claro a la hora de construir el build comparado
con Maven. Por otro lado, dispone de una gran flexibilidad que permite trabajar con ella utilizando otros lenguajes y
no solo Java. Dispone por otro lado de un sistema de gestión de dependencias sólido.

### Herramienta de automatización utilizado
---
Se utiliza el IDE de IntelliJ para el desarrollo de la automatización. IntelliJ IDEA es un entorno de desarrollo integrado para el desarrollo
de programas informáticos. Es desarrollado por JetBrains, y está disponible en dos ediciones: edición para la comunidad​ y edición comercial.
IntelliJ IDEA no está basada en Eclipse como MyEclipse u Oracle Enterprise Pack para Eclipse.
Diseñada para ser extendida de forma indefinida a través de plug-ins. Fue concebida desde sus orígenes para convertirse en una plataforma de
integración de herramientas de desarrollo. No tiene en mente un lenguaje específico, sino que es un IDE genérico, aunque goza de mucha popularidad
entre la comunidad de desarrolladores del lenguaje Java usando el plug-in JDT que viene incluido en la distribución estándar del IDE.
Proporciona herramientas para la gestión de espacios de trabajo, escribir, desplegar, ejecutar y depurar aplicaciones.

Proyecto de Automatización
Se esta implementando un monorepo para manejar la automatización de los 2 dispositivos movíles (Android y iOS),
actualmente se tienen las siguientes capas definidas e implementadas:

* Features.
* Runners.
* Stepdefinitions.
* Integration.
* Interactions.
* Models.
* Questions.
* Tasks.
* Userinterface.
* Util.

Cada una de estas capas se esta trabajando actualmente y se espera que para final de año del año presente se tenga
automatizada la billetera.

Adicional a esto se esta haciendo la solicitud de un VDI propio para evitar inconvenientes con los agentes al momento
de ejecutar la automatización y se viene realizando la gestion para poder tener dispositivos movíles en la granja
de Kobiton.

Para los dispositivos Android se tienen automatizadas las siguientes transacciones:

* Autenticación.
* Registro.
* Terminos y Condiciones.
* Listar tarjetas.
* Pagos.

Estas validaciones solamente estan a nivel de iSERIES, se procedera a realizar las respectivas validaciones en cloudant
y Postgres.

Para los dispositivos iOS se tienen automatizadas las siguientes transacciones:

* Autenticación.
* Registro.
* Terminos y Condiciones.

al igual que los dispositivos Android se estan realizando las validaciones a nivel de iSERIES, pero tambien se realizara
la implementación para validar en Cloudant y Postgres.

DevOps

A nivel de DevOps el repositorio cuenta con los 3 pilares correspondientes para Certificación (CI, CD, RM), configurados
correctamente. (en Hygieia se puede encuentrar la adopción), El beneficio que este Dashboard nos brinda es que podremos
monitorear en tiempo real los pilares de Devops que le aplican a certificación como lo son CI, CD y RM.
Se realiza configuración especial para que este Dashboard muestre únicamente lo que aplica para un proyecto de
automatización y no como si fuera un proyecto de desarrollo.

Proyecto de Pruebas Manuales
Este proyecto es básicamente de documentación viva, en donde se evidencian la ejecución de los casos manuales, actualmente
se tienen escenarios de pagos y un servicio (retrieveFileTransaction).