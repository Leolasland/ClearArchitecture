package ru.robot.state;

import java.awt.*;
import java.io.PrintStream;

public final class Robot {

    private Point position;
    private int angleDeg;
    private CleaningState cleaningState;
    private final PrintStream out;

    public Robot(PrintStream out) {
        this(new Point(0, 0), 0, CleaningState.WATER, out);
    }

    public Robot(Point position, int angleDeg, CleaningState cleaningState, PrintStream out) {
        this.position = position;
        this.angleDeg = angleDeg;
        this.cleaningState = cleaningState;
        this.out = out;
    }

    public void move(int distance) {
        double rad = Math.toRadians(angleDeg);
        int dx = (int) Math.round(Math.cos(rad) * distance);
        int dy = (int) Math.round(Math.sin(rad) * distance);
        position.move(dx, dy);
        out.println("POS " + position.x + "," + position.y);
    }

    public void turn(int deltaDeg) {
        angleDeg = normalizeAngle(angleDeg + deltaDeg);
        out.println("ANGLE " + angleDeg);
    }

    public void setCleaningState(CleaningState state) {
        this.cleaningState = state;
        out.println("STATE " + state.displayName());
    }

    public void start() {
        out.println("START WITH " + cleaningState.displayName());
    }

    public void stop() {
        out.println("STOP");
    }

    private static int normalizeAngle(int deg) {
        int a = deg % 360;
        return a < 0 ? a + 360 : a;
    }
}