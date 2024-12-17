package kh;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("안녕");
		
		/*
		 * <변수> : 값을 저장하기 위한 공간 
		 * - 선언 : 변수 만들기
		 * - 할당 : 변수에 값 넣기
		 * - 초기화 : 첫번째 할당
		 * - 변수타입 : 변수에 들어가는 데이터의 타입 제한
		 * 
		 * [문법]
		 * 타입 변수명 = 값;
		 * 
		 * [타입(자료형)]
		 * - 정수 : byte, short, int, long
		 * - 실수 : float, double
		 * - 문자 : char
		 * - 문자열 : String (대문자인 이유 -> 참조자료형)
		 * - 논리값 : boolean
		 * 
		 * [주의사항]
		 * - 이름이 같은 변수를 만드는건 안됨
		 * - 특수문자는 _, $ 만 가능
		 * - 의미를 파악하기 쉬운 이름으로 작성
		 * - 숫자로 시작하면 안됨
		 * - 예약어 사용 금지
		 * - 약어 지양하기
		 * - camelCase 규칙에 맞게 작성
		 * 
		 * [형변환]
		 * - 타입(형태)을 변환하는 것
		 * - 문법 : (변환할 타입)데이터
		 * - 자동 형변환
		 * - 강제 형변환
		 * - 데이터 유실 주의
		 * 
		 * [scope]
		 * - 변수는 태어난 블럭 안에서만 존재한다
		 * 
		 * [기본자료형, 참조형]
		 * - 기본자료형 : 값이 담긴다
		 * - 참조자료형 : 주소가 담긴다
		 * 
		 */
		
		// 선언
		// x 라는 이름을 가진 정수형 변수 만들기
//		int x;
		
		// 할당
		// 위에서 만든 변수 x에 10 이라는 값 할당;
//		x = 10;
		
		// 초기화
		// 위에서 진행한 선언과 할당을 동시에 하기
//		int x = 10;
		
		
		// 원하는 타입의 변수 만들고, 값 할당하고, 출력해보기
		float coinValue = (float)8273.6; //형변환 - 자동(컴퓨터), 강제(개발자)
		coinValue = 8356.3f; // (float) 말고 3.14f도 가능
		System.out.println(coinValue);
		long x = 2222222222L; // L로 강제 형변환, l과 f만 존재
		
		//overflow
		byte a = (byte)128; // 129 입력시 결과값 -127, 130 입력시 결과값 -126
		System.out.println(a);
		
		// 문자타입
		char b = 'h'; // 문자는 ' 따옴표 사용
		System.out.println(b);
		
		// 논리타입
		boolean c = true; // 소문자
		System.out.println(c);
		
	}

}
