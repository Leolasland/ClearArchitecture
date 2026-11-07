package ru.robot;

import ru.robot.state.RobotState;

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
        CommandParser parser = new CommandParser();
        RobotExecutor executor = new RobotExecutor(System.out);
        RobotState state = RobotState.INITIAL;
        for (String inputCommand : inputCommands) {
            Command command = parser.parse(inputCommand);
            state = executor.execute(state, command);
        }
    }
}