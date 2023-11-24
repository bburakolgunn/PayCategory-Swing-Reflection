package PayCategory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			
			String db = "jdbc:postgresql://localhost:5432/Payment";
			
			
			Connection conn = DriverManager.getConnection(db, "postgres", "Sifre");
			System.out.println("veritabanına aslında bağlanıldı");
			String sorgu = "SELECT * FROM PaymentSystem ";
			
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
		
			
			while(rs.next())
			{
				System.out.println("Ödeme tipi : " +
				rs.getString("payments") + " - "+ " Miktarı :  " +rs.getString("price"));
			}
			
		}
		catch(Exception ex)
		{
			System.out.print("Sistemsel bir hata oluştu");
		}
		
		
	}

}
