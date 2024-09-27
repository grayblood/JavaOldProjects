import java.util.ArrayList;

public class GameCore {
	private float AccTime;
	private int lastsec;
	ArrayList<GameObject> Go;

	public void Init() {
		AccTime = 0;
		lastsec = -1;

	}

	public void Input() {

	}

	public void Update(float deltaTime) {
		AccTime += deltaTime;
		/*
		for (GameObject GO : Go) {
			GO.update(deltatime);
		}*/
	}

	public void Render() {
		for (GameObject GO : Go) {

		}

	}

}
