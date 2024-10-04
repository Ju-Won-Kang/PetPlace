package com.petplace.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.common.PageInfo;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public interface CommunityService {
	//communityList 관련
	public int selectListCount(); //category -> 전체
	public int selectListCount(String category); //category -> 개 | 고양이 | 기타
	public ArrayList<Community> selectList(PageInfo pi); //category -> 전체
	public ArrayList<Community> selectList(PageInfo pi, String category); //category -> 개 | 고양이 | 기타
	
	//search관련
	public int selectSearchCount(String keyword);
	public int selectSearchCount(HashMap<String, String> map);
	public ArrayList<Community> selectSearchList(PageInfo pi, String keyword);
	public ArrayList<Community> selectSearchList(PageInfo pi, HashMap<String, String> map);
	
	//community insert
	public int insertCommunity(Community c, CommunityAttachment atC);
	
	//community detail
	public Community increaseCount(int communityNo);
	public CommunityAttachment selectCommunityAt(int communityNo);
	
	//update
	public Community selectCommunity(int communityNo);
	
	//delete
	public int deleteCommunity(int communityNo);
	public int deleteCommunityAt(int communityNo);
	
}
