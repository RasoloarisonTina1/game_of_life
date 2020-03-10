package thales.digital.factory;

public class Cell {
	private int cellX;
	private int cellY;
	private boolean alive = false;
	
	public Cell(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;
	}

	public int getCellX() {
		return cellX;
	}

	public int getCellY() {
		return cellY;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setCellX(int cellX) {
		this.cellX = cellX;
	}

	public void setCellY(int cellY) {
		this.cellY = cellY;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
