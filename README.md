# English - Inglés
# Dominosa 🎲
Analysis of the Dominosa game for the Algorithm Analysis course at Tecnológico de Costa Rica. II Semester, 2021.

# How to use 💻
1. Run the **Main.java** program.
2. Enter the size of the chip matrix to be analyzed.
3. See the various solutions by clicking the "Next solution" button.

### Goals
1. Apply concepts of backtracking algorithms.
2. Compare backtracking algorithms with force algorithms
gross.
3. Apply knowledge in empirical and analytical measurement of algorithms.

### Description
The dominoes are rectangular pieces divided into 2 sections: each section contains a number of points from 0 to n. Each of the tiles has a unique combination of these numbers. So for example, if the numbers go from 0 to 6 (sometimes called the double 6 set), we will have 28 different tiles. The double 6 set can be accommodated in a 7x8 cell matrix, where each cell represents half a tile. That is, each tile occupies 2 spaces in the matrix. It is possible to place tiles in a vertical or horizontal position and fill the matrix completely without leaving blank spaces and without over tiles. In general, for any double n set, the tiles can be arranged in a matrix of size (n + 1) x (n + 2).
With this, a puzzle game can be created in which a matrix with numbers from 0 to n is presented, and the objective is to deduce the configuration of the tiles, that is, how all the tiles in the set were placed in order to form the matrix; clearly so that no tiles are repeated.
In this project, 2 algorithms must be programmed: one of brute force and one of backtracking that respond to the game.

### Setup
The input for the algorithms is an array of numbers. The size of the matrix and the range of the numbers always correspond to n, it is not necessary to validate the input. The output of the algorithms is the configuration of the tiles on the board. The format of the solution is at your discretion. For testing, you are provided with an array generator. The format of the file that is generated is the following:
```python
1 n
2
3 row 0 of the matrix, numbers separated by spaces, n + 2 columns
4 row 1
5 ...
6 row n + 1
7
8 # solution: a single row of 1's and 0's separated by space. 0 represents a horizontal tile, 1 a vertical tile. The board is resolved from left to right and top to bottom.
```

For example, for a double set 2, the following file is generated:
```python
1 2
2
3 0 2 2 2
4 1 1 1 0
5 1 0 2 0
6
7 0 0 0 1 1 0
```
In this, the solution is interpreted as follows:
1. Starting from cell (0,0), the first tab is horizontal [0 | 2].
2. The next cell is (0, 2), because in cell (0, 1) is the same
file; in this cell we place another horizontal tile [2 | 2].
3. We continue with the next row. Here we put the third tab
horizontal [1 | 1]
4. Continue in cell (1, 2). And here a vertical tile is placed
[1 | 2].
5. The next cell is (1, 3), and here another vertical tile is placed
[0 | 0].
project 1 - backtracking 3
6. The last tab [1 | 0] goes in cell (2, 0) in horizontal position.
The generator code can be downloaded from this [link](https://github.com/yuenlw/dominoGenerator.git)
### Functional requirements
An application with a graphical interface must be programmed that allows the algorithms to be reviewed. For example, show what the solution is and how each algorithm builds it. It does not necessarily have to be animated in real time (while looking for the solution). As a general rule of thumb to decide what information to add, consider that the application is the same one that you will use to debug your algorithms and do the subsequent analysis. 
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


# Spanish - Español 
# Dominosa 🎲
Análisis del juego Dominosa para el curso Análisis de Algoritmos del Tecnológico de Costa Rica. II Semestre, 2021.

# Modo de uso 💻
1. Correr el programa **Main.java**.
2. Colocar el tamaño de la matriz de fichas que se desea analizar. 
3. Ver las diversas soluciones dando click al botón de "Siguiente solución". 

### Objetivos
1. Aplicar conceptos de algoritmos de backtracking.
2. Comparar los algoritmos de backtracking con algoritmos de fuerza
bruta.
3. Aplicar conocimientos en medición empírica y analítica de algoritmos.

### Descripción
Las fichas de domino son piezas rectangulares divididas en 2 secciones: cada sección contiene un número de puntos de 0 a n. Cada una de las fichas tiene una combinación única de estos números. Así por ejemplo, si los números van del 0 al 6 (llamado algunas veces el set doble 6), tendremos 28 fichas diferentes. El set doble 6 se puede acomodar en una matriz de 7x8 celdas, donde cada celda representa la mitad de una ficha. Es decir, cada ficha ocupa 2 espacios en la matriz. Es posible colocar fichas en posición vertical u horizontal y llenar completamente la matriz sin dejar espacios en blanco y sin que sobre fichas. En general, para cualquier set doble n, las fichas se pueden acomodar en una matriz de tamaño (n+1)x(n+2).
Con esto se puede crear un juego de acertijo en el que se presenta una matriz con números de 0 a n, y el objetivo es deducir la configuración de las fichas, es decir cómo se colocaron todas la fichas del set para lograr formar la matriz; claramente de tal forma que no se repitan fichas.
En este proyecto se debe programar 2 algoritmos: uno de fuerza bruta y uno de backtracking que den respuesta al juego.

### Setup
La entrada para los algoritmos es una matriz de números. El tamaño de la matriz y el rango de los números corresponde siempre al n, no es necesario hacer validaciones de la entrada. La salida de los algoritmos es la configuración de las fichas en el tablero. El formato de la solución queda a su criterio. Para realizar pruebas, se le proporciona un generador de matrices. El formato del archivo que se genera es el siguiente:
```python
1 n
2
3 fila 0 de la matriz, números separados por espacios, n+2 columnas
4 fila 1
5 ...
6 fila n+1
7
8 #solución: una sola fila de 1 y 0 separados por espacio. 0 representa una ficha horizontal, 1 una ficha vertical. El tablero se resuelve de izquierda a derecha y de arriba a abajo.
```

Por ejemplo, para un set doble 2, se genera el siguiente archivo:
```python
1 2
2
3 0 2 2 2
4 1 1 1 0
5 1 0 2 0
6
7 0 0 0 1 1 0
```
En este, la solución se interpreta de la siguiente manera:
1. Empezando de la celda (0,0), la primera ficha es horizontal [0|2].
2. La siguiente celda es la (0, 2), pues en la celda (0, 1) está la misma
ficha; en esta celda colocamos otra ficha horizontal [2|2].
3. Continuamos con la siguiente fila. Aquí ponemos la tercera ficha
horizontal [1|1]
4. Se continua en la celda (1, 2). Y aquí se coloca una ficha vertical
[1|2].
5. La siguiente celda es la (1, 3), y aquí se coloca otra ficha vertical
[0|0].
proyecto 1 - backtracking 3
6. La última ficha [1|0] va en la celda (2, 0) en posición horizontal.
El código generador se puede descargar de este [link](https://github.com/yuenlw/dominoGenerator.git)
### Requerimientos funcionales
Se debe programar una aplicación con interfaz gráfica que permita revisar los algoritmos. Por ejemplo, que muestre cuál es la solución y cómo cada algoritmo la va construyendo. No necesariamente debe ser animada en tiempo real (mientras se busca la solución). Como regla general para decidir qué información se debe agregar, piensen que la aplicación es la misma que ustedes usarán para depurar sus algoritmos y hacer el análisis posterior.

