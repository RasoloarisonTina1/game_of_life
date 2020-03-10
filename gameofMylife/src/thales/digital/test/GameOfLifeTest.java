package thales.digital.test;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import thales.digital.factory.App;
import thales.digital.factory.Cell;
import thales.digital.factory.CellController;

class GameOfLifeTest {

	//any live cell with fewer than two live neighbors dies, as if by underpopulation
	@Test
	void underPopulationWithOneNeighborAliveTest() {
		App.initializeCells();
		Cell cell = new Cell(0, 0);
		cell.setAlive(true);
		List<Cell>neighbors = CellController.getNeighbors(cell);
		for(int i=0; i < neighbors.size(); i++) {
			boolean cellAlive = i == 0;
			neighbors.get(i).setAlive(cellAlive);
		}
		CellController.update(cell);
		Assert.assertFalse(cell.isAlive());
	}
	
	//any live cell with fewer than two live neighbors dies, as if by underpopulation
		@Test
		void underPopulationWithoutNeighborAliveTest() {
			App.initializeCells();
			Cell cell = new Cell(0, 0);
			cell.setAlive(true);
			List<Cell>neighbors = CellController.getNeighbors(cell);
			for(int i=0; i < neighbors.size(); i++) {
				neighbors.get(i).setAlive(false);
			}
			CellController.update(cell);
			Assert.assertFalse(cell.isAlive());
		}
	
	// any live cell with two or three live neighbors lives on the next generation
	@Test
	void nextGenerationWithTwoNeighborsAliveTest() {
		App.initializeCells();
		Cell cell = new Cell(1, 1);
		cell.setAlive(true);
		List<Cell> neighbors = CellController.getNeighbors(cell);
		for(int i= 0; i<neighbors.size(); i++) {
			boolean willBeAlive = i < 2;
			neighbors.get(i).setAlive(willBeAlive);
		}
		CellController.update(cell);
		Assert.assertTrue(cell.isAlive());	
}
	
	// any live cell with two or three live neighbors lives on the next generation
		@Test
		void nextGenerationWithThreeNeighborsAliveTest() {
			App.initializeCells();
			Cell cell = new Cell(1, 1);
			cell.setAlive(true);
			List<Cell> neighbors = CellController.getNeighbors(cell);
			for(int i= 0; i<neighbors.size(); i++) {
				boolean willBeAlive = i < 3;
				neighbors.get(i).setAlive(willBeAlive);
			}
			CellController.update(cell);
			Assert.assertTrue(cell.isAlive());	
	}

		// any live cell without (two or three)  live neighbors will die on the next generation
			@Test
			void nextGenerationWithoutTwoOrThreeNeighborsAliveTest() {
				App.initializeCells();
				Cell cell = new Cell(1, 1);
				cell.setAlive(true);
				List<Cell> neighbors = CellController.getNeighbors(cell);
				for(int i= 0; i<neighbors.size(); i++) {
					boolean willBeAlive = i < 5;
					neighbors.get(i).setAlive(willBeAlive);
				}
				CellController.update(cell);
				Assert.assertFalse(cell.isAlive());	
		}
		
	
			// any live cell with more than three live neighors dies , overpopulation
	@Test
	void overPopulationTest() throws Exception {
		App.initializeCells();
		Cell cell = new Cell(15, 15);
		cell.setAlive(true);
		List<Cell> neighbors = CellController.getNeighbors(cell);
		neighbors.forEach(neighbor -> neighbor.setAlive(true));
		CellController.update(cell);
		Assert.assertFalse(cell.isAlive());
	}
	
	@Test
	void reBirthTest() throws Exception {
		App.initializeCells();
		int cellX = 12;
		int cellY = 12;
		Cell cell = new Cell(cellX, cellY);
		cell.setAlive(false); // deal Cell
		List<Cell> neighbors = CellController.getNeighbors(cell);
		for(int i = 0; i< neighbors.size(); i++) {
			boolean willBeAlive = i<3; // Cell0 alive, Cell1 alive, Cell2 alive, others cells dead
			neighbors.get(i).setAlive(willBeAlive); 
		}
		CellController.update(cell);
		Assert.assertTrue(cell.isAlive());
		
		
	}

}
