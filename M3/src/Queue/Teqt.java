package Queue;
public class Teqt {
	public static <T> void main(String[] args) {
		Queue<Integer> a = new Queue<Integer>();
		
		a.Push(5);
		a.Push(4);
		a.Push(7);
		a.see();
		a.Pop();
		a.see();
		a.Pop();
		a.see();
	}
}
