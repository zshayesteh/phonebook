package HW4_phonebook;

import java.sql.SQLException;
import java.util.Scanner;

public class MainPhonebook {

	public static void main(String[] args) throws SQLException {
		menu();
	}

	public static void menu() throws SQLException {// menu method will show to the user
		String letters = "abcdefghijklmnopqrstuvwxyz";
		Phonebook pb = new Phonebook();
		Page[] p = new Page[26];
		for (int i = 0; i < 26; i++) {
			p[i] = new Page();
			p[i].setPageLetter(letters.charAt(i));
		}
		System.out.println("\n \n select your desire action from these items: " + "\n 1-->insert a new entry. "
				+ "\n 2-->delete an entry." + "\n 3-->search phonebook by a specific name."
				+ "\n 4-->search phonebook by a specific telephone number." + "\n 6-->Exit! ");
		Scanner inputString = new Scanner(System.in);
		Scanner inputLine = new Scanner(System.in);
		Scanner inputlong = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		switch (n) {
		case (1):
			System.out.println("enter a new name(String): ");
			String name = inputLine.nextLine();
			name = name.toLowerCase();
			System.out.println("enter a new tell(long): ");
			long tell = inputlong.nextLong();
			System.out.println("enter a new address(Line): ");
			String address = inputLine.nextLine();
			if (letters.contains(String.valueOf(name.charAt(0)))) {
				p[letters.indexOf(name.charAt(0))].insertLine(name, tell, address);
			} else
				System.out.println("error! you didnt enter a valid name!");
			menu();
			break;
		case (2):
			System.out.println("enter the name you wanna delete it: ");
			String nam = inputLine.nextLine();
			if (letters.contains(String.valueOf(nam.charAt(0)))) {
				p[letters.indexOf(nam.charAt(0))].deleteLine(nam);
			} else
				System.out.println("error! you didnt enter a valid name!");
			menu();
			break;
		case (3):
			System.out.println("enter the name you are searching for: ");
			String na = inputLine.nextLine();
			if (letters.contains(String.valueOf(na.charAt(0)))) {
				pb.searchByName(na);
			} else
				System.out.println("error! you didnt enter a valid name!");
			menu();
			break;
		case (4):
			System.out.println("enter the tell you are searching for: ");
			long tel = inputlong.nextLong();
			pb.searchByTell(tel);
			menu();
			break;
		case (5):
			System.exit(0);
			break;
		default:
			System.out.println("pay attention to the numbers of menu and choose one of that numbers!");
			menu();
			break;
		}
		input.close();
		inputLine.close();
		inputlong.close();
		inputString.close();
	}

}
