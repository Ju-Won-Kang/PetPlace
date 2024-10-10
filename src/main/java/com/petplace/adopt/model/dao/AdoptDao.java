package com.petplace.adopt.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
		System.out.println(a);
		return sqlSession.insert("adoptMapper.insertAdopt", a);
	}
	
	public int insertAdoptAttachmentList(SqlSession sqlSession, AdoptAttachment aAt) {
		System.out.println(aAt);
		return sqlSession.insert("adoptMapper.insertadoptAttachmentList", aAt);
	}
	
	public Adopt selectDetailList(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.selectOne("adoptMapper.selectDetailList", map);
	}
}
