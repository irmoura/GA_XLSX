/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author irmoura
 */
public class CriaPasta {   
    public void CriaPasta(){
        Date dataSistema = new Date();
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        int dia_int = Integer.parseInt(dia.format(dataSistema));
        int mes_int = Integer.parseInt(mes.format(dataSistema));
        int ano_int = Integer.parseInt(ano.format(dataSistema));
        
        System.out.println(dia_int+"-"+mes_int+"-"+ano_int);
        
        java.io.File DATA_DA_PASTA = new java.io.File("C:\\GA_XLSX\\"+dia_int+"-"+mes_int+"-"+ano_int);//CRIA A PASTA COM A DATA DEFINIDA NO SISTEMA
        DATA_DA_PASTA.mkdir();
        
        /**********************************************************************/
        File file = new File("C:\\GA_XLSX\\"+dia_int+"-"+mes_int+"-"+ano_int);
        
        Ocultar o = new Ocultar();
        
        o.ocultar(file);//APÓS CRIAR A PASTA A MESMA É OCULTADA
        /**********************************************************************/
        
    }
}
