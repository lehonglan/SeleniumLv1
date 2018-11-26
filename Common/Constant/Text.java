package Constant;

import java.util.List;
import com.google.gson.Gson;

public class Text {

    public static void main(String... args) throws Exception {
    	String JSON_PATH = "\\testDataResources\text.json";
        TextData data = new Gson().fromJson(JSON_PATH, TextData.class);
        
        System.out.println(data);
    }
}

class TextData {
    private static String railwayURL;
    private static String username;

    public static String getURL() { return railwayURL; }
    public static String getUsername() { return username; }

    }
