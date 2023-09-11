package commands;

import transmission.Request;
import transmission.Response;

public class Exit implements Command{
    @Override
    public Response execute(Request request) {
        System.out.println("Спасибо за работу, до свидания.");
        System.exit(0);
        return null;
    }

    @Override
    public String getHelp() {
        return "Введите exit, чтобы завершить программу (без сохранения в файл).";
    }
}