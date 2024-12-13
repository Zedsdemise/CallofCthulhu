package call_of_cthulhu;

import java.util.ArrayList;
import java.util.Iterator;

public class SkillManager {
	
	ArrayList<Skill> skillList;
	
	public void createSkill(int min, String name) {
		Skill skill = new Skill(min, name);
		skillList.add(skill);
	}
	
	
//	@Override
//	public String toString() {
//		Iterator<Skill> iter = skillList.iterator();
//		String lines;
//		while(iter.hasNext()) {
//			lines += iter.toString();
//		}
//	}
}
