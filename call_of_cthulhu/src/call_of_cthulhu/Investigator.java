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
	private int sanity;
	private String name;
	Random rand = new Random();
	Scanner scnr = new Scanner(System.in);
	
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
		this.sanity = this.pow;
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
		String line11 = "\nMP: " + determineMP();
		String line12 = "\nBuild: " + determineBuild();
		String line13 = "\nMOV: " + determineMOV();
		String line14 = "\nPersonal Interest Points: " + determinePIP();
		String line15 = "\nSanity: " + this.sanity;
		return line1+line2+line3+line4+line5+line6+line7+line8+line9+line10+line11+line12+line13+line14+line15;
	}
}
