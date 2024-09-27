
public class GameObjectFactory {

	private static GameObjectFactory m_singleton = null;

	private GameObjectFactory() {

	}

	public static GameObjectFactory getInstance() throws InterruptedException {
		if (m_singleton == null)
			m_singleton = new GameObjectFactory();

		return m_singleton;
	}

}
