package HW4_phonebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class Phonebook {
	private int phonebookID;
	private Page p = new Page();

	public void setPhonebookID(int id) {
		phonebookID = id;
	}

	public int getPhonebookID() {
		return phonebookID;
	}

	public void setP(Page p) {
		if (p != null) {
			this.p.setPageLetter(p.getPageLetter());
			this.p.setLine(p.getLine());
		}
	}

	public Page getPage() {
		return p;
	}

	public void searchByName(String name) throws SQLException {// this method will search the phonebook by specific name
		boolean flag = false;
		JDBC conn = new JDBC();
		conn.createConnection();
		ResultSet rs = conn.stmt.executeQuery(MessageFormat.format("select * from line where name=''{0}'';", name));
		while (rs.next()) {
			System.out.println("name \t \t tell \t \t address");
			String Pname = rs.getString(1);
			long Ptell = rs.getLong(2);
			String Paddress = rs.getString(3);
			System.out.println(Pname + "\t" + Ptell + "\t \t" + Paddress);
			flag = true;
		}
		if (flag == false)
			System.out.println("name didnt found!");
	}

	public void searchByTell(long tell) throws SQLException {//this method will search the phonebook by specific tell
		boolean flag = false;
		JDBC conn = new JDBC();
		conn.createConnection();
		ResultSet rs = conn.stmt.executeQuery("select * from line where tell=" + tell + ";");
		while (rs.next()) {
			System.out.println("name \t \t tell \t \t address");
			String Pname = rs.getString(1);
			long Ptell = rs.getLong(2);
			String Paddress = rs.getString(3);
			System.out.println(Pname + "\t" + Ptell + "\t \t" + Paddress);
			flag = true;
		}
		if (flag == false)
			System.out.println("tell didnt found!");
	}
}