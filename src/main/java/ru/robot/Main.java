package ru.robot;

import ru.robot.command.Command;
import ru.robot.state.Robot;

import java.util.List;

public class Main {

    private static final List<String> inputCommands = List.of(
            "move 100",
            "turn -90",
            "set soap",
            "start",
            "move 50",
            "stop");

    public static void main(String[] args) {
        Robot robot = new Robot(System.out);
        CommandParser parser = new CommandParser();

        for (String line : inputCommands) {
            if (line.isBlank()) {
                continue;
            }
            try {
                Command command = parser.parse(line);
                command.execute(robot);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в команде '" + line + "': " + e.getMessage());
            }
        }
    }
}