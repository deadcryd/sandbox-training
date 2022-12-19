package org.deadcryd.unit_05.task_03.handler;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputHandler {

    private static final String INPUT_FORMAT = "[%s]> ";
    private static final String INPUT_ERROR = "~ Ошибка ввода!";
    private final Scanner scanner = new Scanner(System.in);
    private CommandHandler commandHandler;
    private String name;

    @Getter
    @Setter
    private Boolean continueWork = true;

    public static InputHandler of(String name, Map<String, Runnable> commands) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.name = name;
        inputHandler.commandHandler = CommandHandler.of(commands);
        return inputHandler;
    }

    public void run() {
        do {
            System.out.printf(INPUT_FORMAT, name);
        } while (commandHandler());
    }

    public <T> void anotherInput(String message, Consumer<T> consumer, Function<String, T> mapper) {
        System.out.printf(INPUT_FORMAT, name + "|Ввод " + message);
        try {
            String input = scanner.nextLine();
            consumer.accept(mapper.apply(input));
        } catch (Exception ex) {
            System.out.println(INPUT_ERROR);
            ex.printStackTrace();
        }
    }

    private boolean commandHandler() {
        String command = scanner.nextLine();
        if (!commandHandler.run(command)) {
            System.out.println(INPUT_ERROR);
        }
        return continueWork;
    }
}
