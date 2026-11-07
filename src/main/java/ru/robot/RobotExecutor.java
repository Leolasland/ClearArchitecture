package ru.robot;

import ru.robot.state.CleaningState;
import ru.robot.state.RobotState;

import java.io.PrintStream;

public final class RobotExecutor {

    /**
     * -- либо текущую позицию: POS x,y (команда move),
     * -- либо текущий угол поворота в градусах: ANGLE a (команда turn),
     * -- либо текущее состояние устройства очистки (одно из трёх): STATE water/soap/brush (команда set),
     * -- либо начало работы с текущим состоянием устройства очистки: START WITH water/soap/brush (команда start),
     * -- либо прекращение работы: STOP (команда stop).
     */
    private final PrintStream out;
    public static final String POSITION = "POS %s, %s";
    public static final String ANGLE = "ANGLE %s";
    public static final String STATE = "STATE %s";
    public static final String START = "START WITH %s";
    public static final String STOP = "STOP";

    public RobotExecutor(PrintStream out) {
        this.out = out;
    }

    public RobotState execute(RobotState robotState, Command command) {
        return switch (command) {
            case Command.Move(int distance) -> {
                double rad = Math.toRadians(robotState.angle());
                int dx = (int) Math.round(Math.cos(rad) * distance);
                int dy = (int) Math.round(Math.sin(rad) * distance);
                RobotState next = robotState.moveBy(dx, dy);
                out.printf((POSITION) + "%n", next.position().x, next.position().y);
                yield next;
            }
            case Command.Turn(int angle) -> {
                RobotState next = robotState.withAngle(normalizeAngle(angle));
                out.printf((ANGLE) + "%n", next.angle());
                yield next;
            }
            case Command.Set(CleaningState cleaningState) -> {
                RobotState next = robotState.withCleaningState(cleaningState);
                out.printf((STATE) + "%n", next.cleaningState());
                yield next;
            }
            case Command.Start() -> {
                out.printf((START) + "%n", robotState.cleaningState());
                yield robotState;
            }
            case Command.Stop() -> {
                out.println(STOP);
                yield robotState;
            }
        };
    }

    private static int normalizeAngle(int angle) {
        int normAngle = angle % 360;
        return normAngle < 0 ? normAngle + 360 : normAngle;
    }
}
