package com.ctj.util;

/**
 * Created by tingjie.cao on 2016/9/18.
 */
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JacksonUtil {
    public JacksonUtil() {
    }

    public static Map<String, Object> readJsonToMap(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        Map m = null;

        try {
            m = (Map)mapper.readValue(jsonStr, new TypeReference() {
            });
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return m;
    }

    public static String mapToJson(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromMap = null;

        try {
            jsonfromMap = mapper.writeValueAsString(map);
        } catch (JsonProcessingException var4) {
            var4.printStackTrace();
        }

        return jsonfromMap;
    }

    public static <T> T readJson(String jsonStr, Class<?> collectionClass, Class... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        Object t = null;

        try {
            t = mapper.readValue(jsonStr, javaType);
        } catch (JsonParseException var7) {
            var7.printStackTrace();
        } catch (JsonMappingException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        return (T) t;
    }

    public static String listToJson(List<?> list) {
        ObjectMapper om = new ObjectMapper();
        String r = null;

        try {
            r = om.writeValueAsString(list);
        } catch (JsonGenerationException var4) {
            var4.printStackTrace();
        } catch (JsonMappingException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return r;
    }
}
