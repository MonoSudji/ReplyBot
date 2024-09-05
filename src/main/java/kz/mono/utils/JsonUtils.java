package kz.mono.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<Long> readModeratorIdsFromJson(String filePath) {
        List<Long> moderatorIds = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("moderators");
            for (JsonElement element : jsonArray) {
                moderatorIds.add(element.getAsLong());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moderatorIds;
    }
}
