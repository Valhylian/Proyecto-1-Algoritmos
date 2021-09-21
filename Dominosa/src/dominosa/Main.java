/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

/**
 *
 * @author valeria
 */
public class Main {
     public static Dominosa juego = new Dominosa();
     public static void main(String[] args) {
        
         
         
         int matrix[][]={{4,2,1,4,3,4},{4,4,0,2,0,1},{2,3,1,3,3,2},{0,1,3,3,4,2},{1,1,2,0,0,0}};
         Interfaz inter=new Interfaz();
         inter.setResizable(false);
         inter.setSize(1150,600);
         int matrixPruebaColores [][]={{0,0,0,0,1},{1,1,0,0,1},{1,1,1,0,0},{0,0,1,0,0}};
         inter.generarMatrizGrafica (matrix);
         //inter.pintarMatriz (matrixPruebaColores);
         inter.setVisible(true);
         juego.auxiliarBacktracking(matrix);
         juego.auxiliarFuerzaBruta(matrix);
         //juego.imprimirMatricesSoluciones();
         //System.out.println(juego.BacktrackingPrueba(matrix));
         //juego.imprimirMatriz(juego.generarmatriz(3,3));
         //System.out.println(juego.fuerzaBrutaPrueba(matrix));
        
         
    }
     
}



    