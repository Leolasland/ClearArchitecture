package ru.robot.command;

import ru.robot.domain.Robot;

public final class MoveCommand implements Command {
    private final int distance;

    public MoveCommand(int distance) {
        this.distance = distance;
    }

    @Override
    public String execute(Robot robot) {
        return robot.move(distance);
    }
}
