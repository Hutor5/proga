package json;

import collection.HumanBeingCollectionManager;
import com.google.gson.*;
import data.HumanBeing;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionDeserializer implements JsonDeserializer<TreeSet<HumanBeing>> {
    private HashSet<Integer> uniqueIds;

    public CollectionDeserializer(HashSet<Integer> uniqueIds){
        this.uniqueIds = uniqueIds;
    }

    @Override
    public TreeSet<HumanBeing> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        TreeSet<HumanBeing> collection = new TreeSet<>();
        JsonArray humanBeings = jsonElement.getAsJsonArray();
        int errors = 0;
        for (JsonElement jsonHumanBeing: humanBeings){
            HumanBeing humanBeing = null;
            try{
                if(jsonHumanBeing.getAsJsonObject().entrySet().isEmpty()){
                    System.err.println("Обнаружен пустой элемент коллекции");
                    throw new JsonParseException("Пустой humanBeing");
                }
                if(!jsonHumanBeing.getAsJsonObject().has("id")) {
                    System.err.println("Обнаружен элемент без id");
                    throw new JsonParseException("id не найден");
                }
                humanBeing = (HumanBeing) jsonDeserializationContext.deserialize(jsonHumanBeing, HumanBeing.class);

                Integer id = humanBeing.getId();

                if(uniqueIds.contains(id)) {
                    System.err.println("Коллекция уже содержит элемент с id №" + Integer.toString(id));
                    throw new JsonParseException("id не уникален");
                }
                if(!humanBeing.validate()) {
                    System.err.println("HumanBeing #"+Integer.toString(id) + " не удавлетворяет специальным условиям");
                    throw new JsonParseException("Неправильные данные в HumanBeing");
                }
                uniqueIds.add(id);
                collection.add(humanBeing);
            } catch (JsonParseException e){
                errors += 1;
            }
        }
        if(collection.size()==0){
            if(errors == 0) System.err.println("Коллекция пустая");
            else System.err.println("Все элементы в коллекции повреждены");
            throw new JsonParseException("Нет данных");
        }
        if (errors != 0) System.err.println(Integer.toString(errors) + " элементов повреждено");
        return collection;
    }

}
