package call_of_cthulhu;

public class Skill {
	private int min;
	private int curVal;
	private String name;
	
	public Skill(int min, String name) {
		this.min = min;
		this.curVal = min;
		this.name = name;
	}
	
	public int getMin() {
		return min;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCurVal() {
		return curVal;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCurVal(int curVal) {
		this.curVal = curVal;
	}
	
}
