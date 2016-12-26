/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Mael
 */
public class EditaPlanilha {
    public static void edita(String diretorio, String arquivo, int linha, int coluna, String texto){
        try {
            File dir = new File(diretorio);
            File file = new File(dir,arquivo+".xlsx");
            InputStream inp = new FileInputStream(file);
            try {
                Workbook wb = WorkbookFactory.create(inp);
                Sheet sheet = wb.getSheetAt(0);
                Row row = sheet.getRow(linha);//LINHA
                Cell cell = row.getCell(0);
                    cell = row.createCell(coluna);//COLUNA
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(texto);
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    wb.write(fileOut);
                }
            } catch (IOException | InvalidFormatException ex) {
                Logger.getLogger(EditaPlanilha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditaPlanilha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main (String args[]){
        
        edita("C:\\GA_XLSX", "CONFIG4", 0, 0, "3");
        
    }
}
