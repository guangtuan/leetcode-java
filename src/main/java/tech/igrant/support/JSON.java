package tech.igrant.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSON {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> readTo(URL file, Class<T> tClass) {
        CollectionType type = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, tClass);
        try {
            return objectMapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static <T> T readToObject(URL file, Class<T> tClass) {
        try {
            return objectMapper.readValue(file, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


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

    public static String toJSONALine(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
