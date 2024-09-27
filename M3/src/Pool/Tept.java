package Pool;

public class Tept {
	public static void main(String[] args) {
		Pool pol = new Pool();
		System.out.println(pol);
		Object a = pol.get();
		Object b = pol.get();
		Object c = pol.get();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(pol);

		pol.retorn(c);
		pol.retorn(b);
		pol.retorn(a);
		System.out.println(pol);
	}
}
