package com.bdi.board3.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.board3.common.DBCon;
import com.bdi.board3.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private Connection con = DBCon.getCon();
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		
		try {
			String sql = "select * from board_info bi, user_info ui ";
			sql += " where bi.ui_num=ui.ui_num ";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Map<String,String>> list = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> b = new HashMap<>();
				b.put("biNum",rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("uiName", rs.getString("ui_name"));
				b.put("uiId", rs.getString("ui_id"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				list.add(b);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		
		try {
			String sql = "select * from board_info bi, user_info ui ";
			sql += " where bi.ui_num=ui.ui_num ";
			sql += " and bi_num=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("uiName", rs.getString("ui_name"));
				b.put("biContent", rs.getString("bi_content"));
				b.put("uiId", rs.getString("ui_id"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int insertBoard(Map<String, String> board) {
		try {
			String sql = "insert into board_info(BI_NUM, BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, MODAT, MODTIM)";
			sql += " values(seq_bi_num.nextval,?,?,?, to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'))";

			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));
			
			
			
			return ps.executeUpdate();


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
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

}
