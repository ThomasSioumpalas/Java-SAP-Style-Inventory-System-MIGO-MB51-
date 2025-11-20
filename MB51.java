import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MB51 {

    public static void showAllEntries() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/myfile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
}