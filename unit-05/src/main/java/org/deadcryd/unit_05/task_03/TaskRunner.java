package org.deadcryd.unit_05.task_03;

import java.io.IOException;
import org.deadcryd.unit_05.task_03.command.MainCommands;

public class TaskRunner {

    private static final String FILE_NAME = "result.file";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("~ Для вызова помощи используйте /help");
        MainCommands.start(FILE_NAME);
    }
}
