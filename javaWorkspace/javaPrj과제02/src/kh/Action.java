package kh;

import java.util.Scanner;

public class Action {

   Scanner sc = new Scanner(System.in);
   Pokemon myPoke = new Pokemon();
   Pokemon enemyPoke = new Pokemon();
   int startPoke;
   int skillNo;

   
   //포켓몬 선택하기
   public void choosePoke() {
      System.out.println("======== 포켓몬을 선택하세요. ========");
      System.out.println("1. 이상해씨 // 2. 파이리 // 3. 꼬부기");
      System.out.print("\n번호를 입력하세요 : ");
      startPoke = sc.nextInt();
      
      if (startPoke == 1) {
         myPoke.setName("이상해씨");
         myPoke.setLv(5);
         myPoke.setHp(10 + myPoke.getLv()*2);
         myPoke.setAtk(6 + myPoke.getLv());
         myPoke.setDef(7 + myPoke.getLv());
         myPoke.setSpd(6 + myPoke.getLv());
      }
      else if(startPoke == 2) {
         myPoke.setName("파이리");
         myPoke.setLv(5);
         myPoke.setHp(10 + myPoke.getLv()*2);
         myPoke.setAtk(6 + myPoke.getLv());
         myPoke.setDef(5 + myPoke.getLv());
         myPoke.setSpd(8 + myPoke.getLv());
      }
      else if(startPoke == 3) {
         myPoke.setName("꼬부기");
         myPoke.setLv(5);
         myPoke.setHp(10 + myPoke.getLv()*2);
         myPoke.setAtk(6 + myPoke.getLv());
         myPoke.setDef(8 + myPoke.getLv());
         myPoke.setSpd(5 + myPoke.getLv());
      }
      else {
         System.out.println("번호를 다시 입력하세요.");
      }
      System.out.println(myPoke.getName() + "를 골랐다!\n");
      userAction();
   }
   
   // 행동
   public void userAction() {
      while(true) {
         System.out.println("======== 다음에 할 행동 ========");
         System.out.println("1. 이동 // 2. 포켓몬 다시선택");
         System.out.print("번호를 입력하세요 : ");
         int action = sc.nextInt();
         System.out.print("\n");
         if(action == 1) {
            this.move();
            break;
         }
         else if(action == 2) {
            choosePoke();
            break;
         }
         else {
            System.out.println("번호를 다시 입력하세요.");
            continue;
         }

      }      
   }

   // 이동
   public void move() {
      System.out.println(myPoke.toString());
      this.wildPoke();
      System.out.println("\n야생의 " + enemyPoke.getName() + "가(이) 나타났다!");
      System.out.println(enemyPoke.toString() + "\n");
      this.battle();
   }
   
   // 야생 포켓몬 생성
   public void wildPoke() {
      int enemyPokeNum = (int)(Math.random() * 3) + 1;
      int enemyPokeLv = (int)(Math.random() * 3) + 2;
      if(enemyPokeNum == 1) {
         enemyPoke.setName("캐터피");
         enemyPoke.setLv(enemyPokeLv);
         enemyPoke.setHp(11+enemyPoke.getLv()*2);
         enemyPoke.setAtk(4+enemyPoke.getLv());
         enemyPoke.setDef(5+enemyPoke.getLv());
         enemyPoke.setSpd(6+enemyPoke.getLv());
      }
      else if(enemyPokeNum == 2) {
         enemyPoke.setName("구구");
         enemyPoke.setLv(enemyPokeLv);
         enemyPoke.setHp(10+enemyPoke.getLv()*2);
         enemyPoke.setAtk(6+enemyPoke.getLv());
         enemyPoke.setDef(5+enemyPoke.getLv());
         enemyPoke.setSpd(7+enemyPoke.getLv());
      }
      else if(enemyPokeNum == 3) {
         enemyPoke.setName("꼬렛");
         enemyPoke.setLv(enemyPokeLv);
         enemyPoke.setHp(9+enemyPoke.getLv()*2);
         enemyPoke.setAtk(7+enemyPoke.getLv());
         enemyPoke.setDef(5+enemyPoke.getLv());
         enemyPoke.setSpd(8+enemyPoke.getLv());
      }
   }
   
   // 배틀
   public void battle() {
      while(myPoke.getHp()>0 && enemyPoke.getHp()>0) {
         beforeTurn();
         if(myPoke.getSpd() >= enemyPoke.getSpd()) {
            myTurn(skillNo);
            if(enemyPoke.getHp() > 0) {
               enemyTurn();
            }
         }
         else {
            enemyTurn();
            if(myPoke.getHp() > 0) {
               myTurn(skillNo);
            }
         }
      }
   }
   
   // 턴 액션 이전
   public void beforeTurn() {
      System.out.println("======== 기술 목록 ========");
      if(myPoke.getName() == "이상해씨" || myPoke.getName() == "파이리") {
         System.out.println("1. 몸통박치기  //  2. 울음소리 ");
      }
      else {
         System.out.println("1. 몸통박치기 // 2. 꼬리흔들기 ");
      }
      System.out.println("========================\n");
      System.out.print("사용할 기술 번호 : ");
      skillNo = sc.nextInt();
      System.out.println();
   }
   
