package json;

import com.google.gson.*;
import exceptions.WrongDateFormatException;
import static utils.DateConverter.*;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class DateDeserializer implements JsonDeserializer<ZonedDateTime> {
    @Override
    public ZonedDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try{
            return parseDate(json.getAsJsonPrimitive().getAsString());
        }
        catch (WrongDateFormatException e){
            throw new JsonParseException("");
        }
    }
}
