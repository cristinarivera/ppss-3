/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
class StringBuilderFactoria {
    private static StringBuilder sb;
    
    public static StringBuilder create(){
        if(sb!=null) return sb;
        else return new StringBuilder();
    }
    
    public void setStringBuilder(StringBuilder sb){
        this.sb = sb;
    }
    
    public String toString(){
        return sb.toString();
    }
}
