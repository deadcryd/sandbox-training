package org.deadcryd.unit_05.task_03.handler;

import java.util.Map;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandHandler {

    private final Map<String, Runnable> commands;

    public static CommandHandler of(Map<String, Runnable> commands) {
        return new CommandHandler(commands);
    }

    public boolean run(String commandName) {
        Optional<Runnable> command = Optional.ofNullable(commands.get(commandName));
        command.ifPresent(Runnable::run);
        return command.isPresent();
    }
}
