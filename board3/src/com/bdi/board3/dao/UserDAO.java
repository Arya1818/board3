package com.bdi.board3.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	public Map<String,String> selectUser(Map<String,String> user);
	public Map<String,String> insertUser(Map<String,String> user);
	public List<Map<String,String>> selectUserList(Map<String,String> user);
}
