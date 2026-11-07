package ru.robot.state;

import java.awt.*;

public record RobotState(
       Point position,
       int angle,
       CleaningState cleaningState

) {
    public static final RobotState INITIAL = new RobotState(new Point(0, 0), 0, CleaningState.WATER);

    public RobotState moveBy(int dx, int dy) {
        return new RobotState(new Point(position.x + dx, position.y + dy), angle, cleaningState);
    }

    public RobotState withAngle(int newAngle) {
        return new RobotState(position, newAngle, cleaningState);
    }

    public RobotState withCleaningState(CleaningState newCleaningState) {
        return new RobotState(position, angle, newCleaningState);
    }
}
