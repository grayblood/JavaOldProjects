package Dies_Correctes;
import java.util.Scanner;

public class Dies {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		int number = myObj.nextInt();
		if(number >= 1 && number <= 365) {
			System.out.println("Correcte per un any no bixest!");
		}else if(number == 366) {
			System.out.println("Correcte per un any bixest!");
		}else {
			System.out.println("Incorrecte!");
		}
	}
}
