/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;


/**
 *
 * @author monic
 */


public class Dominosa {

    public Dominosa() {
    }
    /**
     * @param args the command line arguments
     */

    public static ArrayList<Point> dominoes = new ArrayList<Point>();
    public static ArrayList<String> noSoluciones = new ArrayList<String>(); //Substrings de soluciones incorrectas
    public static int matrixAux[][];
   
  
    //GENERA MATRIZ X*Y/////////////////////////////////////
    public int[][] generarmatriz (int filas, int columnas){
        int matriz[][] = new int[filas][columnas];
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
            matriz[x][y]=8;
            }
        }
        return matriz;
    }
     
    public void actualiceMatrizAux (String orientacion){
        Point point = retornaSiguientePoint();
            int x = point.x;
            int y = point.y;
            
        if (orientacion.equals("Vertical")){
            matrixAux[x][y] = 1;
            matrixAux[x+1][y] = 1;
        }
        else{
            matrixAux[x][y] = 0;
            matrixAux[x][y+1] = 0;
        }
    }
    
    //IMPRIME MATRIZ ///////////////////////////////////////
    public void imprimirMatriz (int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirDominoes (){
        for (int i=0;i<dominoes.size();i++){
            Point punto = dominoes.get(i);
            System.out.println("Ficha = " + punto.x + punto.y );
            System.out.println("Ubicacion1 = " + punto.ubicacion1.x + punto.ubicacion1.y);
            System.out.println("Ubicacion2 = " + punto.ubicacion2.x + punto.ubicacion2.y);
            if (punto.ubicacion1.x == punto.ubicacion2.x){
                System.out.println("Horizontal");
            }
            else{
                System.out.println("Vertical");
            }
            System.out.println("\n");
        }
    }
    
    //Retorna en un punto la siguiente posicion libre en la matrizAux
    // x = coordenada x
    // y = coordenada y
    // null si no hay libres
    public Point retornaSiguientePoint(){
        Point point = null;
        for (int x=0; x < matrixAux.length; x++) {
            for (int y=0; y < matrixAux[x].length; y++) {
                if (matrixAux[x][y] == 8){
                    point = new Point (x,y);//tener cuidado porque guarda el par ordenado en x,y
                    return point;
                }
            }
        }
        return point;
    }

    public boolean esHorizontal(){
        Point point = retornaSiguientePoint();
        if (point == null){
            return false;
        }
        int x = point.x;
        int y = point.y;
        System.out.println("Horizontal");
        System.out.println("x = "+x );
        System.out.println("y = "+y );
        //note que siempre se ubicaria el siguiente a la derecha (porque no habria espacio al otro lado)
        if (y+1 >= matrixAux[0].length){
            System.out.println("Falso por que se pasa");
            return false;
        }
        if (matrixAux[x][y+1] != 8){
            System.out.println("Falso porque esta ocupado");
            return false;
        }
        
        return true;
    }
    
    public boolean esVertical(){
        Point point = retornaSiguientePoint();
        if (point == null){
            return false;
        }
        int x = point.x;
        int y = point.y;
        System.out.println("Vertical");
        System.out.println("x = "+x );
        System.out.println("y = "+y );
        //note que siempre se ubicaria el siguiente a la derecha (porque no habria espacio al otro lado)
        if (x+1 >= matrixAux.length){
            System.out.println("Falso");
            return false;
        }
        if (matrixAux[x+1][y] != 8){
            System.out.println("Falso");
            return false;
        }
        return true;
    }

 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     
    public boolean esSolucionFuerzaBruta (String solucion, int matrix[][]){
        String posicion = "0";  //se inicaliza en 0 solo por declararlo
        for (int i=0; i<solucion.length();i++){
            posicion = Character.toString(solucion.charAt(i));
            if (posicion.equals("0")){
                //verificar si la ficha puede ser horizontal
                if (!esHorizontal()){
                    return false;
                }
                else{
                    actualiceMatrizAux ("Horizontal");
                }
            }
            else{
                //verificar si la ficha puede ser vertical
                 if (!esVertical()){
                    return false;
                }
                 else{
                    actualiceMatrizAux ("Vertical");
                 }
            }
        }
        System.out.println(solucion);
        System.out.println("Solucion = True");
        return true;
    }
    
    public ArrayList<String> fuerzaBrutaPrueba(int matrix[][]){
        
        //1-Calcular la cantidad de fichas
        int cantFichas = (matrix.length * matrix[0].length)/2;
        int cantidadFallos=0;
        //2-Generar lista de posibles soluciones
        ArrayList<String> combinaciones = Combinaciones.generarCombinaciones(cantFichas);
        ArrayList<String> soluciones = new ArrayList<String>(); //guarda las soluciones correctas
        
        //3-Ciclo para recorrer combinaciones
        for (int i=0; i<combinaciones.size(); i++){
            //*-Generar matriz gemela de "8"
            matrixAux = generarmatriz (matrix.length, matrix[0].length);
            //1-Obtener posible combinacion i
            String posibleSolucion = combinaciones.get(i);
            //2- llama a esSolucion
            if (esSolucionFuerzaBruta(posibleSolucion,matrix)){
                //agregar solucion a algun arreglo
                soluciones.add(posibleSolucion);
                
            }else{
                cantidadFallos+=1;
            }
        }
        System.out.println("Cantidad de fallas: "+cantidadFallos);
        return soluciones;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public boolean verificadorSoluciones(String solucion){
        int contadorLetras=0;
        for(int i=0; i<noSoluciones.size(); i++){
            contadorLetras=noSoluciones.get(i).length(); 
            //System.out.println("S: "+solucion);
            //System.out.println("SS "+solucion.substring(0,contadorLetras));
            //System.out.println("NS "+noSoluciones.get(i));
            if(solucion.substring(0,contadorLetras).equals(noSoluciones.get(i))){
                return false;      
            }
        }
        return true;
    }
   
    public boolean esSolucionBacktracking (String solucion, int matrix[][]){
        String posicion="";  
        String posicionesProceso="";
        for (int i=0; i<solucion.length();i++){
            posicion = Character.toString(solucion.charAt(i));
            posicionesProceso=posicionesProceso+posicion;
            //System.out.println(posicionesProceso);
            if(verificadorSoluciones(solucion)) {
                if (posicion.equals("0")){
                        //verificar si la ficha puede ser horizontal
                        if (!esHorizontal()){
                            if(posicionesProceso.length()<solucion.length()){
                                noSoluciones.add(posicionesProceso);
                            }
                            return false;
                        }
                        else{
                            actualiceMatrizAux ("Horizontal");
                        }
                    }
                else{
                    //verificar si la ficha puede ser vertical
                    if (!esVertical()){
                        if(posicionesProceso.length()<solucion.length()){
                            noSoluciones.add(posicionesProceso);
                        }
                        return false;
                    }
                    else{
                        actualiceMatrizAux ("Vertical");
                    }
                }
            }else{
                return false;
            }
        }
        //System.out.println(solucion);
        System.out.println("Solution = True");
        return true;
    }

    public ArrayList<String> BacktrackingPrueba(int matrix[][]){
        //1-Calcular la cantidad de fichas
        int cantFichas = (matrix.length * matrix[0].length)/2;
        int cantidadFallos=0;
        //2-Generar lista de posibles soluciones
        ArrayList<String> combinaciones = Combinaciones.generarCombinaciones(cantFichas);
        ArrayList<String> soluciones = new ArrayList<String>(); //guarda las soluciones correctas
        
        //3-Ciclo para recorrer combinaciones
        for (int i=0; i<combinaciones.size(); i++){
            //*-Generar matriz gemela de "8"
            matrixAux = generarmatriz (matrix.length, matrix[0].length);
            //1-Obtener posible combinacion i
            String posibleSolucion = combinaciones.get(i);
            //2- llama a esSolucion
            if (esSolucionBacktracking(posibleSolucion,matrix)){
                //agregar solucion a algun arreglo
                soluciones.add(posibleSolucion);    
            }else{
                cantidadFallos+=1;
            }
        }
        System.out.println("Cantidad de fallas: "+cantidadFallos);
        System.out.println(noSoluciones);
        return soluciones;
    }
}
