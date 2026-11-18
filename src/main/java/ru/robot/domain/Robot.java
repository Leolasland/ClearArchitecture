package ru.robot.domain;

import java.awt.*;

public final class Robot {

    private Point position;
    private int angleDeg;
    private CleaningState cleaningState;

    public Robot() {
        this(new Point(0, 0), 0, CleaningState.WATER);
    }

    public Robot(Point position, int angleDeg, CleaningState cleaningState) {
        this.position = position;
        this.angleDeg = angleDeg;
        this.cleaningState = cleaningState;
    }

    public String move(int distance) {
        double rad = Math.toRadians(angleDeg);
        int dx = (int) Math.round(Math.cos(rad) * distance);
        int dy = (int) Math.round(Math.sin(rad) * distance);
        position.move(dx, dy);
        return "POS " + position.x + "," + position.y;
    }

    public String turn(int deltaDeg) {
        angleDeg = normalizeAngle(angleDeg + deltaDeg);
        return "ANGLE " + angleDeg;
    }

    public String setCleaningState(CleaningState state) {
        this.cleaningState = state;
        return "STATE " + state.displayName();
    }

    public String start() {
        return "START WITH " + cleaningState.displayName();
    }

    public String stop() {
        return "STOP";
    }

    private static int normalizeAngle(int deg) {
        int a = deg % 360;
        return a < 0 ? a + 360 : a;
    }
}