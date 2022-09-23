package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// white
		if (getColor() == Color.WHITE) {
			// ahead
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				// first movement
				if (getMoveCount() == 0) {
					p.setValues(position.getRow() - 2, position.getColumn());
					Position p2 = new Position(position.getRow() - 2, position.getColumn());
					if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
						mat[p2.getRow()][p2.getColumn()] = true;
					}
				}
			}

			// diagonals
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

		}

		// black
		else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				// first movement
				if (getMoveCount() == 0) {
					p.setValues(position.getRow() + 2, position.getColumn());
					Position p2 = new Position(position.getRow() + 2, position.getColumn());
					if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
						mat[p2.getRow()][p2.getColumn()] = true;
					}
				}
			}

			// diagonals
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}

		return mat;
	}
}
