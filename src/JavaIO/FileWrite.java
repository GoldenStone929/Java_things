//package JavaIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

/*With StandardOpenOption.CREATE, if the file doesn't already exist, it will be created. With StandardOpenOption.WRITE,
if the file does exist, its content will be truncated (cleared) before the new content is written.*/
public class FileWrite {
    public static void main(String[] args) {
        String pathA = "/Users/sc/Desktop/Java_things/src/JavaIO/test.txt";
        String pathB = "/Users/sc/Desktop/Java_things/src/JavaIO/FileB.csv";
        String outputPath = "/Users/sc/Desktop/Java_things/src/JavaIO/outputExcel.txt";


        try {
            // Read content from file A.txt
            String contentA = new String(Files.readAllBytes(Paths.get(pathA)));

            // Write contentA to outputExcel.xlsx file
            Files.write(Paths.get(outputPath), contentA.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            // Append newline to outputExcel.xlsx file
            Files.write(Paths.get(outputPath), "\n".getBytes(), StandardOpenOption.APPEND);

            // Read content from file B.txt
            String contentB = new String(Files.readAllBytes(Paths.get(pathB)));

            // Append contentB to outputExcel.xlsx file
            Files.write(Paths.get(outputPath), contentB.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
