package worksynch.util;

import java.lang.reflect.Type;

import java.util.Date;
 
import com.google.gson.JsonElement;
 
import com.google.gson.JsonPrimitive;
 
import com.google.gson.JsonSerializationContext;
 
import com.google.gson.JsonSerializer;
 
  
 
/**
 
 * 日期解序列实用工具类
 
 * @author Lupeng
 
 * @date   2011-08-06
 
 */
 
public class DateSerializerUtils implements JsonSerializer<java.util.Date>{
 
    @Override
 
    public JsonElement serialize(Date date, Type type,
 
           JsonSerializationContext content) {
 
       return new JsonPrimitive(date.getTime());
 
    }
 
  
 
}