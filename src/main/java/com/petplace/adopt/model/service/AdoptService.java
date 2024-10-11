package com.petplace.adopt.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;
import com.petplace.common.PageInfo;

public interface AdoptService {
	// 입양 게시판 불러오기
	int selectAdoptListCount(String boardType);
	ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType);
	
	// 입양 게시글 삽입
	int insertAdopt(Adopt a, AdoptAttachment aAt);
	
	// 게시글 조회수
	int increaseCount(HashMap<String, Object> map);
	
	// 입양 게시글 상세 조회
	Adopt selectDetailList(HashMap<String, Object> map);
	
	// 메인페이지 유기/실종 조회
	ArrayList<Adopt> selectMissingMainList();
}
