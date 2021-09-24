/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



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
    public static ArrayList<String> noSoluciones0 = new ArrayList<String>(); //Substrings de soluciones incorrectas
    public static ArrayList<String> noSoluciones1 = new ArrayList<String>(); //Substrings de soluciones incorrectas
    public static ArrayList<String> solucionesGeneral = new ArrayList<String>(); //lo agregue para generar los archivos (hay que limpiarlo)
    public static int matrixAux[][];
    public static ArrayList<int[][]> solucionesMatrices = new ArrayList<int[][]>();
    public static int contadorFallos = 0; //lo agregue para los archivos (recordar fijarse si lo estamos limpiando)

    //RETORNA LA RUTA ABSOLUTA DEL PROYECTO---------------------------------------
    public String getRuta () {
	Path path = Paths.get("");
	String directoryName = path.toAbsolutePath().toString();
	System.out.println("El directorio de este proyecto: " +directoryName);
        return directoryName;
    }
    
    //PRUEBA ESCRITURA DE ARCHIVOS-----------------------------------------------
    //USADO EN OTRO METODO
    public void crearArchivo(String info, String nombre){
        try {
            String ruta = getRuta()+"/Archivos/"+nombre+".txt";
            String contenido = info;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    //GENERA EL ARCHIVO DE SOLUCION DE FUERZA BRUTA CON UN FORMATO ESPECIFICO-------
    public String generarFormato_FuerzaBruta(int matrix[][],long tiempoEjecucion){
        int size = matrix.length-1;
        String contenido = "Fuerza Bruta\n\nSize: "+size+"\n\n";
        contenido += "Matriz analizada\n";
        for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    contenido += matrix[i][j] + " ";
                }
            contenido += "\n";
            }
        //lista de soluciones
        contenido += "\nSoluciones:\n";
        for (int i=0; i<solucionesGeneral.size();i++){
            contenido += solucionesGeneral.get(i)+"\n";
        }
        //lista de matrices
        contenido += "\n\nMatrices de Soluciones:\n";
        for (int x=0; x<solucionesMatrices.size();x++){
            int [][] matrizAux = solucionesMatrices.get(x);
            for (int i = 0; i < matrizAux.length; i++) {
                for (int j = 0; j < matrizAux[i].length; j++) {
                    contenido += matrizAux[i][j] + " ";
                }
            contenido += "\n";
            }
            contenido += "\n";
        }
        contenido += "Tiempo de ejecucion: "+tiempoEjecucion+"\n";
        contenido += "Cantidad de Fallos: "+contadorFallos;
        
        dominosa.Interfaz.escribirTextBoxFuerzaBruta(contenido);
        crearArchivo(contenido, "FuerzaBruta_Doble"+size);
        return contenido;
    }
        
        //GENERA EL ARCHIVO DE SOLUCION DE BACKTRACKING CON UN FORMATO ESPECIFICO-------
    public String generarFormato_Backtracking(int matrix[][],long tiempoEjecucion){
        int size = matrix.length-1;
        String contenido = "Backtracking\n\nSize: "+size+"\n\n";
        contenido += "Matriz analizada\n";
        for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    contenido += matrix[i][j] + " ";
                }
            contenido += "\n";
            }
        //lista de soluciones
        contenido += "\nSoluciones:\n";
        for (int i=0; i<solucionesGeneral.size();i++){
            contenido += solucionesGeneral.get(i)+"\n";
        }
        //lista de matrices
        contenido += "\n\nMatrices de Soluciones:\n";
        for (int x=0; x<solucionesMatrices.size();x++){
            int [][] matrizAux = solucionesMatrices.get(x);
            for (int i = 0; i < matrizAux.length; i++) {
                for (int j = 0; j < matrizAux[i].length; j++) {
                    contenido += matrizAux[i][j] + " ";
                }
            contenido += "\n";
            }
            contenido += "\n";
        }
        
        contenido += "\nNo soluciones (Podas):\n";
        for (int i=0; i<noSoluciones0.size();i++){
            contenido += noSoluciones0.get(i)+"\n";
        }
        for (int i=0; i<noSoluciones1.size();i++){
            contenido += noSoluciones1.get(i)+"\n";
        }
        contenido += "\n\nTiempo de ejecucion: "+tiempoEjecucion+"\n";
        contenido += "Cantidad de Fallos: "+contadorFallos;
        dominosa.Interfaz.escribirTextBoxBacktracking(contenido);
        crearArchivo(contenido, "Backtracking_Doble"+size);
        return contenido;
    }
    
    //LLAMA AL ALGORITMO DE FUERZA BRUTA Y GENERA EL ARCHIVO
    public void auxiliarFuerzaBruta(int matrix[][]){
        long startTime = System.nanoTime();
        fuerzaBruta(matrix);// llamamos al método
        long endTime = System.nanoTime() - startTime; // tiempo en que se ejecuta su método
        generarFormato_FuerzaBruta(matrix,endTime);
    }
    
    //LLAMA AL ALGORITMO DE FUERZA BRUTA Y GENERA EL ARCHIVO
    public void auxiliarBacktracking(int matrix[][]){
        long startTime = System.nanoTime();
        Backtracking(matrix);// llamamos al método
        long endTime = System.nanoTime() - startTime; // tiempo en que se ejecuta su método
        generarFormato_Backtracking(matrix,endTime);
    }
    
    
    //GENERA MATRIZ X*Y ----------------------------------------------------------
    public int[][] generarmatriz (int filas, int columnas){
        int matriz[][] = new int[filas][columnas];
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
            matriz[x][y]=8;
            }
        }
        return matriz;
    }
     
    //ACTUALIZA LA MATRIZAUX (GLOBAL) PARA LA SOLUCIONES -------------------------
    //USAMOS ESTA MATRIZ PARA VALIDAR LA ORIENTACION DE LAS FICHAS
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
    
    //IMPRIME MATRIZ --------------------------------------------------------------
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
        //note que siempre se ubicaria el siguiente a la derecha (porque no habria espacio al otro lado)
        if (y+1 >= matrixAux[0].length){
            //System.out.println("Falso por que se pasa");
            return false;
        }
        if (matrixAux[x][y+1] != 8){
            //System.out.println("Falso porque esta ocupado");
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
        //System.out.println("Vertical");
        //System.out.println("x = "+x );
        //System.out.println("y = "+y );
        //note que siempre se ubicaria el siguiente a la derecha (porque no habria espacio al otro lado)
        if (x+1 >= matrixAux.length){
            //System.out.println("Falso");
            return false;
        }
        if (matrixAux[x+1][y] != 8){
            //System.out.println("Falso");
            return false;
        }
        return true;
    }

    //COMPRUEBA SI LA FICHA YA ESTA EN LA MATRIZ DE PUNTOS
    //RETORNA TRUE SI ESTA
    public boolean comprobarExistencia (Point ficha){
        Point reverso = new Point (ficha.y, ficha.x);
        //System.out.println("ficha x = "+ficha.x);
        //System.out.println("ficha y = "+ficha.y);

        for (int i = 0; i < dominoes.size(); i++){
            //revisa el contenido total de la ficha
            if ((dominoes.get(i).x == ficha.x && dominoes.get(i).y == ficha.y)  || (dominoes.get(i).x == reverso.x && dominoes.get(i).y == reverso.y)){
                return true;
            }
        }
        return false;
    }
    
    
 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     
    public boolean esSolucionFuerzaBruta (String solucion, int matrix[][]){
        String posicion = "0";  //se inicaliza en 0 solo por declararlo
        for (int i=0; i<solucion.length();i++){
            posicion = Character.toString(solucion.charAt(i));
            if (posicion.equals("0")){
                //verificar si la ficha puede ser horizontal
                if (!esHorizontal()){ //verificar tambien contenido
                    return false;
                }
                //si puede ser horizontal
                else{
                    //verifica contenido
                  Point puntoReferencia = retornaSiguientePoint();
                  Point ficha = new Point (matrix[puntoReferencia.x][puntoReferencia.y],matrix[puntoReferencia.x][puntoReferencia.y+1]);
                  if (!comprobarExistencia(ficha)){
                      //System.out.println("Agrega la ficha horizontal");
                      dominoes.add(ficha);//agrega la ficha a dominoes para validar contenido
                      actualiceMatrizAux ("Horizontal");
                  }
                  else{
                      return false;
                  }
 
                }
            }
            else{
                //verificar si la ficha puede ser vertical
                 if (!esVertical()){
                    return false;
                }
                 else{
                    Point puntoReferencia = retornaSiguientePoint();
                    Point ficha = new Point (matrix[puntoReferencia.x][puntoReferencia.y],matrix[puntoReferencia.x+1][puntoReferencia.y]);
                    
                    if (!comprobarExistencia(ficha)){
                        dominoes.add(ficha);//agrega la ficha a dominoes para validar contenido*/
                        actualiceMatrizAux ("Vertical");
                    }
                    
                    else{
                      //si llega aca el contenido de la ficha es repetido 
                      return false;
                    }
                }
      
            }
        }

        return true;
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public boolean verificadorSoluciones(String solucion){
        int contadorLetras=0; 
        if(solucion.startsWith("0")){
            for(int i=0; i<noSoluciones0.size(); i++){
                contadorLetras=noSoluciones0.get(i).length(); 
                //System.out.println("S: "+solucion);
                //System.out.println("SS "+solucion.substring(0,contadorLetras));
                //System.out.println("NS "+noSoluciones.get(i));
                if(solucion.substring(0,contadorLetras).equals(noSoluciones0.get(i))){
                    //System.out.println("Verificador retorna false");
                    //System.out.println("S: "+solucion);
                    //System.out.println("SS "+solucion.substring(0,contadorLetras));
                    //System.out.println("NS "+noSoluciones.get(i));
                    return false;      
                }
        
            }
        }else{
             for(int i=0; i<noSoluciones1.size(); i++){
                contadorLetras=noSoluciones1.get(i).length(); 
                //System.out.println("S: "+solucion);
                //System.out.println("SS "+solucion.substring(0,contadorLetras));
                //System.out.println("NS "+noSoluciones.get(i));
                if(solucion.substring(0,contadorLetras).equals(noSoluciones1.get(i))){
                    //System.out.println("Verificador retorna false");
                    //System.out.println("S: "+solucion);
                    //System.out.println("SS "+solucion.substring(0,contadorLetras));
                    //System.out.println("NS "+noSoluciones.get(i));
                    return false;  
                }
                
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
                                if(posicionesProceso.startsWith("0")){
                                    noSoluciones0.add(posicionesProceso);
                                }else{
                                    noSoluciones1.add(posicionesProceso);
                                }   
                            }
                            return false;
                        }
                        //si puede ser horizontal
                        else{
                            //verifica contenido
                          Point puntoReferencia = retornaSiguientePoint();
                          Point ficha = new Point (matrix[puntoReferencia.x][puntoReferencia.y],matrix[puntoReferencia.x][puntoReferencia.y+1]);
                          if (!comprobarExistencia(ficha)){
                              //System.out.println("Agrega la ficha horizontal");
                              dominoes.add(ficha);//agrega la ficha a dominoes para validar contenido
                              actualiceMatrizAux ("Horizontal");
                          }
                          else{
                              return false;
                            }
                        }
                    }
                
                else{
                    //verificar si la ficha puede ser vertical
                    if (!esVertical()){
                        if(posicionesProceso.length()<solucion.length()){
                            if(posicionesProceso.startsWith("0")){
                                noSoluciones0.add(posicionesProceso);
                            }else{
                                noSoluciones1.add(posicionesProceso);
                            }
                        }
                        return false;
                    }
                    else{
                        Point puntoReferencia = retornaSiguientePoint();
                        Point ficha = new Point (matrix[puntoReferencia.x][puntoReferencia.y],matrix[puntoReferencia.x+1][puntoReferencia.y]);

                        if (!comprobarExistencia(ficha)){
                            dominoes.add(ficha);//agrega la ficha a dominoes para validar contenido*/
                            actualiceMatrizAux ("Vertical");
                        }

                        else{
                          //si llega aca el contenido de la ficha es repetido 
                          return false;
                        }
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }

    
    ////////////////////////////////////////////////////////////////////////////
        public ArrayList<String> fuerzaBruta(int matrix[][]){
        solucionesMatrices = new ArrayList<int[][]>();  // limpia la matriz de soluciones
        solucionesGeneral = new ArrayList<String>();    //limpia arreflo de soluciones
        contadorFallos = 0;                             //limpia el contador de fallos
        
        //1-Calcular la cantidad de fichas
        int cantFichas = (matrix.length * matrix[0].length)/2;
        int cantidadFallos=0;
        int cantCombinaciones = (int)Math.pow(2, cantFichas);
        ArrayList<String> soluciones = new ArrayList<String>(); //guarda las soluciones correctas
              
        //3-Ciclo genera combiancion y la valida
        for (int i=0; i<cantCombinaciones; i++){
            dominoes = new ArrayList<Point>();
            //*-Generar matriz gemela de "8"
            matrixAux = generarmatriz (matrix.length, matrix[0].length);
            //1-Obtener posible combinacion i
            String posibleSolucion = Combinaciones.formatoCombinacion (cantFichas, i);
            //2- llama a esSolucion
            if (esSolucionFuerzaBruta(posibleSolucion,matrix)){
                //agregar solucion a soluciones
                soluciones.add(posibleSolucion);
                solucionesMatrices.add(matrixAux);
                
            }else{
                cantidadFallos+=1;
            }

        }
        System.out.println("Cantidad de fallas: "+cantidadFallos);
        solucionesGeneral = soluciones;
        contadorFallos = cantidadFallos;
        return soluciones;
    }
        
    
    public ArrayList<String> Backtracking(int matrix[][]){
        solucionesMatrices = new ArrayList<int[][]>();  //limpia la matriz de soluciones
        solucionesGeneral = new ArrayList<String>();    //limpia soluciones generales
        contadorFallos = 0;                             //limpia el contador de fallos
        
        int cantFichas = (matrix.length * matrix[0].length)/2;
        int cantidadFallos = 0;
        int contadorCiclo = 0;
       
        ArrayList<String> soluciones = new ArrayList<String>(); //guarda las soluciones correctas
        int cantCombinaciones = (int)Math.pow(2, cantFichas);
        
        //limipia soluciones anteriores
        noSoluciones0 = new ArrayList<String>();
        noSoluciones1 = new ArrayList<String>();
        
        //3-Ciclo para recorrer combinaciones
        for (int i=0; i<cantCombinaciones; i++){
            dominoes = new ArrayList<Point>();

            //*-Generar matriz gemela de "8"
            matrixAux = generarmatriz (matrix.length, matrix[0].length);
            //1-Obtener posible combinacion i
            String posibleSolucion = Combinaciones.formatoCombinacion (cantFichas, i);
            //2- llama a esSolucion
            if (esSolucionBacktracking(posibleSolucion,matrix)){
                //agregar solucion a algun arreglo
                soluciones.add(posibleSolucion);
                solucionesMatrices.add(matrixAux);
            }else{
                cantidadFallos+=1;
            }
        }
        System.out.println("Cantidad de fallas: "+cantidadFallos);
        System.out.println(noSoluciones0);
        System.out.println(noSoluciones1);
        solucionesGeneral = soluciones;
        contadorFallos = cantidadFallos;
        return soluciones;
    }
    
}
    
   