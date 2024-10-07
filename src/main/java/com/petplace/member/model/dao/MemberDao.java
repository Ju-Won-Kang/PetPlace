package com.petplace.member.model.dao;

import static com.petplace.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import org.apache.ibatis.session.SqlSession;

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
	
	public HashedMember loginMember(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.selectHashedMember", userId);
	}
	public int enrollMember(SqlSession sqlSession, HashedMember hashedMember){
		return sqlSession.insert("memberMapper.enrollMember", hashedMember);
	}
	public int checkId(SqlSession sqlSession, String checkId){
		return sqlSession.selectOne("memberMapper.checkId", checkId);
	}

}
