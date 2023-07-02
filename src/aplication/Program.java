package aplication;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(falsee);
			
			
			st= conn.createStatement();
					int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 "
							+ "WHERE "
							+ "DepartmentId=1" );
			int x = 1;
			//if (x<2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 "
					+ "WHERE "
					+ "DepartmentId=2" );
			
			conn.commit();
			
			System.out.println("Linha 1 " + rows1);
			System.out.println("Linha 2 " + rows2);
				
			
			
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transação não concluida, erro causado por "+ e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new DbException("Erro ao tentar voltar a transação,erro causado por "+ e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
