import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI_test {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();  // This line uses Apache POI
        System.out.println("Apache POI has been correctly set up!");
    }
}

//this is a test to see if POI has been successfully implemented
//POI is a java library that can handle Excel read/Write

//Result: Apache POI has been correctly set up!