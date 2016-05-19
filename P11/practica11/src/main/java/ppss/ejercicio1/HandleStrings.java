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
public class HandleStrings {
    public String extractMiddle(String s){
        int idx1 = s.indexOf(':');
        int idx2 = s.indexOf(':', idx1 + 1);
        return s.substring(idx1 + 1, idx2);
    }
}
