package ru.robot.command;

import ru.robot.domain.Robot;

public interface Command {
    String execute(Robot robot);
}
