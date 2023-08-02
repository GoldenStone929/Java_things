package JavaIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead2 {
    public static void main(String[] args) {
//        String txtTest = "Hi this is a random string for .xlsx test!";
        String txtPath = "/Users/sc/Desktop/Java_things/src/JavaIO/test.txt";
        String xlsxPath = "/Users/sc/Desktop/Java_things/src/JavaIO/excel.xlsx";


        String outputPath = "/Users/sc/Desktop/Java_things/src/JavaIO/outputExcel.txt";



        try {
            // Read content from txt file
            String txtContent = new String(Files.readAllBytes(Paths.get(txtPath)));

            // Write txtContent to outputExcel.xlsx file
            Files.write(Paths.get(outputPath), txtContent.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            // Append newline to outputExcel.xlsx file
            Files.write(Paths.get(outputPath), "\n".getBytes(), StandardOpenOption.APPEND);

            // Read content from xlsx file
            Workbook workbook = new XSSFWorkbook(Files.newInputStream(Paths.get(xlsxPath)));
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = cell.toString();

                    // Append cellValue to outputExcel.xlsx file
                    Files.write(Paths.get(outputPath), (cellValue + "\t").getBytes(), StandardOpenOption.APPEND);
                }
                // Append newline to outputExcel.xlsx file
                Files.write(Paths.get(outputPath), "\n".getBytes(), StandardOpenOption.APPEND);
            }
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
