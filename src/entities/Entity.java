package entities;

public class Entity {
	
	private String name;
	private int id;
	private long x, y;
	private int width, height;
	
	public Entity(String name, int id, long x, long y, int width, int height) {
		this.name = name;
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public long getX() {
		return x;
	}

	public long getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
