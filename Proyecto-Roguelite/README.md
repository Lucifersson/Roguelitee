# 🪶 Roguelike de Interacciones (Terminal Java)

---

## 📅 Estado y Fecha

**Proyecto Activo** | 17 de octubre de 2025

---

## 📝 Descripción del Proyecto

"Roguelike de Interacciones" es un **juego de terminal** (consola) desarrollado en **Java**. El proyecto se centra en una experiencia **Roguelike** basada en la **narrativa** y las **decisiones**, eliminando el combate directo. El flujo del juego se basa en **interacciones con NPCs** y **eventos situacionales** que modifican la **Cordura** (vida), las **estadísticas** del personaje, y el inventario.

El objetivo principal es la **progresión** a través del **desbloqueo persistente** de objetos, clases y logros a lo largo de múltiples _runs_ (partidas).

---

## 🛠️ Estructura Técnica y Persistencia

| Componente               | Tecnología | Uso Específico                                                                                                                                                            | Persistencia                                      |
| :----------------------- | :--------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | :------------------------------------------------ |
| **Plataforma Principal** | **Java**   | Lógica de juego y ejecución en terminal.                                                                                                                                  | **No persistente** (partidas de una sola sesión). |
| **Base de Datos**        | **MySQL**  | **Data Maestra:** Almacenamiento de todos los datos fijos del juego: configuraciones de **NPCs, Eventos, _Items_, y Clases**. Facilita la instanciación aleatoria por ID. | **Persistente** (Datos de juego fijos).           |
| **Serialización**        | **JSON**   | Almacenamiento de **Logros y Contenido Desbloqueado** (Objetos y Clases).                                                                                                 | **Persistente** (Datos de progreso del jugador).  |

> **Aclaración:** No hay funcionalidad de "guardar partida". Las estadísticas del personaje y el inventario solo existen durante la **sesión de juego actual**.

---

## 🎮 Características y Flujo de la Partida

El juego se desarrolla en **partidas de una sola sesión (runs)**.

### Flujo de la Sesión

1.  **Inicio:** Creación del personaje (nombre y género).
2.  **Ciclo:** El personaje se encuentra aleatoriamente con un **Encuentro (NPC)** o un **Evento (Situacional)**.
3.  **Comercio:** Después de cada interacción, la **Tienda** puede aparecer.
4.  **Fin:** La partida termina cuando la **Cordura** del personaje llega a cero.

### Inventario y _Items_

El **Inventario** está limitado a **3 _Items_**. Obtener uno nuevo obliga al jugador a elegir cuál desechar.

### 🔄 Flujo de un Encuentro con NPC

Los NPCs son instanciados aleatoriamente desde la data maestra de MySQL. El sistema comprueba en orden:

1.  **Interacción por _Item_:** Comprobación de interacciones especiales si el personaje posee un objeto clave.
2.  **Interacción por Estadística Máxima:** Si una estadística está en su valor máximo o sobre un umbral (afecta a la clase).
3.  **Interacción Especial por Estadística:** Comprobación de una interacción única ligada a una estadística.
4.  **Generación de Interacción Extra:** Oportunidad de una interacción adicional basada en la estadística clave de la clase.
5.  **Ejecución de Interacción:** Las interacciones modifican principalmente la **Cordura**.
6.  **Generación de Tienda:** Comprobación si se activa la tienda.

---

## 📊 Sistema de Estadísticas

Cada estadística se puntúa sobre **20 puntos**.

- Cada punto otorga un **5% de probabilidad** de que aparezca una interacción específica.
- El éxito/fallo de la interacción depende de la comparación entre la estadística del jugador y la del NPC.

| Estadística      | Rol Principal                          |
| :--------------- | :------------------------------------- |
| **Cordura**      | **Vida** (Recurso principal).          |
| **Carisma**      | Persuasión y diálogo.                  |
| **Intimidación** | Amenaza y disuasión.                   |
| **Inteligencia** | Lógica y comprensión.                  |
| **Suerte**       | Probabilidad de resultados favorables. |

### Clases

Cada **Clase** posee: un **Objeto de Inicio**, una **Interacción Extra** (ligada a su estadística clave) y una **Interacción Especial** (por estadística clave al máximo).

---

## 👥 NPCs y Eventos

### Encuentros con NPCs (Data Maestra MySQL)

- Los **NPCs** tienen sus propias estadísticas y sexualidades, que interactúan directamente con las del jugador y su **género** (**Hombre, Mujer, Otro**).
  - _Ejemplo:_ Un NPC con alta Intimidación podría ser evitado por el jugador si la suya es baja.
  - _Ejemplo:_ Un _Goblin_ homosexual se verá atraído por un personaje masculino, modificando el encuentro.
- La finalidad principal es **modificar la Cordura**.

### Eventos (Situacionales)

- Situaciones sin NPCs que requieren decisiones.
- Los efectos de las decisiones (mayores o menores) se ven afectados por las **Estadísticas** del personaje.
- La finalidad principal es **modificar las Estadísticas** (e.g., aumentar o disminuir Carisma).

---

## 🏆 Logros y Desbloqueos (Serialización JSON)

Los datos de progreso se serializan en **JSON** para persistir entre _runs_.

- **Logros:** Un historial/conteo de las interacciones y respuestas experimentadas. Muestra un conteo de los encuentros vistos.
- **Desbloqueo de Contenido:** **Objetos** y **Clases** que solo se pueden desbloquear después de alcanzar un número determinado de interacciones o situaciones.

### Ideas de Futuro

- **Objeto de Inicio Secundario:** Desbloqueo de un segundo _Item_ de inicio después de un evento único.
- **Persistencia Narrativa:** Implementación de interacciones con presencia en el futuro de la misma _run_ (ej. Un NPC te reprende por una mala acción anterior).

### ToDo

- Crear clase jugador
- Crear items

