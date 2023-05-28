
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (or use Lombok for automatic generation)

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class homework10task2 {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\aspir\\IdeaProjects\\untitled14\\src\\main\\java\\file.txt";
        String outputFile = "user.json";
        List<User> userList = readUserListFromFile(inputFile);
        writeUserListToJsonFile(userList, outputFile);
    }

    private static List<User> readUserListFromFile(String inputFile) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine(); // Skip the header line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    User user = new User(name, age);
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    private static void writeUserListToJsonFile(List<User> userList, String outputFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
