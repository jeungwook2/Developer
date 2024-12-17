package kh;

import java.util.Scanner;

public class Main02 {

   public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      
      while(true) {
         System.out.println("환전할 금액을 입력하세요.");
         int money = scan.nextInt();
         int exRate = 1350;
         int dollar = money / exRate;
         int change = money % exRate;
         System.out.println("보유한 달러는 " + dollar + "$ 입니다. " + change + "원이 남습니다.");
   
         System.out.println("20달러 지폐 몇장이 필요하십니까?");
         int dollar_20 = scan.nextInt();
         
         System.out.println("10달러 지폐 몇장이 필요하십니까?");      
         int dollar_10 = scan.nextInt();
         
         System.out.println("5달러 지폐 몇장이 필요하십니까?");      
         int dollar_5 = scan.nextInt();
         
         int remain = dollar;
         
         for(int i=1; i <= dollar_20; i++) {
            remain -= 20;
         }
         
         for(int i=1; i <= dollar_10; i++) {
            remain -= 10;
         }
   
         for(int i=1; i <= dollar_5; i++) {
            remain -= 5;
         }
         
         if(remain>=0) {
            System.out.println("20달러 지폐: " + dollar_20 + "장");
            System.out.println("10달러 지폐: " + dollar_10 + "장");
            System.out.println(" 5달러 지폐: " + dollar_5 + "장");
            System.out.print(" 1달러 지폐: " + remain + "장");
            System.out.println("으로 환전 하시겠습니까?(Y/N)");
            char resp = scan.next().charAt(0);
            if(resp == 'Y' || resp == 'y') {
               System.out.println("환전이 완료 되었습니다.");
               break;
            }
            else if(resp == 'N' || resp == 'n') {
               continue;
            }
         }
         
         else {
            System.out.println("금액이 부족합니다.");   
            continue;
         }
      }
      
   }

}