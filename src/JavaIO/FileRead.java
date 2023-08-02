package JavaIO;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

// this is for read file

public class FileRead {
    public static void main(String[] args) {
//        String path = "/Users/sc/Java_things/src/test.txt";
//        String path = "/Users/sc/Desktop/Java_things/src/JavaIO/test.txt";
          String path_Excel = "/Users/sc/Desktop/Java_things/src/JavaIO/excelFile.xlsx";
          String path_SDF = "/Users/sc/Desktop/Java_things/src/JavaIO/sdfExample.sdf";


        try {
            String content = new String(Files.readAllBytes(Paths.get(path_Excel)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } // this is for Excel Output testing


        try {
            String content = new String(Files.readAllBytes(Paths.get(path_SDF)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } // this is for SDF file ore
    }
}

