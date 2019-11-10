package com.bdi.board3.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.board3.common.DBCon;
import com.bdi.board3.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private static Connection con = DBCon.getCon();
	private PreparedStatement ps;
	private ResultSet rs;

	public static void main(String[] args) { // 찍어보기
		UserDAO udao = new UserDAOImpl();
		Map<String, String> user = new HashMap<>();
		user.put("uiId", "test");
		user.put("uiPwd", "test22");
		udao.selectUser(user);
		System.out.println(user);
	}

	@Override
	public Map<String, String> selectUser(Map<String, String> user) {

		try {

			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			if (rs.next()) {
				user.put("uiNum", rs.getString("ui_num"));
				user.put("uiName", rs.getString("ui_name"));
				user.put("credat", rs.getString("credat"));
				user.put("cretim", rs.getString("cretim"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public Map<String, String> insertUser(Map<String, String> user) {
		try {
			String sql = "insert into user_info(UI_NUM, UI_NAME, UI_ID, UI_PWD, CREDAT, CRETIM, MODAT, MODTIM) ";
			sql += " values (seq_ui_num.nextval, ?, ?, ?, to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'), to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'))";

			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiName"));
			ps.setString(2, user.get("uiId"));
			ps.setString(3, user.get("uiPwd"));

			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println(user);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> user) {
		// TODO Auto-generated method stub
		return null;
	}

}
