/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class MultiPathExample {
    public int multiPath(int a, int b, int c){
        if(a>5){
            c+=a;
        }
        if(b>5){
            c+=b;
        }
        return c;
    }
}
