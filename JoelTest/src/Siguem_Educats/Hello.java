package Siguem_Educats;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		String name1,name2,name3;
		Scanner myObj = new Scanner(System.in);
		
		name1 = myObj.next();
		System.out.println("Benvingut/da, " + name1 + "!");
		
		name2 = myObj.next();
		System.out.println("Benvingut/da, " + name2 + "!");

		name3 = myObj.next();
		System.out.println("Benvingut/da, " + name3 + "!");
	}
}
