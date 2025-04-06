package document_tagging;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainSwingGUI {
    public static void main(String[] args) {
        // Create the GUI frame
        JFrame frame = new JFrame("Document Tagging System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create UI components
        JLabel label = new JLabel("Enter the full path to your .txt file:");
        JTextField filePathField = new JTextField(30);
        JButton loadButton = new JButton("Load Document");
        JTextArea resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(filePathField);
        panel.add(loadButton);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Button action
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = filePathField.getText().trim();
                if (!filePath.isEmpty()) {
                    FileParser parser = new FileParser();
                    String cleanedText = parser.parseFile(filePath);

                    if (cleanedText != null && !cleanedText.isEmpty()) {
                        TfIdfCalculator tfidf = new TfIdfCalculator();
                        Map<String, Double> topKeywords = tfidf.getTopKeywords(cleanedText);

                        StringBuilder result = new StringBuilder("Top Keywords:\n");
                        int count = 1;
                        for (Map.Entry<String, Double> entry : topKeywords.entrySet()) {
                            result.append(count).append(". ")
                                  .append(entry.getKey()).append(": ")
                                  .append(String.format("%.2f", entry.getValue())).append("\n");
                            if (count++ == 20) break;
                        }
                        resultArea.setText(result.toString());
                    } else {
                        resultArea.setText("Could not read or process the file.");
                    }
                } else {
                    resultArea.setText("Please enter a valid file path.");
                }
            }
        });
    }
}
