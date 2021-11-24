import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileServiceTxt implements FileService {
    
    public FileServiceTxt() {
    }

    @Override
    public Map<Integer, User> inputFile(String fileName) {
        Map<Integer, User> usersFromTxtFile = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;

            while ((str = br.readLine()) != null) {
                String[] parts = str.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean isWorker = Boolean.parseBoolean(parts[3]);

                usersFromTxtFile.put(id, new User(id, name, age, isWorker));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return usersFromTxtFile;
    }

    @Override
    public void updateFile(Map<Integer, User> users, String fileName) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, false))) {

            Set<Map.Entry<Integer, User>> entries = users.entrySet();

            for (Map.Entry<Integer, User> entry : entries) {
                br.write(entry.getValue().getId() + "|" + entry.getValue().getName() + "|"
                        + entry.getValue().getAge() + "|" + entry.getValue().isWorker() + "\n");
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
