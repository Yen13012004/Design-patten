package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.GeneralDAO;
import db.DB;
import entities.Category;
import entities.Product;

public class ProductDAOImpl implements GeneralDAO<Product>{
	
	private List<Product> data;
	private static ProductDAOImpl instance;
	
	private ProductDAOImpl() {}

	public static ProductDAOImpl getInstance() {
		if(instance == null)
			instance = new ProductDAOImpl();
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override	
	public List<Product> get() {
		data = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Product> getByName(String name) {
		data = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Product WHERE Name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new  Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Product findId(Object id) {
		try {
			conn = DB.getConnection();
			String sql = "SELECT * FROM Product WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return new  Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getBoolean(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product entity) {
		boolean kq = false;
		try {
			conn = DB.getConnection();
			String sql = "INSERT INTO Product(Id, Name, Price, Category_id, Status) VALUES (?, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getId());
			pstmt.setString(2, entity.getName());
			pstmt.setDouble(3,  entity.getPrice());
			pstmt.setInt(4,  entity.getCategory_id());
			pstmt.setBoolean(5, entity.isStatus());
			
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
			
		} catch (Exception e) {
				System.out.println("Mã danh mục không tồn tại");
		}
		return kq;
	}

	@Override
	public boolean edit( Product entity) {
		boolean kq = false;
		try {
			conn = DB.getConnection();
			String sql = "UPDATE Product SET Name=?, Price=?, Category_id=?, Status=? WHERE Id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setDouble(2,  entity.getPrice());
			pstmt.setInt(3,  entity.getCategory_id());
			pstmt.setBoolean(4, entity.isStatus());
			pstmt.setString(5, entity.getId());
			
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean remove(Product entity) {
		boolean kq = false;
		try {
			String sql = "DELETE FROM Product WHERE Id = ?";
			conn = DB.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getId());
			int i = pstmt.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	/*
	 * public List<Product> getByCategoryId(int id) { data = new
	 * ArrayList<Product>(); try { conn = DB.getConnection(); String sql =
	 * "SELECT * FROM Product WHERE Id = ?"; pstmt = conn.prepareStatement(sql);
	 * pstmt.setInt(1, id); rs = pstmt.executeQuery(); while (rs.next()) {
	 * data.add(new Product(rs.getString(1), rs.getString(2), rs.getDouble(3),
	 * rs.getInt(4), rs.getBoolean(5))); } } catch (Exception e) {
	 * e.printStackTrace(); } return data; }
	 */
}
