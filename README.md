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

