import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("If you don't know where the file path is, type 'T' below.\n");
        System.out.print("Please enter the text file path: ");
        String path = sc.nextLine();
        
        String filePath = getFilePath(sc, path);
        
        String content = readFileContent(filePath);
        
        if (content != null) {
            String newContent = processContent(content);
            writeFile("Seperated.txt", newContent);
            System.out.println("Separated successfully. Check your desktop.");
        }

        sc.close();
    }
    
    private static String getFilePath(Scanner sc, String path) {
        if (path.equalsIgnoreCase("T")) {
            System.out.println("Right-click on your text file > Properties >"
                + "\nBeside 'Location:' is the file path > Paste it in the program but every slash should be / >"
                + "\nHere is an example: C:/Users/rand/Desktop/text.txt"+"\n");
            System.out.print("Enter the path: ");
            return sc.nextLine();
        }
        return path;
    }
    
    private static String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }
    
    private static String processContent(String content) {
        return content.replaceAll(" ", "\n");
    }
    
    private static void writeFile(String fileName, String content) {
        File file = new File("C:/Users/rand/Desktop/" + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
