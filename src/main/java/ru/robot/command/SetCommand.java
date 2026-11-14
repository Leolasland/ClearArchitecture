package ru.robot.command;

import ru.robot.state.CleaningState;
import ru.robot.state.Robot;

public final class SetCommand implements Command {
    private final CleaningState state;

    public SetCommand(CleaningState state) {
        this.state = state;
    }

    @Override
    public void execute(Robot robot) {
        robot.setCleaningState(state);
    }
}
