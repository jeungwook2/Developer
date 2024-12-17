package kh;

import java.util.Scanner;

public class Champ {
	
	Scanner sc = new Scanner(System.in);
	String name;
	int value;
	String skillNameQ = "결정타";
	String skillNameW = "용기";
	String skillNameE = "심판";
	String skillNameR = "데마시아의 정의";
	
	public void skillQ() {
		System.out.println(skillNameQ + " : 둔화제거 및 속도상승, 다음 기본 공격 1.5초 침묵 및 추가 물리피해");
	}
	public void skillW() {
		System.out.println(skillNameW + " : 추가 방어력/마법방어력, 사용시 받는피해 감소 및 보호막, 60% 강인함");
	}
	public void skillE() {
		System.out.println(skillNameE + " : 3초동안 물리 피해 여러번 입힘");
	}
	public void skillR() {
		System.out.println(skillNameR + " : 잃은 체력비례 고정 피해");
	}
	
	
}
