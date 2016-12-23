/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author irmoura
 */
public class ModificaArquivo {
    public void ModificaArquivo(int v, int TDA, int AT1, int AT2, int AT3, int t0, int t1, int t2, int t3, int t4, int t5, int t6){
        
        Date dataSistema = new Date();
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        int dia_int = Integer.parseInt(dia.format(dataSistema));
        int mes_int = Integer.parseInt(mes.format(dataSistema));
        int ano_int = Integer.parseInt(ano.format(dataSistema));
        
        FileWriter Obs = null;
        
        String Registro = dia_int+"-"+mes_int+"-"+ano_int;
        
        try {
            Obs = new FileWriter("C:\\GA_XLSX\\"+Registro+"\\File.txt");
        } catch (IOException ex) {
            Logger.getLogger(CriaArquivoNovo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter gravarArq = new PrintWriter(Obs);
        {
              gravarArq.println(""+v);//VEZ
              gravarArq.println(""+TDA);//TOTAL DE ATENDIMENTO
              gravarArq.println(""+AT1);//TOTAL DE ATENDIMENTO 1
              gravarArq.println(""+AT2);//TOTAL DE ATENDIMENTO 2
              gravarArq.println(""+AT3);//TOTAL DE ATENDIMENTO 3
              gravarArq.println(""+t0);//
              gravarArq.println(""+t1);//
              gravarArq.println(""+t2);//
              gravarArq.println(""+t3);//
              gravarArq.println(""+t4);//
              gravarArq.println(""+t5);//
              gravarArq.println(""+t6);//
        }
        
        try {
            Obs.close();
        } catch (IOException ex) {
            Logger.getLogger(CriaArquivoNovo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
