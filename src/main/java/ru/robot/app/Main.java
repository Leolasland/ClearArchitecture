package ru.robot.app;

import ru.robot.command.Command;
import ru.robot.domain.Robot;
import ru.robot.parser.CommandParser;

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
        Robot robot = new Robot();
        CommandParser parser = new CommandParser();

        for (String line : inputCommands) {
            if (line.isBlank()) {
                continue;
            }
            try {
                Command command = parser.parse(line);
                String execute = command.execute(robot);
                System.out.println(execute);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в команде '" + line + "': " + e.getMessage());
            }
        }
    }
}