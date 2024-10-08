package com.petplace.adopt.model.service;

import java.util.ArrayList;

import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;

public interface AdoptService {
	int selectAdoptListCount(String type);
	ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType);
}
