
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework10task1 {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\aspir\\IdeaProjects\\untitled14\\src\\main\\java\\file1.txt";
        printValidPhoneNumbers(inputFile);
    }

    private static void printValidPhoneNumbers(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("(\\(\\d{3}\\) \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
