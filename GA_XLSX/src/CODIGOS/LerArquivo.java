/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author irmoura
 */
public class LerArquivo {
    
    public String v;//VEZ
    public String TDA;//TOTAL DE ATENDIMENTO
    public String AT1;//TOTAL DE ATENDIMENTO 1
    public String AT2;//TOTAL DE ATENDIMENTO 2
    public String AT3;//TOTAL DE ATENDIMENTO 3
    public String AT4;//TOTAL DE ATENDIMENTO 4
    public String t0;
    public String t1;
    public String t2;
    public String t3;
    public String t4;
    public String t5;
    public String t6;
    
    public void LerArquivo(){
        
        Date dataSistema = new Date();
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        int dia_int = Integer.parseInt(dia.format(dataSistema));
        int mes_int = Integer.parseInt(mes.format(dataSistema));
        int ano_int = Integer.parseInt(ano.format(dataSistema));
        
        String Registro = dia_int+"-"+mes_int+"-"+ano_int;
        
        File dir = new File("C:\\GA_XLSX\\"+Registro+"\\");//LER
        
        File arq = new File(dir,"File.txt");//LER
        try {
            FileReader fileReader = new FileReader(arq);//LER
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                if(Tela.QDT == 3){
                v = bufferedReader.readLine();//VEZ
                TDA = bufferedReader.readLine();//TOTAL DE ATENDIMENTO
                AT1 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 1
                AT2 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 2
                AT3 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 3
                t0 = bufferedReader.readLine();//
                t1 = bufferedReader.readLine();//
                t2 = bufferedReader.readLine();//
                t3 = bufferedReader.readLine();//
                t4 = bufferedReader.readLine();//
                t5 = bufferedReader.readLine();//
                t6 = bufferedReader.readLine();//
                }
                if(Tela.QDT == 4){
                v = bufferedReader.readLine();//VEZ
                TDA = bufferedReader.readLine();//TOTAL DE ATENDIMENTO
                AT1 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 1
                AT2 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 2
                AT3 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 3
                AT4 = bufferedReader.readLine();//TOTAL DE ATENDIMENTO 4
                t0 = bufferedReader.readLine();//
                t1 = bufferedReader.readLine();//
                t2 = bufferedReader.readLine();//
                t3 = bufferedReader.readLine();//
                t4 = bufferedReader.readLine();//
                t5 = bufferedReader.readLine();//
                t6 = bufferedReader.readLine();//
                }
//                System.out.println(TA);
            } catch (IOException ex) {
//                Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
//          Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
            //SE NAO ACHAR O ARQUIVO É CRIADO 
            if(!(arq.exists())){
                CriaArquivoNovo ca = new CriaArquivoNovo();
                ca.CriaArquivoNovo();
            }
        }
        
    }
}
