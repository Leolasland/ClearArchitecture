package ru.robot.command;

import ru.robot.domain.CleaningState;
import ru.robot.domain.Robot;

public final class SetCommand implements Command {
    private final CleaningState state;

    public SetCommand(CleaningState state) {
        this.state = state;
    }

    @Override
    public String execute(Robot robot) {
        return robot.setCleaningState(state);
    }
}
