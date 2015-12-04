package com.dxj.xuer.statistics.common;

import java.sql.*;
import java.util.List;

/**
 * ���ݿ���ʰ�����
 * 
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 * 
 */
public final class DatabaseHelper {
    public final static int BATCH_SIZE=1000;
	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws java.sql.SQLException
	 */
	public final static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(Config.getProperty("mysql.url"),
				Config.getProperty("mysql.username"),
				Config.getProperty("mysql.password"));
	}

	/**
	 * �ر���������
	 * 
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public final static void closeDatabaseComponent(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public final static void persistToDatabase(List<ChartPvUvData> datas) throws SQLException, ClassNotFoundException {
        if(datas==null || datas.isEmpty()){
            return;
        }
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getDatabaseConnection();
			String sql = "insert into page_view(module, code, country, `from`, `schedule`,pv, uv, gmt_create) values(?,?,?,?,?,?,?,now()) on duplicate key update pv =? ,uv =?";
			pstmt = conn.prepareStatement(sql);
            int count=0;
			for (ChartPvUvData data : datas) {
                ChartPvUvData.KeyEntry keyEntry = data.getKeyEntry();
                pstmt.setString(1, data.getModule());
				pstmt.setString(2, keyEntry.linkNode);
				pstmt.setString(3, keyEntry.country);
                pstmt.setString(4, keyEntry.from);
                pstmt.setString(5, data.getDate());
				pstmt.setInt(6, data.getPv());
				pstmt.setInt(7, data.getUv());
				pstmt.setInt(8, data.getPv());
				pstmt.setInt(9, data.getUv());
				pstmt.addBatch();
                count++;
                if(count>=BATCH_SIZE){
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    count=0;
                }
			}
            if(count>0) {
                pstmt.executeBatch();
            }
		} finally {
			closeDatabaseComponent(null, pstmt, conn);
		}
	}

}
