import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class StorageManager {
    private static final String FILE_NAME = "Profil.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(UserProfile profile) {
        try {
            mapper.writeValue(new File(FILE_NAME), profile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserProfile load() {
        try {
            return mapper.readValue(new File(FILE_NAME), UserProfile.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}