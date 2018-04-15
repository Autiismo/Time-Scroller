package entities;

import java.util.List;
import java.util.ArrayList;

public class EntityManager {
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public EntityManager(int levelId) {
		populateEntities(levelId);
	}
	
	public void populateEntities(int levelId) {
		
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public List<Entity> addEntity(Entity entity) {
		if(!entities.contains(entity)) entities.add(entity);
		return entities;
	}
	
	public List<Entity> removeEntity(Entity entity) {
		if(entities.contains(entity)) entities.remove(entity);
		return entities;
	}
	
}
