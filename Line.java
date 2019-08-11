package HW4_phonebook;

public class Line {
	private String name;
	private long tell;
	private String address;
	private char letter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name;
	}

	public long getTell() {
		return tell;
	}

	public void setTell(long tell) {
		this.tell = tell;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null)
			this.address = address;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter() {
		letter = getName().charAt(0);
	}
}
