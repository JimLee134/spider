package com.zuoye.spider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class StockDao {
	private Connection connection = null;
	private PreparedStatement ps = null;
	private String dbDriver = "com.mysql.jdbc.Driver"; // ���ݿ�����
	private String url = "jdbc:mysql://localhost:3306/stock"; // URL��ַ

	public  StockDao() {
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			connection = DriverManager.getConnection(url, "root", "wjli14"); // �������ݿ�
		} catch (Exception ex) {
			System.out.println("connection fail!");
		}
	}
	
	public void insertStock(Stock stock) {
		try {
			ps = connection.prepareStatement("insert into Stock(Code,Name,PreviousClose,PERation,Close,High,Low,Amount,Volume,ChangePersent,Flag,TBMMType,MarketValue,Open,tb_Change) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, stock.getCode());
			ps.setString(2, stock.getName());
			ps.setString(3, stock.getPreviousClose());
			ps.setString(4, stock.getPERation());
			ps.setString(5, stock.getClose());
			ps.setString(6, stock.getHigh());
			ps.setString(7, stock.getLow());
			ps.setString(8, stock.getAmount());
			ps.setString(9, stock.getVolume());
			/*ps.setString(10, stock.getChange());*/
			ps.setString(10, stock.getChangePersent());
			ps.setString(11, stock.getFlag());
			ps.setString(12, stock.getTBMMType());
			ps.setString(13, stock.getMarketValue());
			ps.setString(14, stock.getOpen());
			ps.setString(15, stock.getChange());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* ����һ���û���ɾ��һ������ */
	public void deleteStock(Stock stock) {
		try {
			ps = connection
					.prepareStatement("delete from Stock where Code=?");
			ps.setString(1, stock.getCode());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* �����˺����ֲ���һ�����ݣ�����һ��User���� */
	public Stock selectStockByCode(String code) {
		Stock result = null;
		result = new Stock();
		try {
			ps = connection.prepareStatement("select * from Stock where Code=?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.setCode(rs.getString(2));
				result.setName(rs.getString(3));
				result.setPreviousClose(rs.getString(3));
				result.setPERation(rs.getString(4));
				result.setClose(rs.getString(5));
				result.setHigh(rs.getString(6));
				result.setLow(rs.getString(7));
				result.setAmount(rs.getString(8));
				result.setVolume(rs.getString(9));
				result.setChange(rs.getString(10));
				result.setChangePersent(rs.getString(11));
				result.setFlag(rs.getString(12));
				result.setTBMMType(rs.getString(13));
				result.setMarketValue(rs.getString(14));
				result.setOpen(rs.getString(15));
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args){
		Stock s = new Stock();
		s.setCode("1");
		StockDao sd = new StockDao();
		sd.insertStock(s);
	}
}