package util;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import content.HumanBeing;
import io.Creator;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

import static java.lang.System.getenv;

public class FileWorker {
    public static void fillTheCollection(TreeSet<HumanBeing> collection) throws IOException {

        try (JsonReader reader = new JsonReader(new FileReader( getenv("path")))) {
            String[] components = new String[0];
            long i = 1;
            while (reader.hasNext()) {
                HumanBeing humanBeing = Creator.createByArray(components, i++);
                if (humanBeing == null || !collection.add(humanBeing)){
                    System.out.println("Ошибка добавления человеческого существа из строки " + i + ": Человеческое существо уже существует или неверно " +
                            "заданы поля.");
                }
                collection.add(humanBeing);
            }
        } catch (NullPointerException ex){
            System.out.println("Для запуска серверного приложения необходимо инициализировать переменную окружения path со входной коллекцией");
            System.exit(-1);
        }

    }

    public String writeInFile(TreeSet<HumanBeing> collection){

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(System.getenv("path")))) {
            for (HumanBeing humanBeing : collection){
                byte[] s = humanBeing.toString().getBytes(StandardCharsets.UTF_8);
                out.write(s);
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            return "текущая коллекция записана в файл.";
        } catch (IOException e){
            return "попытка записать коллекцию в файл не увенчалась успехом. Недостаточно прав.";
        }

    }

}
