package thales.digital.factory;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class App {
	
	private static final String TITLE = "Game of Life";

    public static final int CELL_SIZE = 10, CELL_AMOUNT = 100;
    public static final int WIDTH = CELL_SIZE * CELL_AMOUNT, HEIGHT = WIDTH;

    public static final Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT);

    private static final boolean RUNNING = true;

    public static final Cell[][] CELLS = new Cell[CELL_AMOUNT][CELL_AMOUNT];

	public static void main(String[] args) {
		JFrame frame = new JFrame(TITLE);
        frame.setSize(DIMENSIONS);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        GameOfLifeWiew canvas = new GameOfLifeWiew();
        frame.add(canvas);
        canvas.createBufferStrategy(1);

        initializeCells();

        CELLS[10][10].setAlive(true);
        CELLS[10][11].setAlive(true);
        CELLS[10][12].setAlive(true);
        CELLS[11][10].setAlive(true);
        CELLS[12][10].setAlive(true);
        CELLS[12][11].setAlive(true);
        CELLS[12][12].setAlive(true);
        CELLS[11][12].setAlive(true);

        CELLS[13][10].setAlive(true);
        CELLS[13][11].setAlive(true);
        CELLS[13][12].setAlive(true);
        CELLS[10][13].setAlive(true);
        CELLS[11][13].setAlive(true);
        CELLS[12][13].setAlive(true);
        CELLS[13][13].setAlive(true);
        startGameLoop(canvas);
	}

	

	private static void startGameLoop(GameOfLifeWiew canvas) {
		Timer timer = new Timer();

        if (RUNNING) {
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    CellController.updateCells();
                    canvas.repaint();
                }

            }, 1000, 500);
        }
    
		
	}

	public static void initializeCells() {
		for (int x = 0; x < CELLS.length; x++) {
            for (int y = 0; y < CELLS[x].length; y++) {
                if (null == CELLS[x][y])
                    CELLS[x][y] = new Cell(x, y);
            }
        }
		
	}

}
