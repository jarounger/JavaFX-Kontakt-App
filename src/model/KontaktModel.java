package model;

public class KontaktModel {
	
	private String vorname;
	private String nachname;
	private String mobile;
	private String email;
	
	public KontaktModel (String vorname, String nachname, String mobile, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.mobile = mobile;
		this.email = email;
	}

	// Getter Setter Methoden
	
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

}
