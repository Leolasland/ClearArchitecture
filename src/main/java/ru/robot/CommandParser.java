package ru.robot;

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
                yield new Command(CommandType.MOVE, Integer.parseInt(parts[1]));
            }
            case "turn" -> {
                validateArgs(parts, 2);
                yield new Command(CommandType.TURN, Integer.parseInt(parts[1]));
            }
            case "set" -> {
                validateArgs(parts, 2);
                yield new Command(CommandType.SET, parts[1]);
            }
            case "start" -> {
                validateArgs(parts, 1);
                yield new Command(CommandType.START, 0);
            }
            case "stop" -> {
                validateArgs(parts, 1);
                yield new Command(CommandType.STOP, 0);
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
