import java.util.Map;

public interface FileService {
    Map<Integer, User> inputFile(String fileName);
    void updateFile (Map<Integer, User> users, String fileName);
}
