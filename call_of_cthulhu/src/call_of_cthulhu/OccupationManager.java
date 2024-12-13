package call_of_cthulhu;

import java.util.ArrayList;

public class OccupationManager {

	private ArrayList<Occupation> occupations;
	
	public void createOccupation(int[] osp, int crMin, int crMax, String name) {
		Occupation occupation = new Occupation(osp, crMin, crMax, name);
		occupations.add(occupation);
	}
}
