package com.thg.accelerator.hollycanham.strategoNewNew;

public class PieceFactory {
    public Piece getPieceByType(Piece.Type type){
        switch (type){
            case SPY: return new Piece(Piece.Type.SPY);
            case BOMB: return new Piece(Piece.Type.BOMB);
            case FLAG: return new Piece(Piece.Type.FLAG);
            case MINER: return new Piece(Piece.Type.MINER);
            case MAJOR: return new Piece(Piece.Type.MAJOR);
            case SCOUT: return new Piece(Piece.Type.SCOUT);
            case MARSHAL: return new Piece(Piece.Type.MARSHAL);
            case GENERAL: return new Piece(Piece.Type.GENERAL);
            case COLONEL: return new Piece(Piece.Type.COLONEL);
            case CAPTAIN: return new Piece(Piece.Type.CAPTAIN);
            case SERGEANT: return new Piece(Piece.Type.SERGEANT);
            case LIEUTENANT: return new Piece(Piece.Type.LIEUTENANT);

        }
        return null;
    }

    public int getStrengthByType(Piece.Type type){
        switch (type) {
            case SPY : return 1;
            case FLAG: return -1;
            case BOMB: return 100;
            case SCOUT: return 2;
            case MAJOR: return 7;
            case MINER: return 3;
            case MARSHAL: return 10;
            case CAPTAIN: return 6;
            case COLONEL: return 8;
            case GENERAL: return 9;
            case SERGEANT: return 4;
            case LIEUTENANT: return 5;

        }
        return 0;

    }

}
