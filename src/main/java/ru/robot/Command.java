package ru.robot;

import ru.robot.state.CleaningState;

public sealed interface Command permits Command.Move, Command.Turn, Command.Set, Command.Start, Command.Stop {
    record Move(int distance) implements Command {

    }

    record Turn(int angle) implements Command {

    }

    record Set(CleaningState cleaning) implements Command {

    }

    record Start() implements Command {

    }

    record Stop() implements Command {

    }
}
