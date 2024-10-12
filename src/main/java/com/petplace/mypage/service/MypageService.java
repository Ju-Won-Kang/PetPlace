package com.petplace.mypage.service;

import java.util.ArrayList;

import com.petplace.mypage.model.dto.Petinfo;

public interface MypageService {
	
	
	public abstract Petinfo selectPetinfo(String userId);
	
	
	
}
