package HW4_phonebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class Page {

	private char pageLetter;
	private Line l = new Line();

	public void setPageLetter(char pl) {
		String pl1 = String.valueOf(pl);
		String letters = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		if (letters.contains(pl1.toLowerCase()))
			pageLetter = pl;

	}

	public char getPageLetter() {
		return pageLetter;
	}

	public void setLine(Line l) {
		if (l != null) {
			l.setName(l.getName());
			l.setTell(l.getTell());
			l.setAddress(l.getAddress());
			l.setLetter();
		}
	}

	public Line getLine() {
		return l;
	}

	public void insertLine(String name, long tell, String address) throws SQLException {// inserting a new line to a specific page
		JDBC conn = new JDBC();
		conn.createConnection();
		JDBC con = new JDBC();
		con.createConnection();
		JDBC co = new JDBC();
		co.createConnection();
		ResultSet rss = conn.stmt.executeQuery("select count(*) from line where lineLetter='" + name.charAt(0) + "';");
		while (rss.next()) {
			if (rss.getInt(1) > 50) {
				System.out.println("the page is full and you can not insert anymore!");
				break;
			} else if (rss.getInt(1) == 0) {
				setPageLetter(name.charAt(0));
				l.setName(name);
				l.setAddress(address);
				l.setTell(tell);
				l.setLetter();
				int row = con.stmt
						.executeUpdate(MessageFormat.format("insert into line values (''{0}'',{1},''{2}'',''{3}'');",
								l.getName(), l.getTell(), l.getAddress(), l.getLetter()));
				System.out.println("Done! rows affected= " + row);
				break;
			} else {
				l.setName(name);
				l.setAddress(address);
				l.setTell(tell);
				l.setLetter();
				int row = co.stmt.executeUpdate(
						MessageFormat.format("insert into line values" + "(''{0}'',{1},''{2}'',''{3}'');", l.getName(),
								l.getTell(), l.getAddress(), l.getLetter()));
				System.out.println("Done! rows affected= " + row);
				break;
			}
		}
	}

	public void deleteLine(String name) throws SQLException {//delete line from a specific page
		JDBC conn = new JDBC();
		conn.createConnection();
		ResultSet rs = conn.stmt.executeQuery("select count(*) from line where lineLetter='" + name.charAt(0) + "';");
		while (rs.next())
			if (rs.getInt(1) == 0) {
				System.out.println("the page is empty or there was'nt any entry with this name!");
				break;
			} else {
				int rows = conn.stmt.executeUpdate("delete from line where name='" + name + "';");
				if (rows == 1)
					System.out.println("Done!");
				break;
			}
	}
}
