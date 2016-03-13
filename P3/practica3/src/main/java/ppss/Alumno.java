/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class Alumno {
    public Alumno(){
    }
    public boolean validaNif(String nif) {
        if(nif.length()!=9) {
            return false;
        }

        String dni = nif.substring(0, 8);
        char letra = nif.charAt(8);

         //A partir de una expresión regular, obtenemos una representación
         //compilada (objeto de tipo Pattern)
        Pattern pattern = Pattern.compile("[0-9]{8,8}");
         //El patrón obtenido se utiliza para crear un objeto Matcher
        Matcher matcher = pattern.matcher(dni);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        long ldni;
        try {
            ldni = Long.parseLong(dni);

        } catch(NumberFormatException e) {
            return false;
        }

        char letraEsperada = ' ';
        int indice = (int)(ldni % 23);
        if(indice>=0) letraEsperada = letras.charAt(indice);

        //if(!matcher.matches()) System.out.println("matches is false     " + nif);
        return matcher.matches() && letra==letraEsperada;

    }   
}
