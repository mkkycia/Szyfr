package io; // pakiet input/output
import java.io.*;

// FileManager odczytuje zawartość pliku tekstowego ze wskazanej ścieżki (np. input.txt) i zwraca ją jako jeden ciąg tekstowy (np. output.txt)
public class FileManager {
	// odczyt z inputu
    public static String readFromFile(String path) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			// Czytanie każdej linii z pliku i dodawanie jej do StringBuildera
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } 
        catch (IOException e) { // gdy plik nie istnieje to informacja o błędzie
            e.printStackTrace();
            return null;
        }

        return content.toString();
    }
	
	// zapisanie do outputu
    public static void writeToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
