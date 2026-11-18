package ru.robot.command;

import ru.robot.domain.Robot;

public final class TurnCommand implements Command {
    private final int deltaDeg;

    public TurnCommand(int deltaDeg) {
        this.deltaDeg = deltaDeg;
    }

    @Override
    public String execute(Robot robot) {
        return robot.turn(deltaDeg);
    }
}
