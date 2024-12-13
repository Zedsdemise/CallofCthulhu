package call_of_cthulhu;

import java.util.Random;
import java.util.Scanner;

public class Investigator {
	private int[] characteristics = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	// Index is; Str, Con, Dex, Siz, App, Nte, Edu, Pow, Luck
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
		return characteristics[0];
	}

	public void setStr(int str) {
		characteristics[0] = str;
	}

	public int getCon() {
		return characteristics[1];
	}

	public void setCon(int con) {
		characteristics[1] = con;
	}

	public int getDex() {
		return characteristics[2];
	}

	public void setDex(int dex) {
		characteristics[2] = dex;
	}

	public int getSiz() {
		return characteristics[3];
	}

	public void setSiz(int siz) {
		characteristics[3] = siz;
	}

	public int getApp() {
		return characteristics[4];
	}

	public void setApp(int app) {
		characteristics[4] = app;
	}

	public int getNte() {
		return characteristics[5];
	}

	public void setNte(int nte) {
		characteristics[5] = nte;
	}

	public int getEdu() {
		return characteristics[6];
	}

	public void setEdu(int edu) {
		characteristics[6] = edu;
	}

	public int getPow() {
		return characteristics[7];
	}

	public void setPow(int pow) {
		characteristics[7] = pow;
	}

	public int getLuck() {
		return characteristics[8];
	}

	public void setLuck(int luck) {
		characteristics[8] = luck;
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
		for(int i = 0; i<6; i++) {
			characteristics[i] = generate3d6() * 5;
		}
		for(int i = 6; i < 9; i++) {
			characteristics[i] = generate2d6() * 5;
		}
		this.hp = determineHP();
		this.sanity = characteristics[7];
		this.mp = determineMP();
		this.pIP = determinePIP();
		this.mov = determineMOV();
		this.hp = determineHP();
	}
	
	public int determineBuild() {
			// Build = Str plus Siz
		int build = characteristics[0] + characteristics[3];
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
			// Con plus Siz divided by 10, rounding down
		return (characteristics[1] + characteristics[3]) / 10;
	}
	
	public int determineMOV() {
			// If Dex and Str are both lower than Siz
		if(characteristics[2] < characteristics[3] && characteristics[0] < characteristics[3]) {
			return 7;
			// If Dex and Str are both higher than Siz
		} else if(characteristics[2] > characteristics[3] && characteristics[0] > characteristics[3]) {
			return 9;
			// Otherwise
		} else {
			return 8;
		}
	}
	
	public int determinePIP() {
			// Nte times 2
		return characteristics[5] * 2;
	}
	
	public int determineMP() {
			// Pow times 5
		return characteristics[7] / 5;
	}
	
	@Override
	public String toString() {
		String line1 = "Name: " + this.name;
		String line2 = "\nStrength: " + characteristics[0];
		String line3 = "\nConstitution: " + characteristics[1];
		String line4 = "\nDexterity: " + characteristics[2];
		String line5 = "\nSize: " + characteristics[3];
		String line6 = "\nAppearance" + characteristics[4];
		String line7 = "\nWillpower: " + characteristics[7];
		String line8 = "\nIntelligence: " + characteristics[5];
		String line9 = "\nEducation: " + characteristics[6];
		String line10 = "\nLuck: " + characteristics[8];
		String line11 = "\nHP: " + determineHP();
		String line12 = "\nMP: " + this.mp;
		String line13 = "\nBuild: " + determineBuild();
		String line14 = "\nMOV: " + determineMOV();
		String line15 = "\nPersonal Interest Points: " + this.pIP;
		String line16 = "\nSanity: " + this.sanity;
		return line1+line2+line3+line4+line5+line6+line7+line8+line9+line10+line11+line12+line13+line14+line15+line16;
	}
}
