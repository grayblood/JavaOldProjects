import java.util.Random;

public class Timeout extends Component {
	Random rn = new Random();

	private int timer = 0;
	private int segundos = 0;
	

	private int m_timeToLive = rn.nextInt(5 - 0 + 1) + 0;
	
	
	
	
	public void update(double deltatime) {
		
		System.out.println(m_timeToLive);
		System.out.println("new");
		

			timer += (int) deltatime;
			if (timer / 1000 == segundos) {

				segundos++;
				m_timeToLive--;
				

			}
		
		if (m_timeToLive == 0) {
			System.out.println("muero");
			super.RemoveComponent(this);
			
		}
	}

	
	public void render() {
		// TODO Auto-generated method stub

	}
	

}
