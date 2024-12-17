package com.kh.app.db;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class JDBCTemplate {
	
	public static SqlSession getSqlSession() throws Exception {
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		위 코드로 공장생성
		SqlSession ss = sqlSessionFactory.openSession(false);
//		sqlsession 생성 해서 자동커밋 off 
		return ss;
	}
	
	public static Connection getConnetcion() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	       String url = "jdbc:oracle:thin:@localhost:1521:xe";
	       String id = "C##KH";
	       String pwd = "1234";
	       Connection conn = DriverManager.getConnection(url , id , pwd);
		
	       conn.setAutoCommit(false);
	       return conn;
	}
	public static void commit(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.commit();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void rollback(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.rollback();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Statement x) {
	      try {
	         if(x != null && !x.isClosed()) {
	            x.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(ResultSet x) {
	      try {
	         if(x != null && !x.isClosed()) {
	            x.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }

}
