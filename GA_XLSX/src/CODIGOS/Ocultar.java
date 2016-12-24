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
public class Ocultar {
    public static void ocultar(File file){
        
        try { 
            Runtime.getRuntime().exec("attrib +a +s +h \""+file.getAbsolutePath().toString()+"\"");
        } catch (IOException ex) {
            Logger.getLogger(Ocultar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
