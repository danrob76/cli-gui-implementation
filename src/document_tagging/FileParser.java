package document_tagging;

import java.io.*;

public class FileParser {
    public String parseFile(String filePath) {
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String text = content.toString();
        return text;  // Return the cleaned text
    }
}
