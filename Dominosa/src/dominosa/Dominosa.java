/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import java.util.ArrayList;

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
    public static Point puntito = new Point(-1,-1);
    public static int matrixAux[][];
    //Me duele la cabeza a little too much, por ahora dejo medio escrita mi idea, pero hay varias cosas que debo chequear. xd

   /* 
    public static void generateDominoes(int n){
        for (int i = 0; i < n; i++){
            Point point=new Point(-1,-1);
            dominoes.add(point);
        }
    }*/
    
    //COMPRUEBA SI LA FICHA YA ESTA EN LA MATRIZ DE PUNTOS
    //RETORNA TRUE SI ESTA
    public boolean comprobarExistencia (Point ficha){
        Point reverso = new Point (ficha.y, ficha.x);
        
        for (int i = 0; i < dominoes.size(); i++){
            //revisa ubicacion 1
            if (dominoes.get(i).ubicacion1 == ficha.ubicacion1){
                return true;
            }
            //revisa ubicacion 2
            if (dominoes.get(i).ubicacion2 == ficha.ubicacion2){
                return true;
            }
            //revisa el contenido total de la ficha
            if ((dominoes.get(i).x == ficha.x && dominoes.get(i).y == ficha.y)  || (dominoes.get(i).x == reverso.x && dominoes.get(i).y == reverso.y)){
               return true;
            }
            //
            
        }
        return false;
    }
    
    //COMPRUEBA SI UNA FICHA ES NUEVA
    //SI LO ES LA AGREGA Y RETORNA TRUE
    public boolean agregarFicha (int x1, int y1, int x2, int y2 ,int contador,int matrix[][]){
       /* System.out.print("\nx1 "+x1 + "\n");
        System.out.print("y1 "+y1+"\n");
        System.out.print("x2 "+x2 + "\n");
        System.out.print("y2 "+y2 + "\n");*/
        Point ubi1 = new Point (x1,y1);
        Point ubi2 = new Point (x2,y2);
        Point punto=new Point(matrix[x1][y1],matrix[x2][y2],ubi1,ubi2);
        //punto.primeroUbicacion = punto
        //punto.segundaUbicacion = punto
        if (!comprobarExistencia(punto)){
            dominoes.add(punto);
            return true;
        }
        return false;
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
    //n=# filas.
    //m=# columnas.
    //matriz: matriz recibida.
    //dominoes: lista de dominos chequeados.
    //done: Terminó y encontró una forma. True para fin, False para continuar.
    public void FuerzaBruta(Boolean done, int matrix[][], int n, int m,  ArrayList<Point> dominoes, int recoridoX, int recorridoY,int contadorDominoes){
        if(done==false && dominoes.isEmpty()){ //Si es la primera vez que corre
            Point point0_ubicacion1 = new Point (0,0);
            Point point0_ubicacion2 = new Point (0,1);
            Point point0=new Point(matrix[0][0],matrix[0][1],point0_ubicacion1,point0_ubicacion2);
            dominoes.add(point0);//Agregue el domino horizontal desde 0,0 |=|
        //else if caso si el domino horizontal NO funciona
        }
        
        //ESQUINA SUPERIOR DERECHA-------------------------------------
        //HORIZONTAL
        if (!agregarFicha (0,matrix[0].length-2, 0,matrix[0].length-1,contadorDominoes,matrix)){
            //VERTICAL
            agregarFicha (0,matrix[0].length -1, 1,matrix[0].length -1,contadorDominoes,matrix);
        }
        
        //ESQUINA INFERIOR IZQUIERDA-------------------------------------
        //HORIZONTAL
        if (!agregarFicha (matrix.length -1,0,matrix.length -1,1,contadorDominoes,matrix)){
            //VERTICAL
            agregarFicha (matrix.length -2,0,matrix.length -1,0,contadorDominoes,matrix);
        }
        
        //ESQUINA INFERIOR DERECHA-------------------------------------
        //HORIZONTAL
        if (!agregarFicha (matrix.length -1,matrix[0].length -2, matrix.length -1,matrix[0].length -1,contadorDominoes,matrix)){
            //VERTICAL
            agregarFicha (matrix.length -2,matrix[0].length -1,matrix.length -1,matrix[0].length -1,contadorDominoes,matrix);
        }
        imprimirDominoes ();
       
    }
 
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
    //IMPRIME MATRIZ ///////////////////////////////////////
    public void imprimirMatriz (int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
    public Point verificarOrientacion (String orientacion){
        if (orientacion.equals("Vertical")){
            
        }
        else if (orientacion.equals("Horizontal")){
            
        }
        else{
            return null;
        }
        
    }*/
    
    //Retorna en un punto la siguinete posicion libre en la matrizAux
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
    
    public boolean esHorizontal (){
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
    
    public boolean esVertical (){
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
    
    public boolean esSolucion (String solucion, int matrix[][]){
        String posicion = "0";  //se inicaliza en 0 solo por declararlo
        for (int i=0; i<solucion.length();i++){
            posicion = Character.toString(solucion.charAt(i));
            if (posicion.equals("0")){
                //verificar si la ficha puede ser horizontal
                if (!esHorizontal ()){
                    return false;
                }
                else{
                    actualiceMatrizAux ("Horizontal");
                }
            }
            else{
                //verificar si la ficha puede ser vertical
                 if (!esVertical ()){
                    return false;
                }
                 else{
                    actualiceMatrizAux ("Vertical");
                 }
            }
        }
        System.out.println(solucion);
        System.out.println("Solucion = true");
        return true;
    }
    

    
    
    public ArrayList<String> fuerzaBrutaPrueba(int matrix[][]){
        

        //1-Calcular la cantidad de fichas
        int cantFichas = (matrix.length * matrix[0].length)/2;
        
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
            if (esSolucion(posibleSolucion,matrix)){
                //agregar solucion a algun arreglo
                soluciones.add(posibleSolucion);
                
            }
        }
        return soluciones;
    }
}
