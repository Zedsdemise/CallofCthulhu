package call_of_cthulhu;

import java.util.ArrayList;

public class Main {
	ArrayList<Investigator> invList = new ArrayList<>();
	
	public static void main(String[] args) {
		Investigator Alexander = new Investigator("Alexander");
		System.out.println(Alexander.toString());
	}
}
