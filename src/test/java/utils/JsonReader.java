package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static List<Map<String, String>> read(String path) {
        try (InputStream in = JsonReader.class.getClassLoader().getResourceAsStream(path);
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {

            Type type = new TypeToken<List<Map<String, String>>>() {}.getType();
            return new Gson().fromJson(reader, type);


        } catch (Exception e) {
            throw new RuntimeException("JSON file vachta aali nahi: " + path, e);
        }
    }
}