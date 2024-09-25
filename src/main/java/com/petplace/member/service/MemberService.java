package com.petplace.member.service;

import static com.petplace.common.JDBCTemplate.*;

import java.sql.Connection;

import com.petplace.member.model.dao.MemberDao;
import com.petplace.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		System.out.println("sv" + m);
		
		close(conn);
		return m;
	}
}
