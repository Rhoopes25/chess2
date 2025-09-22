package chess.pieces;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMove {

    public static Collection<ChessMove> getMoves(ChessBoard board, ChessPosition position) {
        ChessPiece piece = board.getPiece(position);

        List<ChessMove> validMoves = new ArrayList<>();
        if(piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            int forwardDirection = 1;
            int newRow = position.getRow() + forwardDirection;
            int newCol = position.getColumn();

            if (newRow >=1 && newRow <=8){
                ChessPiece pieceHere = board.getPiece(new ChessPosition(newRow,newCol));
                if (pieceHere != null) {
                    validMoves.add(new ChessMove(position, new ChessPosition(newRow, newCol), null));
                }
            }
        }else {

            int forwardDirection = -1;
            int newRow = position.getRow() + forwardDirection;
            int newCol = position.getColumn();

            if (newRow >=1 && newRow <=8){
                ChessPiece pieceHere = board.getPiece(new ChessPosition(newRow,newCol));
                if (pieceHere != null) {
                    validMoves.add(new ChessMove(position, new ChessPosition(newRow, newCol), null));
                }
            }


        }


        return validMoves;
    }

}