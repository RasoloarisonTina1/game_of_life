package thales.digital.factory;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

public class GameOfLifeWiew extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 646539868546614103L;

	public GameOfLifeWiew() {
        super();
        this.setSize(App.WIDTH, App.HEIGHT);
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        this.setVisible(true);
    }

    public void paint(final Graphics g) {
        Graphics graphics = this.getGraphics();
        graphics.clearRect(0, 0, App.WIDTH, App.HEIGHT);
        Arrays.asList(App.CELLS).forEach(Cells->{
        		Arrays.asList(Cells).forEach(cell ->{
        			drawCell(g, cell);
        		});
        });

    }
    
    private void drawCell(final Graphics g, final Cell cell) {
        if (cell.isAlive()) {
        	int size = App.CELL_SIZE;
        	int x = cell.getCellX() * size *2;
            int y = cell.getCellY() * size*2;
            g.setColor(Color.BLUE);
            g.fillRect(x, y, size/2, size/2);
        }
    	
    }

}
