import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

public class InsecureDeserialization {
    public static void main(String[] args) {
        String serializedObject = "rO0ABXNyABFqYXZhLnV0aWwuQXJyYXlMaXN0eHHg3gAAAAAAeHB3BAAAAAB4"; // Example of a serialized object
        Object obj = deserializeObject(serializedObject);
        System.out.println("Deserialized object: " + obj);
    }

    public static Object deserializeObject(String base64SerializedObject) {
        try {
            byte[] data = Base64.getDecoder().decode(base64SerializedObject);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
