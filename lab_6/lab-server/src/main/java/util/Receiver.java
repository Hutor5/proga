package util;

import content.HumanBeing;
import transmission.Response;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.TreeSet;

public class Receiver {
    private int ID = 1;
    private TreeSet<HumanBeing> collection = new TreeSet<>();
    private Response response = new Response();
    private final ZonedDateTime creationDate;
    public Receiver(){
        creationDate = ZonedDateTime.now();
    }

    public Response clear(){
        if (!collection.isEmpty()){
            collection.clear();
            response.setMessage("Коллекция успешно очищена.");
        } else {
            response.setMessage("Колллекция уже пуста.");
        }
        return response;
    }

    public Response add(HumanBeing humanBeing){
        humanBeing.setId(this.ID++);
        humanBeing.setCreationDate(ZonedDateTime.now());
        if (!collection.add(humanBeing)) {
            response.setMessage("Не удалось добавить человеческое существо. Коллекция TreeSet не предполагает хранение одинаковых объектов.");
        } else {
            response.setMessage("Человеческое существо успешно добавлен в коллецию.");
        }
        return response;
    }

    public Response addIfMin(HumanBeing humanBeing){
        if (collection.isEmpty()){
            response.setMessage("Коллекция пуста. Создайте хотя бы один элемент, чтобы использовать эту команду.");
        }
        if (humanBeing.getImpactSpeed() < collection.first().getImpactSpeed()){
            collection.add(humanBeing);
            response.setMessage("Человеческое существо успешно добавлен в коллекцию.");
        } else {
            response.setMessage("Не удалось добавить человеческое существо. Его значение поля impactSpeed превосходит наименьшее.");
        }
        return response;
    }

    public Response show(){
        if (collection.isEmpty()) {
            response.setMessage("Коллекция пуста.");
            return response;
        }
        response.setMessage("Элементы коллекции в строковом представлении:");
        response.setAnswer(
                collection.stream()
                        .map(HumanBeing::toShow)
                        .toArray(String[]::new)
        );
        return response;
    }

    public Response removeById(String argument){
        int id = Integer.parseInt(argument);
        boolean flag = false;
        for (HumanBeing humanBeing : collection){
            if (humanBeing.getId().equals(id)){
                flag = true;
                collection.remove(humanBeing);
                break;
            }
        }
        if (!flag){
            response.setMessage("Человеческого существа с заданным id не существует.");
            return response;
        }
        response.setMessage("Человеческое существо с заданным id успешно удалено.");
        return response;
    }

    public Response removeLower(HumanBeing humanBeing){
        if (collection.isEmpty()){
            response.setMessage("Коллекция пуста.");
            return response;
        }
        collection.removeIf(humanBeing1 -> humanBeing1.getImpactSpeed() < humanBeing.getImpactSpeed());
        response.setMessage("Элементы коллекции, меньшие чем заданный, удалены.");
        return response;
    }


    public Response info(){
        response.setMessage("Тип коллекции: " + collection.getClass() +
                "\nДата инициализации коллекции: " + creationDate +
                "\nКоличество элементов коллекции: " + collection.size());
        return response;
    }

    public Response filterContainsName(String filter){
        if (collection.isEmpty()){
            response.setMessage("Коллекция пуста. Команда не может выполниться.");
            return response;
        }
        String[] reaction = collection.stream()
                .filter(humanBeing -> humanBeing.getName().contains(filter))
                .map(HumanBeing::toString)
                .toArray(String[]::new);
        response.setMessage("Элементы коллекции, содержащие подстроку: " + filter);
        response.setAnswer(reaction);
        return response;
    }

    public Response filterBySoundtrackName(String filter){
        if (collection.isEmpty()){
            response.setMessage("Коллекция пуста. Команда не может выполниться.");
            return response;
        }
        String[] reaction = collection.stream()
                .filter(humanBeing -> humanBeing.getSoundtrackName().equals(filter))
                .map(HumanBeing::toString)
                .toArray(String[]::new);
        response.setMessage("Элементы коллекции, с заданным soundtrackName: " + filter);
        response.setAnswer(reaction);
        return response;
    }

    public Response printFieldDescendingWeaponType(){
        if (collection.isEmpty()){
            response.setMessage("Коллекция пуста. Команда не может выполниться");
            return response;
        }
        response.setMessage("Отсортированная по weaponType в обратном порядке коллекция");
        response.setAnswer((collection.stream().sorted((humanBeing1, humanBeing2) -> -humanBeing1.getWeaponType().compareTo(humanBeing2.getWeaponType())).map(HumanBeing::toString).toArray(String[]::new)));
        return response;
    }

    public Response updateId(String idArgument, HumanBeing humanBeing){
        int id = Integer.parseInt(idArgument);
        HumanBeing maybeDel = null;
        int before = collection.size();
        for (HumanBeing humanBeing1 : collection){
            if (humanBeing1.getId().equals(id)){
                collection.remove(humanBeing1);
                maybeDel = humanBeing1;
                break;
            }
        }
        int after = collection.size();
        if (before == after) {
            response.setMessage("Элемента с заданным id не существует. Человеческое существо не будет обновлено.");
            return response;
        }
        humanBeing.setId(id);
        humanBeing.setCreationDate(ZonedDateTime.now());
        if (!collection.add(humanBeing)) {
            response.setMessage("Не удалось изменить человеческое существо. Коллекция TreeSet не предполагает хранение одинаковых объектов.");
            collection.add(maybeDel);
        } else {
            response.setMessage("Человеческое существо с id = " + id + " успешно изменено.");
        }
        return response;
    }

    public Response save(){
        FileWorker worker = new FileWorker();
        worker.writeInFile(collection);
        return response;
    }

    public void clearResponse(){
        this.response.setMessage(null);
        this.response.setAnswer(null);
    }
    public TreeSet<HumanBeing> getCollection(){
        return this.collection;
    }


}
