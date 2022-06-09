package util;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonReader {
JsonArray data;

    public JsonArray getData(){
        return data;
    }

    public void jsonReader() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/data.json"));
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            data = (JsonArray) parser.get("data");
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
