package poolgeneric;
import Pool.Pool;

public class Tept2 {
	public static <T> void main(String[] args) {
		Pool pol = new Pool();
		System.out.println(pol);
		T a = (T) pol.get();
		T b = (T) pol.get();
		T c = (T) pol.get();

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
