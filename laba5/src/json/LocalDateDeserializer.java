package json;
import java.lang.reflect.Type;
import java.time.LocalDate;
import static utils.DateConverter.*;
import com.google.gson.*;

import exceptions.WrongDateFormatException;
/**
 * type adapter for json deserialization
 */
public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try{
            return parseLocalDate(json.getAsJsonPrimitive().getAsString());
        }
        catch (WrongDateFormatException e){
            throw new JsonParseException("");
        }
    }
}