package ru.robot;

import ru.robot.command.*;
import ru.robot.state.CleaningState;

import java.util.Map;

public final class CommandParser {

    @FunctionalInterface
    private interface Factory {
        Command create(String[] parts);
    }

    private static final Map<String, Factory> FACTORIES = Map.of(
            "move", parts -> {
                validateArgs(parts, 2);
                return new MoveCommand(Integer.parseInt(parts[1]));
            },
            "turn", parts -> {
                validateArgs(parts, 2);
                return new TurnCommand(Integer.parseInt(parts[1]));
            },
            "set", parts -> {
                validateArgs(parts, 2);
                return new SetCommand(CleaningState.fromString(parts[1]));
            },
            "start", parts -> {
                validateArgs(parts, 1);
                return new StartCommand();
            },
            "stop", parts -> {
                validateArgs(parts, 1);
                return new StopCommand();
            }
    );

    public Command parse(String line) {
        String[] parts = line.split("\\s+");
        Factory factory = FACTORIES.get(parts[0]);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown command: '" + parts[0] + "'");
        }
        return factory.create(parts);
    }

    private static void validateArgs(String[] args, int expectedLength) {
        if (args.length != expectedLength) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
    }
}
