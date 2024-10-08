package com.petplace.adopt.model.service;

import java.util.ArrayList;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;

public interface AdoptService {
	int selectAdoptListCount(String boardType);
	ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType);
}
