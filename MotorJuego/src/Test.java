
public class Test {
	
	//
	public static void main(String[] args) throws InterruptedException {
		int mili = 1000 / 60;
		
		Gameloop gameloop = Gameloop.getInstance();

		
		gameloop.init();
		
		GameObject spawner = new GameObject();
		spawner.addComponent(new Spawner());
		//spawner.addComponent(new TimerGO());
		gameloop.addGameObject(spawner);
	
		while(true)
		{
			gameloop.Input();
			gameloop.Update(16);
			gameloop.Render();
			Thread.sleep(mili);
		}
		
		
		
	}

}
