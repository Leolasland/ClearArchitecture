package ru.robot.state;

import java.awt.*;

public class RobotState {
    Point pos;
    int angle;
    CleaningState cleaning;

    public RobotState(Point pos, int angle, CleaningState cleaning) {
        this.pos = pos;
        this.angle = angle;
        this.cleaning = cleaning;
    }
    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public CleaningState getCleaning() {
        return cleaning;
    }

    public void setCleaning(CleaningState cleaning) {
        this.cleaning = cleaning;
    }
}
