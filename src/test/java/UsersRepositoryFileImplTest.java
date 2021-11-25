import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class UsersRepositoryFileImplTest {

    @Test
    @DisplayName("Проверка получения User по id")
    void findById() {

        final String fileName = "/Users/admin/Desktop/attestations/src/main/resources/attestations_users_test.txt";
        final UsersRepositoryFile repositoryFile = new UsersRepositoryFileImpl(fileName);

        final User expended = new User(1, "Никита", 25, false);

        final User result = repositoryFile.findById(1);

        Assertions.assertEquals(expended, result);


    }

    @Test
    @DisplayName("Проверка корректности записи файла")
    void update() throws IOException {
        final String fileName = "/Users/admin/Desktop/attestations/src/main/resources/actual_test.txt";
        final UsersRepositoryFile repositoryFile = new UsersRepositoryFileImpl(fileName);
        final User user = new User(1, "Василий", 90, true);

        final File expected =
                new File("/Users/admin/Desktop/attestations/src/main/resources/expected_test.txt");

        repositoryFile.update(user);

        final File actual =
                new File(fileName);

        Assertions.assertTrue(FileUtils.contentEquals(expected,actual));
    }
}
