package com.thg.accelerator.hollycanham.strategoNewNew;

import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {

    @Test
    public void givenNewBoardTestWhenIAddNewPiece() {
        Board board = new Board();

        PieceFactory factory = new PieceFactory();
        Piece newPiece = factory.getPieceByType(Piece.Type.BOMB);


        board.addPieceAt(7, 7, newPiece);
        Piece piece = board.getPieceAt(7,7);


        assertEquals(piece.getType(), Piece.Type.BOMB);
    }

    @Test
    public void loadBoardFromFile(){

        String stateFromFile = "4 4 Miner";

        BoardCreator boardCreator = new BoardCreator();
        Board board = boardCreator.createBoard(stateFromFile);

        Piece piece = board.getPieceAt(4,4);

        assertEquals(piece.getType(), Piece.Type.MINER);
    }

    @Test
    public void givenABoardWhenMakeMoveTestMoveMade(){

        PieceFactory factory = new PieceFactory();
        Piece newPiece = factory.getPieceByType(Piece.Type.SCOUT);

        Board board = new Board();

        board.addPieceAt(1,1, newPiece);
        board.makeMove(1,1,2,2);

        assertEquals(board.getPieceAt(2, 2), newPiece);
        assertNull(board.getPieceAt(1, 1));
    }

    @Test
    public void givenTwoPieceWhenAttackedKilled(){
        Board board = new Board();

        PieceFactory factory = new PieceFactory();
        Piece attacker = factory.getPieceByType(Piece.Type.MINER);
        Piece victim = factory.getPieceByType(Piece.Type.SPY);

        board.addPieceAt(5, 5, attacker);
        board.addPieceAt(5,6, victim);

        board.makeMove(5,5,5,6);

        Piece newLocationOccupant = board.getPieceAt(5,6);
        assertTrue(newLocationOccupant.equals(attacker));
        assertEquals(board.getPieceAt(5, 6), attacker);



    }

    @Test
    public void givenPieceGetStrength(){
        Piece piece = new Piece(Piece.Type.MARSHAL);

        piece.getStrength();

        assertEquals(piece.getStrength(), 10);

       // PieceFactory factory = new PieceFactory();
        //assertEquals(factory.getStrengthByType(Piece.Type.MARSHAL),10);


    }

    @Test
    public void givenStrengthWhenMetIsKilled(){
        Board board = new Board();

        Piece attacker = new Piece(Piece.Type.SPY);
        Piece victim = new Piece(Piece.Type.MARSHAL);

        board.addPieceAt(3,3,attacker);
        board.addPieceAt(4,4,victim);

        board.makeMove(3,3,4,4);

        assertTrue(victim.isKilled());

    }

    @Test
    public void givenWinAttackIsRevealed(){
        Board board = new Board();

        Piece attacker = new Piece(Piece.Type.SPY);
        Piece victim = new Piece(Piece.Type.MARSHAL);

        board.addPieceAt(3,3,attacker);
        board.addPieceAt(4,4,victim);

        board.makeMove(3,3,4,4);

        assertTrue(victim.isRevealed());
        assertTrue(attacker.isRevealed());

    }

    @Test
    public void givenDrawBothKilledWhenMet(){
        Board board = new Board();

        Piece attacker = new Piece(Piece.Type.GENERAL);
        Piece victim = new Piece(Piece.Type.GENERAL);

        board.addPieceAt(3,3,attacker);
        board.addPieceAt(4,4,victim);

        board.makeMove(3,3,4,4);

        assertTrue(victim.isKilled());
        assertTrue(attacker.isKilled());

    }

    @Test
    public void givenMoveTestNotDiagonal(){
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.GENERAL);

        board.addPieceAt(1,1, piece);
        board.makeMove(1,1,2,2);

        assertNull(board.getPieceAt(2, 2));

    }

    @Test
    public void givenMoveTestNotBackwards(){
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.GENERAL);

        board.addPieceAt(2,2, piece);
        board.makeMove(2,2,1,2);

        assertNull(board.getPieceAt(1, 2));

    }

    @Test
    public void givenScoutTestScoutMoves(){
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.SCOUT);

        board.addPieceAt(2,2, piece);
        board.makeMove(2,2,2,4);

        assertEquals(board.getPieceAt(2, 4), piece);
    }

    @Test
    public void givenScoutTestValidScoutMoves(){
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.SCOUT);

        board.addPieceAt(2,2, piece);
        board.makeMove(2,2,4,4);

        assertNull(board.getPieceAt(4, 4));

    }

    @Test
    public void givenFlagOrBombTestCantMove(){
        Board board = new Board();
        Piece piece = new Piece(Piece.Type.FLAG);

        board.addPieceAt(2,2, piece);
        board.makeMove(2,2,2,3);

        assertNull(board.getPieceAt(2, 3));

    }

    @Test
    public void givenMinerAttackBombTestDiffuses(){
        Board board = new Board();
        Piece bomb = new Piece(Piece.Type.BOMB);
        Piece miner = new Piece(Piece.Type.MINER);

        board.addPieceAt(3,2, bomb);
        board.addPieceAt(2,2, miner);
        board.makeMove(2,2,3,2);

        assertTrue(board.getPieceAt(3,2).equals(miner));

    }







}