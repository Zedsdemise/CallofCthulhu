package call_of_cthulhu;

import java.util.Random;
import java.util.Scanner;

public class Investigator {
	private int str;
	private int con;
	private int dex;
	private int siz;
	private int app;
	private int nte;
	private int edu;
	private int pow;
	private int luck;
	private int hp;
	private int sanity;
	private int pIP;
	private int mp;
	private int build;
	private int mov;
	private String name;
	Random rand = new Random();
	Scanner scnr = new Scanner(System.in);
	
	
	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getSiz() {
		return siz;
	}

	public void setSiz(int siz) {
		this.siz = siz;
	}

	public int getApp() {
		return app;
	}

	public void setApp(int app) {
		this.app = app;
	}

	public int getNte() {
		return nte;
	}

	public void setNte(int nte) {
		this.nte = nte;
	}

	public int getEdu() {
		return edu;
	}

	public void setEdu(int edu) {
		this.edu = edu;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getSanity() {
		return sanity;
	}

	public void setSanity(int sanity) {
		this.sanity = sanity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPIP() {
		return pIP;
	}

	public void setpIP(int pIP) {
		this.pIP = pIP;
	}
	
	public int getMP() {
		return mp;
	}

	public void setMP(int mP) {
		this.mp = mP;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	public int getMov() {
		return mov;
	}

	public void setMov(int mov) {
		this.mov = mov;
	}

	public int generate2d6() {
		int rand_1 = rand.nextInt(6) + 1;
		int rand_2 = rand.nextInt(6) + 1;
		return rand_1 + rand_2 + 6;
	}
	
	public int generate3d6() {
		int rand_1 = rand.nextInt(6) + 1;
		int rand_2 = rand.nextInt(6) + 1;
		int rand_3 = rand.nextInt(6) + 1;
		return rand_1 + rand_2 + rand_3;
	}
	
	public Investigator(String name) {
		this.name = name;
		this.str = generate3d6() * 5;
		this.dex = generate3d6() * 5;
		this.con = generate3d6() * 5;
		this.app = generate3d6() * 5;
		this.pow = generate3d6() * 5;
		this.luck = generate3d6() * 5;
		this.edu = generate2d6() * 5;
		this.siz = generate2d6() * 5;
		this.nte = generate2d6() * 5;
		this.hp = determineHP();
		this.sanity = this.pow;
		this.mp = determineMP();
		this.pIP = determinePIP();
		this.mov = determineMOV();
		this.hp = determineHP();
	}
	
	public int determineBuild() {
		int build = this.str + this.siz;
		int buildValue = 0;
		if(build <= 64) {
			buildValue = -2;
		} else if(build > 64 && build <=84) {
			buildValue = -1;
		} else if(build > 84 && build <=124) {
			buildValue = 0;
		} else if(build > 124 && build <=164) {
			buildValue = 1;
		} else if(build > 164 && build <=204) {
			buildValue = 2;
		}
		return buildValue;
	}
	
	public int determineHP() {
		return (this.con + this.siz) / 10;
	}
	
	public int determineMOV() {
		if(this.dex < this.siz && this.str < this.siz) {
			return 7;
		} else if(this.dex > this.siz && this.str > this.siz) {
			return 9;
		} else {
			return 8;
		}
	}
	
	public int determinePIP() {
		return this.nte * 2;
	}
	
	public int determineMP() {
		return this.pow / 5;
	}
	
	@Override
	public String toString() {
		String line1 = "Name: " + this.name;
		String line2 = "\nStrength: " + this.str;
		String line3 = "\nConstitution: " + this.con;
		String line4 = "\nDexterity: " + this.dex;
		String line5 = "\nSize: " + this.siz;
		String line6 = "\nWillpower: " + this.pow;
		String line7 = "\nIntelligence: " + this.nte;
		String line8 = "\nEducation: " + this.edu;
		String line9 = "\nLuck: " + this.luck;
		String line10 = "\nHP: " + determineHP();
		String line11 = "\nMP: " + this.mp;
		String line12 = "\nBuild: " + determineBuild();
		String line13 = "\nMOV: " + determineMOV();
		String line14 = "\nPersonal Interest Points: " + this.pIP;
		String line15 = "\nSanity: " + this.sanity;
		return line1+line2+line3+line4+line5+line6+line7+line8+line9+line10+line11+line12+line13+line14+line15;
	}
}
