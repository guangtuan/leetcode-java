package tech.igrant.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "error in to json";
        }
    }

    public static void printJSON(Object object) {
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void printJSONALine(Object object) {
        try {
            System.out.println(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
