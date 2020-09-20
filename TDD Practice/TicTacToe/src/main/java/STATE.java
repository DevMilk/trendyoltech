public enum STATE {
    ALIVE((short) 0),
    O_WON((short) 1),
    X_WON((short) 2),
    TIE((short) 3);

    private final short value;

    STATE(final short newValue) {
        value = newValue;
    }

    public short getValue() {
        return value;
    }
}
