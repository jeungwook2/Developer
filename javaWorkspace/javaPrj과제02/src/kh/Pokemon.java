package kh;

public class Pokemon {
   
   private String name;
   private int lv;
   private int hp;
   private int atk;
   private int def;
   private int spd;
   
   @Override
   public String toString() {
      return name + " [ lv=" + lv + ", hp=" + hp + ", atk=" + atk + ", def=" + def + ", spd=" + spd + " ]";
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getLv() {
      return lv;
   }
   public void setLv(int lv) {
      this.lv = lv;
   }
   public int getHp() {
      return hp;
   }
   public void setHp(int hp) {
      this.hp = hp;
   }
   public int getAtk() {
      return atk;
   }
   public void setAtk(int atk) {
      this.atk = atk;
   }
   public int getDef() {
      return def;
   }
   public void setDef(int def) {
      this.def = def;
   }
   public int getSpd() {
      return spd;
   }
   public void setSpd(int spd) {
      this.spd = spd;
   }

}
