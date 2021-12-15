public class ContractorData {

	private String name;
	private String address;
	private int type;
	private double payment;

	public ContractorData(String name, String address, int type, double payment) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.payment = payment;
	}

	public String getName() {return name;}
	public String address() {return address;}
	public int getType() {return type;}
	public double getPayment() {return payment;}

	public void setName(String name) {this.name = name;}
	public void setAddress(String address) {this.address = address;}
	public void setType(int type) {this.type = type;}
	public void setPayment(double payment) {this.payment = payment;}

	public String toString() {
		return "\nName: " + name + "\nAddress: " + address + "\nType: " + type + "\nPayment: RM" + payment;
	}
	
}
