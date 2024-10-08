package com.petplace.member.model.dao;

import static com.petplace.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.petplace.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// select -> Member객체 조회 -> ResultSet객체

		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("loginMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery(); // 조회결과가 있다면 한 행 반환 | 없으면 반환 x
			if (rset.next()) {
				m = new Member(
							rset.getString("member_id"),
							rset.getString("member_pwd"),
							rset.getString("member_name"),
							rset.getString("nickname"),
							rset.getString("phone"),
							rset.getString("member_number"),
							rset.getString("member_address"),
							rset.getDate("member_date"),
							rset.getString("status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao" + m);

		return m;
	}
}
