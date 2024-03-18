package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.GeneralDAO;
import db.DB;
import entities.Category;

public class CategoryDAOImpl implements GeneralDAO<Category>{
	private List<Category> data;
	private static CategoryDAOImpl instance;
	
	private CategoryDAOImpl() {}

	public static CategoryDAOImpl getInstance() {
		if(instance == null)
			instance = new CategoryDAOImpl();
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Category> get() {
		data = new ArrayList<Category>();
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
			}
			
			data.sort((a, b) -> a.getName().compareTo(b.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Category> getByName(String name) {
		data = new ArrayList<Category>();
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Category WHERE Name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Category findId(Object id) {
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Category WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public boolean add(Category entity) {
		boolean kq = false;
		try {
			conn = DB.getConnection();
			String sql = "INSERT INTO Category(Id, Name, Status) VALUES (?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			pstmt.setString(2, entity.getName());
			pstmt.setBoolean(3, entity.isStatus());
			
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}


	@Override
	public boolean edit(Category entity) {
		boolean kq = false;
		try {
			conn = DB.getConnection();
			String sql = "UPDATE Category SET Name=?, Status=? WHERE Id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setBoolean(2, entity.isStatus());
			pstmt.setInt(3, entity.getId());
			
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean remove(Category entity) {
		boolean kq = false;
		try {
			String sql = "DELETE FROM Category WHERE Id = ?";
			conn = DB.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			System.out.println("Không thể xóa danh mục!");
		}
		
		return kq;
	}

}
