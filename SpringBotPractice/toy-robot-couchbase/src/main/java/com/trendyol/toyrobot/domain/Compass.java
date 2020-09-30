package com.trendyol.toyrobot.domain;

public enum Compass {
    NORTH(0,1),
    WEST(-1,0),
    SOUTH(0,-1),
    EAST(1,0);

    private final int directionAbscissa;
    private final int directionOrdinate;
    Compass(int i, int j) {
        this.directionAbscissa = i;
        this.directionOrdinate = j;
    }

    public int getDirectionAbscissa() {
        return directionAbscissa;
    }

    public int getDirectionOrdinate() {
        return directionOrdinate;
    }
    private static Compass[] vals = values();
    public Compass next(int direction){
        return vals[(this.ordinal()+direction) % vals.length];
    }
}
