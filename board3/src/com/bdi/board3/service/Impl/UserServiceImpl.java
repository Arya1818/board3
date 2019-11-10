package com.bdi.board3.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.board3.dao.Impl.UserDAOImpl;
import com.bdi.board3.service.UserService;

public class UserServiceImpl implements UserService {

	UserDAOImpl udao = new UserDAOImpl();

	@Override
	public Map<String, String> doLogin(String uiId, String uiPwd) {
		Map<String, String> user = new HashMap<>();
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return udao.selectUser(user);
	}

	@Override
	public Map<String, String> doSignup(String uiName, String uiId, String uiPwd) {
		Map<String, String> user = new HashMap<>();
		user.put("uiName", uiName);
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return udao.insertUser(user);
	}

	@Override
	public List<Map<String, String>> getUserList(Map<String, String> user) {
		// TODO Auto-generated method stub
		return null;
	}

}
