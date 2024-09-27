package Stack;
public class Test {
	public static <T> void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>();
		
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
