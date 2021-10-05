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
         
         int matrix[][]={{1,0,1},{0,0,1}};
         Interfaz inter=new Interfaz();
         inter.setResizable(false);
         inter.setSize(1150,600);
         int matrixPruebaColores [][]={{0,0,0,0,1},{1,1,0,0,1},{1,1,1,0,0},{0,0,1,0,0}};
         inter.generarMatrizGrafica (matrix);

         inter.setVisible(true);
         juego.auxiliarBacktracking(matrix);
         juego.auxiliarFuerzaBruta(matrix);
         //juego.imprimirMatricesSoluciones();
         //System.out.println(juego.BacktrackingPrueba(matrix));
         //juego.imprimirMatriz(juego.generarmatriz(3,3));
         //System.out.println(juego.fuerzaBrutaPrueba(matrix));
        
         
    }
     
}



    