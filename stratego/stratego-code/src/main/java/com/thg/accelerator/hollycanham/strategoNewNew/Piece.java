package com.thg.accelerator.hollycanham.strategoNewNew;

public class Piece {


    private boolean killed = false;
    private boolean revealed = false;

    private final Type type;

    ;public static enum Type{
        MINER,
        BOMB,
        SCOUT,
        SPY,
        MARSHAL,
        GENERAL,
        COLONEL,
        MAJOR,
        CAPTAIN,
        LIEUTENANT,
        SERGEANT,
        FLAG,
        ;

    }


    ;

    public Piece(Type type) {
        this.type = type;
        this.strength = strength;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isKilled() {
        return killed = true;
    }

    public boolean isRevealed() {
        return revealed = true;
    }

    private int strength;
    public int getStrength(){
        PieceFactory factory = new PieceFactory();

        this.strength = factory.getStrengthByType(type);
        return strength;




    }
}

