package com.petplace.community.service;

import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public interface CommunityService {
	//communityList 관련
	public int selectListCount();
	public ArrayList<Community> selectList(PageInfo pi);
	
	//community insert
	public int insertCommunity(Community c, CommunityAttachment atC);
	
	//community detail
	public Community increaseCount(int communityNo);
}
