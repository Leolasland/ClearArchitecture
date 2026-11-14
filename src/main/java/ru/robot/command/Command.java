package ru.robot.command;

import ru.robot.state.Robot;

public interface Command {
    void execute(Robot robot);
}
