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
public class Point {
    public int x;
    public int y;
    public Point ubicacion1;
    public Point ubicacion2;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y, Point ubicacion1, Point ubicacion2) {
        this.x = x;
        this.y = y;
        this.ubicacion1 = ubicacion1;
        this.ubicacion2 = ubicacion2;
    }
    
}
