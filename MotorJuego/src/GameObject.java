import java.util.ArrayList;

public class GameObject {

	private ArrayList<Component> Components = new ArrayList<Component>();
	

	public void addComponent(Component component) {
		Components.add(component);
		component.setGameObject(this);
	}

	public void RemoveComponent(Component component) {
		Components.remove(component);
		component.setGameObject(null);
	}

	public boolean hasComponent(Class<? extends Component> classe) {
		for (Component component : Components) {
			if (component.getClass() == classe) {
				return true;
			}
		}
		return false;
	}

//getComponent(RigidBody2D.class)
	public <T extends Component> T getComponent(Class<? extends Component> classe) {
		for (Component component : Components) {
			if (component.getClass() == classe) {
				return (T) component;
			}

		}
		return null;
	}

	public void update(double deltatime) {
		
		for (Component component : Components) {
			component.update(deltatime);
		}
	}

	public void render() {
		for (Component component : Components) {
			component.render();
		}
	}

}
