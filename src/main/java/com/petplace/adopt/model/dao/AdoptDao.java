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
		return sqlSession.insert("adoptMapper.insertAdopt", a);
	}
	
	// 첨부파일 삽입
	public int insertAdoptAttachmentList(SqlSession sqlSession, AdoptAttachment aAt) {
		return sqlSession.insert("adoptMapper.insertadoptAttachmentList", aAt);
	}
	
	// 게시글 조회수 증가
	public int increaseCount(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println(map);
		return sqlSession.update("adoptMapper.increaseCount", map);
	}
	
	// 게시글 상세 조회
	public Adopt selectDetailList(SqlSession sqlSession, HashMap<String, Object> map) {
		Adopt a = sqlSession.selectOne("adoptMapper.selectDetailList", map);

		return a;
	}
	
	// 메인페이지 유기/실종
	public ArrayList<Adopt> selectMissingMainList(SqlSession sqlSession){
		return (ArrayList)sqlSession.selectList("adoptMapper.selectMissingMainList");
	}
}
