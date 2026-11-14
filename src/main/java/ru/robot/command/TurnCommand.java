package ru.robot.command;

import ru.robot.state.Robot;

public final class TurnCommand implements Command {
    private final int deltaDeg;

    public TurnCommand(int deltaDeg) {
        this.deltaDeg = deltaDeg;
    }

    @Override
    public void execute(Robot robot) {
        robot.turn(deltaDeg);
    }
}
