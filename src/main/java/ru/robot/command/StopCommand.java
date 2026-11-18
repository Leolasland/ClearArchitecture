package ru.robot.command;

import ru.robot.domain.Robot;

public final class StopCommand implements Command {
    @Override
    public String execute(Robot robot) {
        return robot.stop();
    }
}
