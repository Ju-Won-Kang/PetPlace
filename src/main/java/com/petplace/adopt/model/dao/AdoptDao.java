package com.petplace.adopt.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;

public class AdoptDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("AdoptMapper.selectListCount");
	}
	
	public ArrayList<Adopt> selectAdoptMissingList(SqlSession sqlSession, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("AdoptMapper.selectAdoptMissingList", null, rowBounds);
	}
}
