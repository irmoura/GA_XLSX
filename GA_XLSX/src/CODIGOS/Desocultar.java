/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author irmoura
 */
public class Desocultar {
    public static void desocultar(File file){
        
        try { 
            Runtime.getRuntime().exec("attrib -a -s -h \""+file.getAbsolutePath().toString()+"\"");
        } catch (IOException ex) {
            Logger.getLogger(Ocultar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    public static void main(String args[]){
        /**********************************************************************/
        File file = new File("C:\\GA_XLSX\\25-12-2016");
        
        desocultar(file);//APÓS CRIAR A PASTA A MESMA É OCULTADA
        /**********************************************************************/
    }
}
