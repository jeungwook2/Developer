package kh;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 사원 관리 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.println("사원 수를 입력하세요.");
		int n = sc.nextInt();
		Employee[] emp = new Employee[n]; // 배열 생성
		
		for(int i=0; i<n; i++) {
			emp[i] = new Employee(); // 객체 생성
		}
		
		for(int i=0; i<n; i++) {
			System.out.println("이름, 부서, 직책, 나이, 주소를 공백을 두고 입력하세요.");			
			emp[i].name = sc.next();
			emp[i].department = sc.next();
			emp[i].position = sc.next();
			emp[i].age = sc.nextInt();
			emp[i].address = sc.next();
		}
		
		System.out.println("정보를 열람할 사원명을 입력하세요.");
		String empName = sc.next();
		
		for(int i=0; i<n; i++) {
			if(empName.equals(emp[i].name)) {
				emp[i].output();
//				System.out.print(emp[i].name + " ");
//				System.out.print(emp[i].department + " ");
//				System.out.print(emp[i].position + " ");
//				System.out.print(emp[i].age + " ");
//				System.out.println(emp[i].address + " ");
			}
		}
	}

}
