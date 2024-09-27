
import java.util.ArrayList;


public class Gameloop {
	
	ArrayList<GameObject> m_GameObjects = new ArrayList<GameObject>();

	private static Gameloop m_singleton = null;
	static EventListener e = EventListener.getInstance();
	private Gameloop() {

	}

	public static Gameloop getInstance() throws InterruptedException {
		if (m_singleton == null)
			m_singleton = new Gameloop();

		return m_singleton;
	}

	public void Render() {
		//render de los GO
		for (GameObject gameObject : m_GameObjects) {
			gameObject.render();
		}
	}

	public void Update(double deltaTime) {
		//update de los GO
		for (GameObject gameObject : m_GameObjects) {
			gameObject.update(deltaTime);
		}
	}

	public void Input() {
		// TODO Auto-generated method stub

	}
	
	public void init()
	{
		
		
	}

	public void addGameObject(GameObject gameObject) {
		m_GameObjects.add(gameObject);
	}

	public void removeGameObject(GameObject gameObject) {
		for (GameObject Gameobject : m_GameObjects) {
			if (Gameobject == gameObject) {
				m_GameObjects.remove(Gameobject);
				System.out.println("A");
			}
		}

	}

}
