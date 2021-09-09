/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import java.util.ArrayList;

/**
 *
 * @author valeria
 */
public class Combinaciones {
    
    //RETORNA EL STRING CON EL FORMATO DE COMBINACION 
    //RECIBE LA CANTIDAD DE BITS Y EL NUMERO EN DECIMAL
    public static String formatoCombinacion (int cant, int numero){
        String bin = Integer.toBinaryString(numero);
        int length = bin.length(); //largo incial del numero binario
        
        while (length < cant){
            bin = "0"+bin;
            length++;
        }
        return bin;
    }
    
    public static ArrayList<String> generarCombinaciones (int cantFichas){
        ArrayList<String> combinaciones = new ArrayList<String>();
        int cantCombinaciones = (int)Math.pow(2, cantFichas);
        for (int i=0; i<cantCombinaciones; i++){
            combinaciones.add(formatoCombinacion (cantFichas, i));
        }
        return combinaciones;
    }
}
