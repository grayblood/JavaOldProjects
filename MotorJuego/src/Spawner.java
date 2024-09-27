public class Spawner extends Component {
	int timer = 0;
	int segundos = 0;
	private int timeToWait = 7;
	private int countdown = timeToWait;

	public Spawner() {

	}

	public void update(double deltatime) {

		timer += (int) deltatime;
		if (timer / 1000 == segundos) {
			// System.out.println(segundos);
			System.out.println(deltatime);
			segundos++;
			countdown--;
			System.out.println(countdown);
		}

		if (countdown <= 0) {
			System.out.println("hola");
			super.addComponent(new Timeout());

			countdown = timeToWait;
		}

	}

	public void render() {

	}

}
