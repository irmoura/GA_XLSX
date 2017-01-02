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
import javax.swing.JOptionPane;

/**
 *
 * @author irmoura
 */
public class CriaArquivoNovo {
    public void CriaArquivoNovo(){
        
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
            /*VALORES PADRAO*/
            if(Tela.QDT == 3){
              gravarArq.println("0");//VEZ
              gravarArq.println("0");//TOTAL DE ATENDIMENTO
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 1
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 2
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 3
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
            }else
            if(Tela.QDT == 4){
              gravarArq.println("0");//VEZ
              gravarArq.println("0");//TOTAL DE ATENDIMENTO
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 1
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 2
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 3
              gravarArq.println("0");//TOTAL DE ATENDIMENTO 4
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
              gravarArq.println("0");//
            }
        }
        
        try {
            Obs.close();
            JOptionPane.showMessageDialog(null,"Base de dados criada com sucesso.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(CriaArquivoNovo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
