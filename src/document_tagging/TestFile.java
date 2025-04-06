package document_tagging;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("C:/Users/RatRa/Documents/example.txt");
        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found.");
        }
    }
}
