package com.petplace.adopt.model.service;

import java.util.ArrayList;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;
import com.petplace.common.PageInfo;

public interface AdoptService {
	// 입양 게시판 불러오기
	int selectAdoptListCount(String boardType);
	ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType);
	
	// 입양 게시글 삽입
	int insertAdopt(Adopt a, AdoptAttachment aAt);
}
