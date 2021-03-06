package json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.Date;

import static utils.DateConverter.dateToString;

public class DateSerializer implements JsonSerializer<ZonedDateTime> {
    public JsonElement serialize(ZonedDateTime date, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(dateToString(date));
    }
}
