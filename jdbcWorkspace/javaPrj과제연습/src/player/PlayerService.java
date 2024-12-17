package player;

import java.sql.Connection;
import java.util.List;

import static util.JDBCTemplate.*;

public class PlayerService {

	public int insertPlayer(PlayerVo vo) throws Exception {

		Connection conn = null;
		int result = 0;
		
		try {
			
			//biz
			if(Integer.parseInt(vo.getAge()) < 15) {
				throw new Exception("15세 이상의 선수만 등록할 수 있습니다.");
			}
			
			if(!vo.getPostion().equals("FW") 
					&& !vo.getPostion().equals("MF") 
					&& !vo.getPostion().equals("DF") 
					&& !vo.getPostion().equals("GK"))  {
				throw new Exception("포지션은 FW, MF, DF, GK 로만 구분합니다.");
			}
			
			if(vo.getName().length() < 1) {
				throw new Exception("최소 한 글자 이상 입력하세요.");
			}
			
			conn = getConnection();
			PlayerDao dao = new PlayerDao();
			result = dao.insertPlayerData(conn, vo);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			close(conn);
		}
		
		return result;
		
	}

	public int deletePlayerData(String no) throws Exception {
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();
			
			// DAO
			PlayerDao dao = new PlayerDao();
			result = dao.deletePlayerData(conn, no);
			
			// tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			close(conn);
		}
		
		return result;
		
	}

	public int updatePlayerData(PlayerVo vo) throws Exception {

		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();
			
			//DAO
			PlayerDao dao = new PlayerDao();
			result = dao.updatePlayerData(conn, vo);
			
			//tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			close(conn);
		}
		
		return result;
	}

	public int playerResign(PlayerVo vo) throws Exception {
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();
			
			//DAO
			PlayerDao dao = new PlayerDao();
			result = dao.playerResign(conn, vo);
			
			//tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			close(conn);
		}
		
		return result;
	}

	public List<PlayerVo> selectPlayerList() throws Exception {
	
		Connection conn = null;
		List<PlayerVo> voList = null;
		
		try {
			// DAO
			PlayerDao dao = new PlayerDao();
			conn = getConnection();
			voList = dao.selectPlayerList(conn);
		}finally {
			// close
			close(conn);
		}
		
		return voList;
		
	}

	public PlayerVo selectPlayerByNo(String no) throws Exception {

		Connection conn = null;
		PlayerVo vo = null;
		
		try {
			// DAO
			PlayerDao dao = new PlayerDao();
			conn = getConnection();
			vo = dao.selectPlayerByNo(conn, no);
		}finally {
			// close
			close(conn);
		}
		
		return vo;
		
	}

}
