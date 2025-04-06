package document_tagging;

	import java.io.File;
	import java.util.Map;
	import java.util.Scanner;

	import java.io.FileNotFoundException;

	public class CommandLineInterface {
	    public void start() {
	        try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Enter the full path to your .txt file: ");
				String filePath = scanner.nextLine();  // Get the file path

				// Check if the file exists
				File file = new File(filePath);
				if (!file.exists()) {
				    System.out.println("Error: File not found. Please check the path and try again.");
				    return;  // Exit the method if file is not found
				}

				// Try to read the file content
				try {
				    Scanner fileReader = new Scanner(file);
				    StringBuilder inputDocument = new StringBuilder();
				    while (fileReader.hasNextLine()) {
				        inputDocument.append(fileReader.nextLine()).append("\n");
				    }
				    fileReader.close();
				    
				    // Check if inputDocument is null or empty
				    if (inputDocument.toString().isEmpty()) {
				        System.out.println("Error: The file is empty.");
				        return;
				    }

				    // Continue processing the document
				    TfIdfCalculator calculator = new TfIdfCalculator();
				    Map<String, Double> topKeywords = calculator.getTopKeywords(inputDocument.toString());
				    System.out.println("Top Keywords: " + topKeywords);

				} catch (FileNotFoundException e) {
				    System.out.println("An error occurred while reading the file.");
				    e.printStackTrace();
				}
			}
	    }
	}
