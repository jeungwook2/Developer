package player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static util.JDBCTemplate.*;

public class PlayerDao {

	public int insertPlayerData(Connection conn, PlayerVo vo) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = """
					INSERT INTO PLAYER (
						NO
						, POSITION 
						, NAME
						, AGE
						, CONTRACT_PERIOD
						, WEEKLY_SALARY 
						) 
					VALUES (
						SEQ_PLAYER.NEXTVAL
						, ?
						, ?
						, ?
						, TRUNC(ADD_MONTHS(SYSDATE, ?))
						, ?
						)
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPostion());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAge());
			pstmt.setString(4, vo.getContractPeriod());
			pstmt.setString(5, vo.getWeeklySalary());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int deletePlayerData(Connection conn, String no) throws Exception {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = """
					DELETE PLAYER
					WHERE NO = ?
					""";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePlayerData(Connection conn, PlayerVo vo) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = """
					UPDATE PLAYER
					    SET
					        POSITION = ?
					        , AGE = ?
					WHERE NO = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPostion());
			pstmt.setString(2, vo.getAge());
			pstmt.setString(3, vo.getNo());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int playerResign(Connection conn, PlayerVo vo) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = """
					UPDATE PLAYER
					    SET
					        CONTRACT_PERIOD = TRUNC(ADD_MONTHS(SYSDATE, ?))
					        , WEEKLY_SALARY = ?
					WHERE NO = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContractPeriod());
			pstmt.setString(2, vo.getWeeklySalary());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
	
		return result;
	}

	public List<PlayerVo> selectPlayerList(Connection conn) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlayerVo vo = null;
		List<PlayerVo> voList = null;
		
		
		try {
			
			String sql = """
					SELECT 	
						NO
						, POSITION
						, NAME
						, AGE
					FROM PLAYER
					WHERE CONTRACT_PERIOD > SYSDATE
					ORDER BY POSITION ASC
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			voList = new ArrayList<PlayerVo>();

			while(rs.next()) {
				String no =rs.getString("NO");
				String position =rs.getString("POSITION");
				String name =rs.getString("NAME");
				String age =rs.getString("AGE");
				
				vo = new PlayerVo(no, position, name, age, null, null, null);
				
				voList.add(vo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
		
	}

	public PlayerVo selectPlayerByNo(Connection conn, String no) throws Exception {
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlayerVo vo = null;
		
		try {
			
			String sql = """
					SELECT * FROM PLAYER
					WHERE NO = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				String no = rs.getString("TITLE");
				String position = rs.getString("POSITION");
				String name = rs.getString("NAME");
				String age = rs.getString("AGE");
				String enrollDate = rs.getString("ENROLL_DATE");
				String contractPeriod = rs.getString("CONTRACT_PERIOD");
				String weeklySalary = rs.getString("WEEKLY_SALARY");
				
				vo = new PlayerVo(no, position, name, age, enrollDate, contractPeriod, weeklySalary);
				
				}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
		
	}

	public PlayerVo selectSalarySum(Connection conn) throws Exception {
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlayerVo vo = null;
		
		try {
			
			String sql = """
					SELECT SUM(WEEKLY_SALARY) AS "선수단 주급 총합"
					FROM PLAYER
					WHERE CONTRACT_PERIOD > SYSDATE
					""";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String salarySum = rs.getString("선수단 주급 총합");
				
				vo = new PlayerVo(salarySum);
				
				}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	
	}

}
