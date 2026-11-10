package ru.robot;

import ru.robot.state.CleaningState;
import ru.robot.state.RobotState;

import java.awt.*;
import java.util.List;

import static ru.robot.state.CleaningState.WATER;

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
        RobotState st = new RobotState(new Point(0, 0), 0, WATER);
        for (String inputCommand : inputCommands) {
            Command command = parser.parse(inputCommand);
            executeCommand(st, command);
        }
    }

    private static void executeCommand(RobotState robotState, Command command) {
        switch (command.type) {
            case MOVE: {
                double rad = Math.toRadians(robotState.getAngle());
                int dx = (int) Math.round(Math.cos(rad) * command.arg);
                int dy = (int) Math.round(Math.sin(rad) * command.arg);
                robotState.getPos().x += dx;
                robotState.getPos().y += dy;
                System.out.println("POS " + robotState.getPos().x + "," + robotState.getPos().y);
                break;
            }
            case TURN: {
                robotState.setAngle(normalizeAngle(robotState.getAngle() + command.arg));
                System.out.println("ANGLE " + robotState.getAngle());
                break;
            }
            case SET: {
                robotState.setCleaning(CleaningState.fromString(command.sArg));
                System.out.println("STATE " + robotState.getCleaning());
                break;
            }
            case START: {
                System.out.println("START WITH " + robotState.getCleaning());
                break;
            }
            case STOP: {
                System.out.println("STOP");
                break;
            }
        }
    }

    private static int normalizeAngle(int angle) {
        int normAngle = angle % 360;
        return normAngle < 0 ? normAngle + 360 : normAngle;
    }
}