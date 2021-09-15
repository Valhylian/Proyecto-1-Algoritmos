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
    
     public static void main(String[] args) {

         int matrix[][]={{0,0,3,2,0,5,1},{4,5,2,1,5,4,4},{0,3,4,1,1,4,2},{1,3,1,2,0,3,3},{3,2,2,1,0,5,5},{5,3,2,4,4,5,0}};
         Dominosa juego = new Dominosa();
         //System.out.println(juego.fuerzaBrutaPrueba(matrix));
         System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
         System.out.println(juego.BacktrackingPrueba(matrix));
         //juego.imprimirMatriz(juego.generarmatriz(3,3));
         
    }
     
}
