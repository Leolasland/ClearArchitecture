package ru.robot.command;

import ru.robot.domain.Robot;

public final class StartCommand implements Command {
    @Override
    public String execute(Robot robot) {
        return robot.start();
    }
}
