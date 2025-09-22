package chess.pieces;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueenMove {

    public static Collection<ChessMove> getMoves(ChessBoard board, ChessPosition position) {
        ChessPiece piece = board.getPiece(position);

        List<ChessMove> validMoves = new ArrayList<>();
        int[][] directions = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1},{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for  (int[] direction : directions) {
            int rowDirection = direction[0];
            int columnDirection = direction[1];

            //Next square
            int currentRow = position.getRow() + rowDirection;
            int currentColumn = position.getColumn() + columnDirection;

            while( currentRow >= 1 && currentColumn >= 1 && currentRow <= 8 && currentColumn <= 8) {
                ChessPiece pieceHere = board.getPiece(new ChessPosition(currentRow, currentColumn));
                if(pieceHere == null) {
                    validMoves.add(new ChessMove(position, new ChessPosition(currentRow, currentColumn), null));

                    currentRow += rowDirection;
                    currentColumn += columnDirection;
                }
                else {
                    if(piece.getTeamColor() == pieceHere.getTeamColor()) {
                        break;
                    }else {
                        //capture enemy
                        validMoves.add(new ChessMove(position, new ChessPosition(currentRow, currentColumn), null));
                        break;
                    }
                }
            }
        }
        return validMoves;
    }

}

