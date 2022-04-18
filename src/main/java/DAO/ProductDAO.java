package DAO;

import java.util.*;

import BEAN.Product;
import DB.DBConnection;

import java.sql.*;

public class ProductDAO {
	public static List<Product> getAll(){
		List<Product> list = new ArrayList<Product>();
		String sql = "select *from product";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int classify = rs.getInt("classify");
				String picture = rs.getString("picture");
				
				list.add(new Product(id, name, price, classify, picture));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Product> DisplayProduct(int start, int limit){
		List<Product> list = new ArrayList<Product>();
		String sql = "select *from product limit ?, ?";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int classify = rs.getInt("classify");
				String picture = rs.getString("picture");
				
				list.add(new Product(id, name, price, classify, picture));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
		
		public static Product selectProduct(String idd){
			String sql = "select *from product where id = ?";
			Product p = null;
			try {
				Connection conn = DBConnection.CreateConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, idd);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int classify = rs.getInt("classify");
					String picture = rs.getString("picture");
					p = new Product(id, name, price, classify, picture);
				}
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return p;
	}
	
	public static int getCount() {
		int count = 0;
		String sql = "select count(*) from product";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static boolean addProduct(String id, String name, String price, String classify, String picture) {
		boolean kt = false;
		String sql = "insert into product(id, name, price, classify, picture) values (?, ?, ?, ?, ?)";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, classify);
			ps.setString(5, picture);
			
			int rs = ps.executeUpdate();
			if(rs != 0) kt = true;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kt;
	}
	
	public static boolean editProduct(String id, String name, String price, String classify, String picture) {
		boolean kt = false;
		String sql = "update product set name = ?,  price = ?, classify = ?, picture = ? where id = ?";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, classify);
			ps.setString(4, picture);
			ps.setString(5, id);
			
			int rs = ps.executeUpdate();
			if(rs != 0) kt = true;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kt;
	}
	
	public static boolean deleteProduct(String id) {
		boolean kt = false;
		String sql = "delete from product where id = ?";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int rs = ps.executeUpdate();
			if(rs != 0) kt = true;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return kt;
	}
}
