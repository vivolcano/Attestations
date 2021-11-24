public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/admin/Desktop/attestations/src/main/resources/attestations_users.txt";
        UsersRepositoryFile repositoryFile = new UsersRepositoryFileImpl(fileName);

        int searchId = 5;
        User user = repositoryFile.findById(searchId);

        System.out.println("Загруженный User " + user);

        user.setAge(10);
        user.setName("Иннокентий");

        System.out.println("Отредактированный User " + user);

        repositoryFile.update(user);

    }
}
