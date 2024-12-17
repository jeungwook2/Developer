package kh;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      
      System.out.println("수강하는 강의 수를 입력하세요.");
      int lectureNum = scan.nextInt();
      int lectureNum_Con = lectureNum;
      int i = 1;
      double gradeSum = 0;
            
      while(lectureNum_Con != 0) {
         System.out.println(i + "번째 강의 학점을 입력하세요.");
         double grade = scan.nextDouble();
         gradeSum += grade;
         lectureNum_Con--;
         i++;
      }
      
      double gradeAvr = gradeSum / lectureNum;
      
      System.out.println("나의 평균 학점은 " + gradeAvr + "입니다.");
      
      if(lectureNum >= 6 && gradeAvr >= 4.0) {
         System.out.println("성적 장학금 대상자입니다.");
      }
      else if(gradeAvr <= 2.0) {
         System.out.println("학사 경고 대상자입니다.");
      }
      
   }

}
