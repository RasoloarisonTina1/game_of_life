package thales.digital.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellController {
	
	 public static List<Cell>getNeighbors(final Cell cell){
		final List<Cell> neighbors = new ArrayList<>();
		int startX = cell.getCellX() - 1;
        int startY = cell.getCellY() - 1;
        try {

        int maxX = Math.min(startX + 2, App.CELL_AMOUNT-1);
        int maxY = Math.min(startY + 2, App.CELL_AMOUNT-1);
       
        for (int x = Math.max(startX, 1); x <= maxX; x++) {
            for (int y = Math.max(startY, 0); y <= maxY; y++) {
            	final Cell c = App.CELLS[x][y];
            	if(!(c.getCellX()== cell.getCellX() && c.getCellY()==cell.getCellY()))
            		neighbors.add(c); 
            		
            }
        }
        }catch(final Exception e) {
        	System.out.println(e.getMessage());
        }
        
		return neighbors;
		
	}

	public static int getNeighborsAliveCount(final Cell cell)throws Exception {
		int count = 0;
		List<Cell>cells = getNeighbors(cell); 
		for (final Cell neighbor : cells) {
			if(neighbor.isAlive()) {
				count = count +1;
			}
		}
        return count;
    }
	public static void update(final Cell cell) {
		Arrays.asList(App.CELLS).forEach(cells ->{
        	Arrays.asList(cells).forEach(c -> {	
        		if(equals(c, cell)) {
        			try {
						updateCell(cell);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
        		}        	
        	});
        	});
	}
        	

	private static void updateCell(Cell cell) throws Exception {
		int neighborsCount = CellController.getNeighborsAliveCount(cell);
		if (cell.isAlive() && (neighborsCount < 2 || neighborsCount > 3)) {
				cell.setAlive(false);
				}

		if (!cell.isAlive() && neighborsCount == 3) {
			cell.setAlive(true);
			}		
	}

	private static boolean equals(final Cell cellOne, final Cell cellTwo) {
		return cellOne.getCellX()==cellTwo.getCellX() && cellOne.getCellY()==cellTwo.getCellY();
	}
	
	
    public static void updateCells() {
        final List<Cell> deadCells = new ArrayList<>();
        final List<Cell> aliveCells = new ArrayList<>();
        
        Arrays.asList(App.CELLS).forEach(cells ->{
        	Arrays.asList(cells).forEach(cell -> {
        			int neighborsCount;
					try {
						neighborsCount = CellController.getNeighborsAliveCount(cell);
					
        			if (cell.isAlive() && (neighborsCount < 2 || neighborsCount > 3)) {
        				deadCells.add(cell);
        				}

        			if (!cell.isAlive() && neighborsCount == 3) {
        				aliveCells.add(cell);
        				}
        			} catch (Exception e) {
    						System.out.println(e.getMessage());
    					}
        	});
});
        deadCells.forEach(deadCell->{deadCell.setAlive(false);});
        aliveCells.forEach(aliveCell -> {aliveCell.setAlive(true);});
       
    }


}
