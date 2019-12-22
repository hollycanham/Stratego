package com.thg.accelerator.hollycanham.strategoNewNew;

public class BoardCreator {
    public Board createBoard(String stateFromFile) {
        String[] splitString = stateFromFile.split(" ", 3);
        int row = Integer.parseInt(splitString[0]);
        int col = Integer.parseInt(splitString[1]);
        String pieceAtCoord = splitString[2].toUpperCase();
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.MINER);
        PieceFactory factory = new PieceFactory();

        Piece.Type type = Enum.valueOf(Piece.Type.class, pieceAtCoord);

        Piece p = factory.getPieceByType(type);

        board.addPieceAt(row, col, p);

        return board;


    }
}
