package JavaIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {
        String pathA = "/Users/sc/Desktop/Java_things/src/JavaIO/test.txt";
        String pathB = "/Users/sc/Desktop/Java_things/src/JavaIO/FileB.csv";
        String outputPath = "/Users/sc/Desktop/Java_things/src/JavaIO/output";

        try {
            // Read content from file A.txt
            String contentA = new String(Files.readAllBytes(Paths.get(pathA)));

            // Write contentA to output file
            Files.write(Paths.get(outputPath), contentA.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            // Append newline to output file
            Files.write(Paths.get(outputPath), "\n".getBytes(), StandardOpenOption.APPEND);

            // Read content from file B.txt
            String contentB = new String(Files.readAllBytes(Paths.get(pathB)));

            // Append contentB to output file
            Files.write(Paths.get(outputPath), contentB.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
