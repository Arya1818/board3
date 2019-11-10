package com.bdi.board3.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public Map<String,String> doLogin(String uiId, String uiPwd);
	public Map<String,String> doSignup(String uiName, String uiId, String uiPwd);
	public List<Map<String,String>> getUserList(Map<String,String> user);

}
