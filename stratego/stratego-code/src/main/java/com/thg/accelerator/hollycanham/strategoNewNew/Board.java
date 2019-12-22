package com.thg.accelerator.hollycanham.strategoNewNew;

public class Board {

    public Piece[][] tile;

    public Board() {
        tile = new Piece[10][10];
    }

    public Piece getPieceAt(int row, int col) {

        return tile[row][col];
    }

    public void addPieceAt(int row, int col, Piece p) {
        tile[row][col] = p;
    }

    public void makeMove(int fromrow, int fromcol, int torow, int tocol) {
        Piece attacker = getPieceAt(fromrow, fromcol);
        Piece victim = getPieceAt(torow, tocol);
        removePieceAt(fromrow, fromcol);
        addPieceAt(torow, tocol, attacker);


    }

    private void removePieceAt(int row, int col) { tile[row][col] = null;}



}


