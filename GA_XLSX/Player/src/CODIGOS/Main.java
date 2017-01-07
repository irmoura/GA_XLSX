/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author irmoura
 */
public class Main {
    
    public static void play(String nomeDoAudio){
        try {
            FileInputStream fis = new FileInputStream("C:\\GA_XLSX\\"+nomeDoAudio+".mp3");
            try {
                Player playMP3 = new Player(fis);
                playMP3.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        
        if(args.length == 1){
            play(""+args[0]);
        }else
        if(args.length == 2){
            int delay = Integer.parseInt(args[1]);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            play(""+args[0]);
        }
        
    }
}