   // 내턴
   public void myTurn(int skillNo) {
      
      if(skillNo == 1) {
         tackle();
         
         if(enemyPoke.getHp() > 0) {
            System.out.println(enemyPoke.toString()+"\n");
         }
         else{
            System.out.println(enemyPoke.toString()+"\n");
            System.out.println("야생의 " + enemyPoke.getName() + "가(이) 쓰러졌다." );
            myPoke.setLv(myPoke.getLv()+1);
            System.out.println("\n" + myPoke.getName()+"의 레벨이 올랐다!");
            System.out.println("\n======= 다음에 할 행동 =======");
            System.out.println("1. 마을로 이동 // 2. 퓰숲을 더 배회");
            int course = sc.nextInt();
            if(course==1) {
               System.out.println("무사히 마을에 도착했다.");
            }
            else if(course==2) {
               myPoke.setHp(myPoke.getHp() + 2);
               myPoke.setAtk(6 + myPoke.getLv());
               myPoke.setDef(7 + myPoke.getLv());
               myPoke.setSpd(6 + myPoke.getLv());
               move();
            }
         }
      }
      else if(skillNo == 2 && (myPoke.getName() == "이상해씨" || myPoke.getName() == "파이리")) {
         growl();
         System.out.println(enemyPoke.toString()+"\n");
      }
      else if(skillNo == 2 && myPoke.getName() == "꼬부기") {
         tailWhip();
         System.out.println(enemyPoke.toString()+"\n");
      }
   }
   
   // 상대턴
   public void enemyTurn() {
      int enemySkillNo = (int)(Math.random() * 2) + 1;
      
      if(enemySkillNo == 1) {
         enemyTackle();
         
         if(myPoke.getHp() > 0) {
            System.out.println(myPoke.toString()+"\n");
         }
         else{
            System.out.println(myPoke.toString()+"\n");
            System.out.println("\n" + myPoke.getName() + "가(이) 쓰러졌다." );
            System.out.println("눈앞이 깜깜해졌다.");
         }
      }
      else if(enemySkillNo == 2 && enemyPoke.getName() == "캐터피") {
         stringShot();
         System.out.println(myPoke.toString()+"\n");
      }
      else if(enemySkillNo == 2 && enemyPoke.getName() == "꼬렛") {
         enemyTailWhip();
         System.out.println(myPoke.toString()+"\n");
      }
      else if(enemySkillNo == 2 && enemyPoke.getName() == "구구") {
         enemyGrowl();
         System.out.println(myPoke.toString()+"\n");
      }
   }
   

   
   // 스킬 메서드
   public void tackle() {
      System.out.println(myPoke.getName() + "의 몸통박치기");
      int critical = (int)(Math.random()*5);
      int myDmg;
      switch(critical) {
      case 0: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef())*2 +2; System.out.println("급소에 맞았다!"); break;
      case 1: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 2: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 3: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 4: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      default: myDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      }
      System.out.println(myDmg + "의 피해");
      enemyPoke.setHp(enemyPoke.getHp()-myDmg);
   }
   
   public void enemyTackle() {
      System.out.println(enemyPoke.getName() + "의 몸통박치기");
      int critical = (int)(Math.random()*5);
      int enemyDmg;
      switch(critical) {
      case 0: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef())*2 +2; System.out.println("급소에 맞았다!"); break;
      case 1: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 2: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 3: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      case 4: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      default: enemyDmg = ((((myPoke.getLv() * 2 / 5) + 2) * 40 * myPoke.getAtk() / 50) / enemyPoke.getDef()) +2; break;
      }
      System.out.println(enemyDmg + "의 피해");
      myPoke.setHp(myPoke.getHp()-enemyDmg);
   }
   
   public void growl() {
      System.out.println(myPoke.getName() + "의 울음소리");
      System.out.println(enemyPoke.getName() + "의 공격이 떨어졌다.");
      enemyPoke.setAtk(enemyPoke.getAtk()/2);
   }
   
   public void enemyGrowl() {
      System.out.println(enemyPoke.getName() + "의 울음소리");
      System.out.println(myPoke.getName() + "의 공격이 떨어졌다.");
      myPoke.setAtk(myPoke.getAtk()/2);
   }
   
   public void stringShot() {
      System.out.println(enemyPoke.getName() + "의 실뿜기");
      System.out.println(myPoke.getName() + "의 스피드가 떨어졌다.");
      myPoke.setSpd(myPoke.getSpd()/2);
   }
   
   public void tailWhip() {
      System.out.println(myPoke.getName() + "의 꼬리흔들기");
      System.out.println(enemyPoke.getName() + "의 방어가 떨어졌다.");
      enemyPoke.setDef(enemyPoke.getDef()/2);;
   }
   
   public void enemyTailWhip() {
      System.out.println(enemyPoke.getName() + "의 꼬리흔들기");
      System.out.println(myPoke.getName() + "의 방어가 떨어졌다.");
      myPoke.setDef(myPoke.getDef()/2);;
   }
   
}
