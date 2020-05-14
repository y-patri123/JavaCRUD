package beans;

public class User {
	private int userid;
	private String userpwd;
	private int tel;
	private String email;
	private String Ville;
	private String matricule;
	
	public User() {
		super();
	}

	public User(String email, String matricule) {
		super();
		
		this.email = email;
		this.matricule = matricule;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ville == null) ? 0 : Ville.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + tel;
		result = prime * result + userid;
		result = prime * result + ((userpwd == null) ? 0 : userpwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Ville == null) {
			if (other.Ville != null)
				return false;
		} else if (!Ville.equals(other.Ville))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (tel != other.tel)
			return false;
		if (userid != other.userid)
			return false;
		if (userpwd == null) {
			if (other.userpwd != null)
				return false;
		} else if (!userpwd.equals(other.userpwd))
			return false;
		return true;
	}
	
	
	
	
}
