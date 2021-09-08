/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominosa;

import java.awt.Point;

/**
 *
 * @author monic
 */
public class Dominosa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //Me duele la cabeza a little too much, por ahora dejo medio escrita mi idea, pero hay varias cosas que debo chequear. xd
    
    public Point[][] generateDominoes(int n, int m){
        Point dominoes[][]=null;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                Point point=new Point();
                point.x=-1;
                point.y=-1;
                dominoes[i][j]=point;
            }
        }
    return dominoes;
    }
    
    //n=# filas.
    //m=# columnas.
    //matriz: matriz recibida.
    //dominoes: lista de dominos chequeados.
    //done: Terminó y encontró una forma. True para fin, False para continuar.
    public void FuerzaBruta(Boolean done, int matrix[][], int n, int m,  Point dominoes[][]){
        if(done==false && dominoes.length==0){ //Si es la primera vez que corre
            Point point0=new Point();
            point0.x=matrix[0][0];
            point0.y=matrix[0][1]; 
            dominoes[0][0]=point0;//Agregue el domino horizontal desde 0,0 |=|
        //else if caso si el domino horizontal NO funciona
        }else{
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if(dominoes[i][j].x==matrix[i][j]){ //Si la x del domino almacenado tiene el mismo valor que el de la matriz
                        //validación contra n y m
                        if(dominoes[i][j].y==matrix[i+1][j]){ //Si alguna pieza alrededor coincide con la horizontal
                   
                       
                       }else if(dominoes[i][j].y==matrix[i][j+1]){
                       
                       }else if(dominoes[i][j].y==matrix[i-1][j]){
                       
                       }else if(dominoes[i][j].y==matrix[i][j-1]){
                       
                       }else{
                           //Agregar a dominoes.
                       }         
                    }
                }
            }
        } 
    }
    
}
