public enum POSITION {

    BOTTOM((short) 0),
    MIDDlE((short) 1),
    TOP((short) 2),
    LEFT((short) 0),
    RIGHT((short) 2);

    private short value;

    POSITION(final short newValue) {
        value = newValue;
    }

    public short getValue() {
        return value;
    }
}
