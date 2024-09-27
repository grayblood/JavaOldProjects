package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		ArrayList<MyClass> Lista= new ArrayList<>();
		MyClass a = new MyClass("Antonio", "Gonzales", 10);
		MyClass b = new MyClass("Bert", "Musolini", 21);
		MyClass c = new MyClass("Ivan", "Poliiiiine", 41);
		MyClass d = new MyClass("Trevor", "Dims", 40);
		Lista.add(a);
		Lista.add(b);
		Lista.add(c);
		Lista.add(d);
		Collections.sort(Lista);  
		System.out.println(Lista);
		
		
	}

}
