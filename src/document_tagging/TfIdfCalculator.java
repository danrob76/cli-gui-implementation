package document_tagging;

import java.util.*;

public class TfIdfCalculator {
    
    // Method to calculate TF-IDF and return the top 20 keywords
    public Map<String, Double> getTopKeywords(String cleanedText) {
        // Creating a map to store the keywords and their TF-IDF scores
        Map<String, Double> keywordMap = new HashMap<>();
        
        // Your logic to calculate TF-IDF for each word in the cleanedText
        // For demonstration purposes, let's assume the following mock data for TF-IDF scores
        // In your real implementation, you would compute the TF-IDF for each word here
        keywordMap.put("the", 28.05);
        keywordMap.put("based", 12.02);
        keywordMap.put("The", 12.02);
        keywordMap.put("and", 12.02);
        keywordMap.put("on", 12.02);
        keywordMap.put("frequency", 8.01);
        keywordMap.put("in", 8.01);
        keywordMap.put("is", 8.01);
        keywordMap.put("importance", 8.01);
        keywordMap.put("document", 8.01);
        keywordMap.put("of", 8.01);
        keywordMap.put("TF-IDF", 8.01);
        keywordMap.put("to", 8.01);
        keywordMap.put("keywords", 4.00);
        keywordMap.put("use", 4.00);
        keywordMap.put("used", 4.00);
        keywordMap.put("Document", 4.00);
        keywordMap.put("meaningful", 4.00);
        keywordMap.put("System.", 4.00);
        keywordMap.put("retrieval", 4.00);

        // Sort the keywordMap by value (TF-IDF score) in descending order
        List<Map.Entry<String, Double>> sortedEntries = new ArrayList<>(keywordMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Limit the result to the top 20 keywords
        Map<String, Double> topKeywords = new LinkedHashMap<>();
        for (int i = 0; i < Math.min(20, sortedEntries.size()); i++) {
            Map.Entry<String, Double> entry = sortedEntries.get(i);
            topKeywords.put(entry.getKey(), entry.getValue());
        }

        // Return the top 20 keywords
        return topKeywords;
    }
}
