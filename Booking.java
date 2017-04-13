public class Booking {
	private String name;
	private String phoneNO;
	private String address;
	private String eMail;
	private String creditNO;
	
	public Booking(String name, String phoneNO, String address, String eMail, String creditNO) {
		super();
		this.name = name;
		this.phoneNO = phoneNO;
		this.address = address;
		this.eMail = eMail;
		this.creditNO = creditNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNO() {
		return phoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCreditNO() {
		return creditNO;
	}
	public void setCreditNO(String creditNO) {
		this.creditNO = creditNO;
	}
	

}