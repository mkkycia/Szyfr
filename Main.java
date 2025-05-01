import io.FileManager;
import szyfry.Cezar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // wczytanie pliku
        System.out.println("Podaj ścieżkę do pliku tekstowego:");
        String filePath = scanner.nextLine();

        String content = FileManager.readFromFile(filePath);
        if (content == null) {
            System.out.println("Błąd odczytu pliku. Nie ma takiego pliku!");
            return;
        }

        // wybór szyfru
        System.out.println("Dostępne szyfry:");
        System.out.println("1 - Szyfr Cezara");
        // w przyszłości będzie więcej...

        System.out.println("Wybierz numer szyfru:");
        int cipherChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wybierz: (szyfruj/odszyfruj):");
        String action = scanner.nextLine();

        String result = null;

		// Szyfr Cezara
        if (cipherChoice == 1) {
            System.out.println("Podaj przesunięcie:");
            int shift = scanner.nextInt();
            scanner.nextLine();

            if (action.equalsIgnoreCase("szyfruj")) {
                result = CaesarCipher.encrypt(content, shift);
            } 
            else if (action.equalsIgnoreCase("odszyfruj")) {
                result = CaesarCipher.decrypt(content, shift);
            } 
            else {
                System.out.println("Nieprawidłowy wybór!");
                return;
            }
        } 
        else {
            System.out.println("Nieznany szyfr");
            return;
        }

        // wyświetlenie i zapisanie wyniku do output.txt
        System.out.println("Wynik:\n" + result);
        FileManager.writeToFile("output.txt", result);
        System.out.println("Zapisano pomyślnie wynik do pliku output.txt!");
    }
}
