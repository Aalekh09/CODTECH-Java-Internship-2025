import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "example.txt";

        try {
            // 1. Create a file
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write("This is the initial content in the file by Aalekh.\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");

            // 3. Read the file
            System.out.println("Reading file contents:");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();

            // 4. Append to the file
            FileWriter appender = new FileWriter(fileName, true);
            appender.write("This is the appended line.\n");
            appender.close();
            System.out.println("Successfully appended to the file.");

            // 5. Read again to show updated content
            System.out.println("Updated file contents:");
            Scanner updatedReader = new Scanner(file);
            while (updatedReader.hasNextLine()) {
                String data = updatedReader.nextLine();
                System.out.println(data);
            }
            updatedReader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
