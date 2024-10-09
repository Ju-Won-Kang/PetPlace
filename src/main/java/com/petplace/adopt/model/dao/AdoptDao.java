package com.petplace.adopt.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;
import com.petplace.common.PageInfo;

public class AdoptDao {
	
	public int selectAdoptListCount(SqlSession sqlSession, String boardType) {
		return sqlSession.selectOne("adoptMapper.selectAdoptListCount", boardType);
	}
	
	public ArrayList<Adopt> selectAdoptList(SqlSession sqlSession, PageInfo pi, String boardType){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("adoptMapper.selectAdoptList", boardType, rowBounds);
	}
	
	// 입양 게시글 삽입
	public int insertAdopt(SqlSession sqlSession, Adopt a) {
		return sqlSession.insert("adoptMapper.insertAdopt", a);
	}
}
