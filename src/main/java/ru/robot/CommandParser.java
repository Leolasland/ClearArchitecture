package ru.robot;

import ru.robot.state.CleaningState;

public final class CommandParser {

    public Command parse(String line) {
        line = line.trim();
        if (line.isBlank()) {
            throw new IllegalArgumentException("Empty command");
        }
        String[] parts = line.split(" ");
        String command = parts[0];
        return switch (command) {
            case "move" -> {
                validateArgs(parts, 2);
                yield new Command.Move(Integer.parseInt(parts[1]));
            }
            case "turn" -> {
                validateArgs(parts, 2);
                yield new Command.Turn(Integer.parseInt(parts[1]));
            }
            case "set" -> {
                validateArgs(parts, 2);
                yield new Command.Set(CleaningState.fromString(parts[1]));
            }
            case "start" -> {
                validateArgs(parts, 1);
                yield new Command.Start();
            }
            case "stop" -> {
                validateArgs(parts, 1);
                yield new Command.Stop();
            }
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

    private void validateArgs(String[] args, int expectedLength) {
        if (args.length != expectedLength) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
    }
}
