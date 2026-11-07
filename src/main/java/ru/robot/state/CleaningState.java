package ru.robot.state;

/**
 * Одно из трёх устройств очистки: полив водой, полив мыльной пеной, чистка метлой.
 */
public enum CleaningState {
    WATER("water"),
    /**
     * Мыльная пена.
     */
    SOAP("soap"),
    /**
     * Метла.
     */
    BRUSH("brush");

    private final String displayName;

    CleaningState(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    public static CleaningState fromString(String s) {
        for (CleaningState state : values()) {
            if (state.displayName.equals(s)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown cleaning cleaningState: " + s);
    }
}
