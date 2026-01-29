# Irrgarten – PDOO UGR

## Contexto académico

Este proyecto forma parte de la asignatura **Programación y Diseño Orientado a Objetos** del **Grado en Ingeniería Informática** de la **UGR**. Su objetivo es servir como caso práctico para la aplicación de los principios fundamentales del diseño orientado a objetos en un proyecto de tamaño medio.

El código está concebido como una base extensible sobre la que realizar modificaciones incrementales, tanto durante el desarrollo de las prácticas como en evaluaciones prácticas, donde se introducen nuevos requisitos o se alteran reglas existentes del juego.

---

## Descripción general

**Irrgarten** es un juego de rol por turnos ambientado en un laberinto. El jugador avanza por el tablero, interactúa con distintas casillas, se enfrenta a monstruos y gestiona sus recursos hasta alcanzar una condición de victoria.

El proyecto prioriza la claridad del diseño, la correcta separación de responsabilidades y la extensibilidad del sistema frente a la complejidad gráfica o de interacción.

---

## Objetivos del proyecto

- Aplicar los principios fundamentales de la **Programación Orientada a Objetos** en un entorno práctico.
- Diseñar un sistema modular, mantenible y fácilmente extensible.
- Separar correctamente la lógica del juego, el estado del sistema y la presentación.
- Utilizar mecanismos habituales del paradigma orientado a objetos de forma coherente.
- Facilitar la incorporación de nuevas funcionalidades sin alterar la estructura existente.

---

## Conceptos de Programación Orientada a Objetos trabajados

### Encapsulación
- Uso de atributos privados.
- Acceso controlado mediante métodos públicos.
- Protección del estado interno de los objetos.

### Abstracción
- Modelado de entidades del dominio mediante clases base.
- Uso de interfaces para definir comportamientos comunes.

### Herencia
- Especialización de clases para representar distintos tipos de entidades del juego.
- Reutilización de comportamiento común evitando duplicación de código.

### Polimorfismo
- Uso de referencias a clases base o interfaces para tratar objetos heterogéneos de forma uniforme.
- Comportamientos diferenciados en tiempo de ejecución según el tipo concreto del objeto.

### Modularidad y separación de responsabilidades
- Diferenciación clara entre:
  - Lógica del juego.
  - Estado del sistema.
  - Interfaz de usuario.

### Uso controlado de aleatoriedad
- Centralización de la lógica aleatoria en una clase específica.
- Evitar la dispersión de decisiones aleatorias por el resto del código.

---

## Estructura del proyecto

El proyecto se organiza siguiendo una estructura que facilita la comprensión del código y su mantenimiento:

### **Modelo** 
`irrgartenGame`

Contiene las clases que representan el **estado y comportamiento del dominio del juego**.

Incluye, entre otros:
- Jugadores y monstruos.
- Casillas del laberinto y sus efectos.
- Objetos del juego (armas, escudos, etc.).
- Generación de valores aleatorios.

### **Controlador** 
`irrgartenController`

Gestiona el **flujo del juego y la aplicación de las reglas**.

Se encarga de:
- Coordinar turnos y acciones.
- Resolver combates.
- Aplicar efectos derivados de movimientos o eventos.
- Actualizar el estado del modelo.

### **Vista** 
`irrgartenUI`

Responsable de la **presentación de la información al usuario** en una interfaz por medio de **texto o interfaz gráfica** con JFrame.

Sus funciones principales son:
- Mostrar el estado actual del juego y los jugadores.
- Reflejar los resultados de las acciones.
- Permitir un uso intuitivo de el sistema de movimiento de los jugadores.

---

## Extensibilidad del proyecto

El diseño del proyecto permite la incorporación de nuevas funcionalidades de forma incremental, tales como:

- Nuevos tipos de casillas o enemigos.
- Reglas adicionales de combate.
- Nuevos atributos o estados para los personajes.
- Cambios en la presentación de la información.

La extensibilidad del sistema es un objetivo explícito del diseño y una parte fundamental del aprendizaje asociado al proyecto.
