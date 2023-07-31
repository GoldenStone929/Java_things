package JavaIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

// this is for read file

public class FileIOExample {
    public static void main(String[] args) {
//        String path = "/Users/sc/Java_things/src/test.txt";
        String path = "/Users/sc/Desktop/Java_things/src/JavaIO/test.txt";

        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}