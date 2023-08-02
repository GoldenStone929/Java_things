package JavaIO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("/Users/sc/Desktop/Java_things/src/JavaIO/excelFile.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);  // Get the first sheet

            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Print the cell's content
                    System.out.println(cell.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
