package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements Runnable {
	
	private boolean running = false;
	private long tickCount;
	
	private static final String GAME_NAME = "Time Scroller";
	private static final int GAME_WIDTH = 1280;
	private static final int GAME_HEIGHT = 720;
	private static final String GAME_VERSION = "0.0.1";
	
	private double maxFps = 60D;
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Main().start();
	}
	
	public Main() {
		super(GAME_NAME + " [" + GAME_VERSION + "]");
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		add(new Content());
		pack();
		setVisible(true);
	}

	private void init() {
		//init vars
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / maxFps;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		long now;
		boolean render;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			render = false;

			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
				render = true;
			}
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (render) {
				frames++;
				repaint();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println("FPS: " + frames + " TPS: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
		tickCount++;
	}
	
	class Content extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		public Dimension getPreferredSize() {
	        return new Dimension(GAME_WIDTH, GAME_HEIGHT);
	    }

		public void paintComponent(Graphics graphics) {
			Graphics2D g = (Graphics2D) graphics;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		}
		
	}
	
	
}
