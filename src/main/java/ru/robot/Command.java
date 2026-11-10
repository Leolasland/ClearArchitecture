package ru.robot;

public class Command {
    CommandType type;
    int arg;
    String sArg;

    Command(CommandType type, int arg) {
        this.type = type;
        this.arg = arg;
    }

    Command(CommandType type, String sArg) {
        this.type = type;
        this.sArg = sArg;
    }
}
