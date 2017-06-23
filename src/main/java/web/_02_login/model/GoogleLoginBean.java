package web._02_login.model;

public class GoogleLoginBean {
	String Id;
	String name;
	String pictureUrl;
	String locale;
	String familyName;
	String givenName;
	String Email;
	String userId;
	String userPassword;

	public GoogleLoginBean() {
	}

	public GoogleLoginBean(String id, String name, String pictureUrl, String locale, String familyName,
			String givenName, String email, String userId, String userPassword) {
		super();
		Id = id;
		this.name = name;
		this.pictureUrl = pictureUrl;
		this.locale = locale;
		this.familyName = familyName;
		this.givenName = givenName;
		Email = email;
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
