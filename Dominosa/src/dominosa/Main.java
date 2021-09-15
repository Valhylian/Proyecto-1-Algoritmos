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

         int matrix[][]={{1,1,0,2},{2,0,0,0},{2,2,1,1}};
         Dominosa juego = new Dominosa();
         //System.out.println(juego.fuerzaBrutaPrueba(matrix));
         System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
         System.out.println(juego.BacktrackingPrueba(matrix));
         //juego.imprimirMatriz(juego.generarmatriz(3,3));
         
    }
     
}
