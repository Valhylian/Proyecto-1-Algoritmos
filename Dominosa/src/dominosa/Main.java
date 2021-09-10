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
         /*
         boolean done = false;
         juego.FuerzaBruta(done,matrix, 2, 3,Dominosa.dominoes, 0, 0,0);*/
         System.out.println(juego.fuerzaBrutaPrueba(matrix));
         //juego.imprimirMatriz(juego.generarmatriz(3,3));
         
    }
     
}
