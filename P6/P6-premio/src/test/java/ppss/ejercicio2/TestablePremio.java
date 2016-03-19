/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import ppss.ejercicio2.Premio;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
class TestablePremio extends Premio {
    private float f;
    
    @Override
    public float generaNumero(){
        return f;
    }
    
    public void setNumero(float f){
        this.f = f;
    }
    
    public void setCliente(ClienteWebService c){
        cliente=c;
    }
}
