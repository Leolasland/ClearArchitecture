package ru.robot.command;

import ru.robot.state.Robot;

public final class StopCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.stop();
    }
}
