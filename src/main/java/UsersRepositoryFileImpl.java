import java.util.Map;

public class UsersRepositoryFileImpl implements UsersRepositoryFile {

    private final FileService fileService;
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileService = new FileServiceTxt();
        this.fileName = fileName;
    }

    @Override
    public User findById(int searchId) {
        Map<Integer, User> users = fileService.inputFile(this.fileName);

        if (users.containsKey(searchId))
            return users.get(searchId);
        else
            throw new NullPointerException("id not found");
    }

    @Override
    public void update(User user) {
        Map<Integer, User> users = fileService.inputFile(this.fileName);
        users.put(user.getId(), user);

        fileService.updateFile(users, this.fileName);
    }
}







