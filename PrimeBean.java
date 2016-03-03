package beans;

public class PrimeBean {
	private int number;
	private String message="";
	
	// number  property
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
		for(int i = 2; i <= number/2; i ++)
		{
			if ( number % i == 0 )
			{
				message = "Not a prime number!";
				return; 
			}
		}
		message = "Prime number!";
	}
	
	// message property
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
