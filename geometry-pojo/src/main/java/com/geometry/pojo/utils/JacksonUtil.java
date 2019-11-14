package com.geometry.pojo.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JacksonUtil {

    private static ObjectMapper mapper;

    static {
        //noinspection ConstantConditions
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        String json = null;
        if (object != null) {
            try {
                json = mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                log.info("json转换异常{}" + object);
                e.getMessage();
            }
        }
        return json;
    }

    /**
     * 转成bean
     *
     * @param jsonStr
     * @param cls
     * @return
     */
    public static <T> T stringToBean(String jsonStr, Class<T> cls) {
        T t = null;
        if (mapper != null) {
            try {
                mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                t = mapper.readValue(jsonStr, cls);
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return t;
    }

    /**
     * Json格式的字符串向JavaBean List集合转换，传入空串将返回null
     * @param strBody
     * @param c
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> json2ObjectList(String strBody, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, c);
            return (List<T>) mapper.readValue(strBody, javaType);
        }
    }

    /**
     * Json格式的字符串向JavaBean List集合转换，传入空串将返回null
     * @param strBody
     * @param c
     * @return 对象列表，解析失败返回 null
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> decodeJsonToList(String strBody,Class<T> c) {
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, c);
            try {
                return (List<T>) mapper.readValue(strBody, javaType);
            } catch (IOException e) {
                e.printStackTrace();

                return null;
            }
        }
    }

    /**
     * Json格式的字符串向List<String>集合转换，传入空串将返回null
     * @param strBody
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static List<String> json2List(String strBody) throws JsonParseException, JsonMappingException, IOException{
        return json2ObjectList(strBody, String.class);
    }
}