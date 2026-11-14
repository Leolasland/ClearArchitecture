package ru.robot.command;

import ru.robot.state.Robot;

public final class StartCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.start();
    }
}
