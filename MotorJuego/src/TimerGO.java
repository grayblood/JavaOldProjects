
public class TimerGO extends Component {

	int timer = 0;
	int segundos = -1;

	
	public void update(double deltatime) {

		timer += (int) deltatime;
		if (timer / 1000 == segundos) {
			System.out.println(segundos);
			segundos++;
		}

	}

	
	public void render() {

		

	}

}
