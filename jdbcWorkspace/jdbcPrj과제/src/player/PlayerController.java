package player;

import static util.KhUtil.sc;

import java.util.List;

public class PlayerController {

	// 메뉴
	public void menu() {
		System.out.println("----- 선수 관리 DB -----");
		
		System.out.println("1. 선수 정보 입력");
		System.out.println("2. 선수 정보 삭제");
		System.out.println("3. 선수 정보 업데이트(포지션, 나이)");
		System.out.println("4. 선수 계약 업데이트(계약기간, 주급)");
		System.out.println("5. 선수 목록 조회");
		System.out.println("6. 선수 정보 상세 조회");
		System.out.println("7. 구단 주급 지출 조회");
		
		System.out.print("원하는 메뉴 번호 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertPlayerData(); break;
		case "2" : deletePlayerData(); break;
		case "3" : updatePlayerData(); break;
		case "4" : playerResign(); break;
		case "5" : selectPlayerList(); break;
		case "6" : selectPlayerByNo(); break;
		case "7" : selectSalarySum(); break;
		default : System.out.println("다시 입력하세요.");
		}
	}
	
	// 선수 정보 입력
	public void insertPlayerData() {
		try {
			System.out.println("===== Insert Player Data =====");
			
			// data
			System.out.print("position : ");
			String position = sc.nextLine();
			System.out.print("name : ");
			String name = sc.nextLine();
			System.out.print("age : ");
			String age = sc.nextLine();
			System.out.print("contractPeriod : ");
			String contractPeriod = sc.nextLine();
			System.out.print("weeklySalary : ");
			String weeklySalary = sc.nextLine();
			
			PlayerVo vo = new PlayerVo();
			vo.setPostion(position);
			vo.setName(name);
			vo.setAge(age);
			vo.setContractPeriod(contractPeriod);
			vo.setWeeklySalary(weeklySalary);
			
			// service
			PlayerService ps = new PlayerService();
			int result = ps.insertPlayer(vo);
			
			// result
			if(result == 1) {
				System.out.println("입력 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e) {
			System.out.println("입력 실패 ...");
			e.printStackTrace();
		}
	}
	
	// 선수 정보 삭제
	public void deletePlayerData() {
		
		try {
			
			System.out.println("===== Delete Player Data =====");
			
			// data
			System.out.println("삭제할 선수 no : ");
			String no = sc.nextLine();
			
			// service
			PlayerService ps = new PlayerService();
			int result = ps.deletePlayerData(no);
			
			//결과처리
			if(result == 1) {
				System.out.println("삭제하기 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e) {
			System.out.println("삭제 실패 ...");
			e.printStackTrace();
		}
		
		
	}//method
	
	// 선수 정보 업데이트(포지션, 나이)
	public void updatePlayerData() {
		
		try {
			
			System.out.println("===== Update Player Data =====");
			
			// data
			System.out.print("변경할 선수 no : ");
			String no = sc.nextLine();
			System.out.print("포지션 : ");
			String position = sc.nextLine();
			System.out.print("나이 : ");
			String age = sc.nextLine();
			
			PlayerVo vo = new PlayerVo();
			vo.setNo(no);
			vo.setPostion(position);
			vo.setAge(age);
			
			// service
			PlayerService ps = new PlayerService();
			int result = ps.updatePlayerData(vo);
			
			//결과처리
			if(result == 1) {
				System.out.println("업데이트 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e) {
			System.out.println("업데이트 실패 ...");
			e.printStackTrace();
		}
		
	}
	
	// 선수 재계약 (주급, 계약기간 업데이트)
	public void playerResign() {
		
		try {
			
			System.out.println("===== Player Resign =====");
			
			// data
			System.out.print("계약기간 : ");
			String contractPeriod = sc.nextLine();
			System.out.print("주급 : ");
			String weeklySalary = sc.nextLine();
			System.out.print("선수 번호 : ");
			String no = sc.nextLine();
			
			PlayerVo vo = new PlayerVo();
			vo.setContractPeriod(contractPeriod);
			vo.setWeeklySalary(weeklySalary);
			vo.setNo(no);
			
			// service
			PlayerService ps = new PlayerService();
			int result = ps.playerResign(vo);
			
			// result
			if(result == 1) {
				System.out.println("업데이트 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
			
		}catch(Exception e){
			System.out.println("업데이트 실패 ...");
			e.printStackTrace();
		}
	}
	
	// 선수 정보 목록 조회
	public void selectPlayerList() {
		
		try {
			System.out.println("===== Select Player List =====");
			
			//service
			PlayerService ps = new PlayerService();
			List<PlayerVo> voList = ps.selectPlayerList();
			
			//result
			System.out.println("번호 |  포지션  |  이름  | 나이");
			for(PlayerVo vo : voList) {
				System.out.println("");
				System.out.print(vo.getNo());
				System.out.print(" | ");
				System.out.print(vo.getPostion());
				System.out.print(" | ");
				System.out.print(vo.getName());
				System.out.print(" | ");
				System.out.print(vo.getAge() + "\n");
			
			}
		}catch(Exception e) {
			System.out.println("목록조회 실패 ...");
			e.printStackTrace();
		}
		
		
	}
	
	// 선수 정보 상세 조회
	public void selectPlayerByNo() {
		
		try {
			System.out.println("===== Select Player By No =====");
		
			//data
			System.out.print("상세조회할 선수 번호 : ");
			String no = sc.nextLine();
			
			//service
			PlayerService ps = new PlayerService();
			PlayerVo vo = ps.selectPlayerByNo(no);
			
			//result
			if(vo == null) {
				throw new Exception("존재하지 않는 번호");
			}
			System.out.println("번호 : " + vo.getNo());
			System.out.println("포지션 : " + vo.getPostion());
			System.out.println("이름 : " + vo.getName());
			System.out.println("나이 : " + vo.getAge());
			System.out.println("계약일 : " + vo.getEnrollDate());
			System.out.println("계약기간 : " + vo.getContractPeriod());
			System.out.println("주급 : " + vo.getWeeklySalary());
		
		}catch(Exception e) {
			System.out.println("상세조회 실패 ...");
			e.printStackTrace();
		}
		
	}
	
	// 구단 주급 지출 조회
	public void selectSalarySum() {
		
		try {
			System.out.println("===== Select Salary Sum =====");
		
			//data
			
			//service
			PlayerService ps = new PlayerService();
			PlayerVo vo = ps.selectSalarySum();
			
			//result
			System.out.println("\n" + "선수단 주급 총합 : " + vo.getSalarySum() + "\n");
		
		}catch(Exception e) {
			System.out.println("조회 실패 ...");
			e.printStackTrace();
		}
		
	}
	
}//class
