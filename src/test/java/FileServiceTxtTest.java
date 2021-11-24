import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

class FileServiceTxtTest {

    @Test
    @DisplayName("Проверка корректности загрузкии файлов")
    void inputFile() {

        final String fileName = "/Users/admin/Desktop/attestations/src/main/resources/attestations_users_test.txt";
        final FileService fileService = new FileServiceTxt();

        final Map<Integer, User> expended = new HashMap<>();
        expended.put(1, new User(1, "Никита", 25, false));
        expended.put(2, new User(2, "Олег", 44, true));
        expended.put(3, new User(3, "Филипп", 55, false));

        final Map<Integer, User> actual = fileService.inputFile(fileName);

        Assertions.assertEquals(expended, actual);
    }

}