import java.util.Scanner;

/**
 * Account
 */
public class Account {

    private long account_number;
    private String account_name;
    private double balance = 0;//số dư
    private String password;

    Scanner sc = new Scanner(System.in);

    public Account() {

    }

    public Account(long account_number, String account_name, double balance, String password) {
        this.account_number = account_number;
        this.account_name = account_name;
        this.balance = balance;
        this.password = password;
        
    }
    //gửi tiền vào tài khoản
      public void deposit() {
        double amount;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        amount = sc.nextDouble();
        if(amount>=0){
            balance += amount;
        }
        else{
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
    }
    //rút tiền
	public void withdraw() {
        double amount;
        System.out.print("Nhập số tiền bạn cần rút: ");
        amount = sc.nextDouble();
		if(balance >= amount) {
			balance -= amount;		
		}else {
			System.out.println("That amount exceeds your current balance.");
		}
    }
    public void display() {
		System.out.println("Id: " + account_number);
		System.out.println("Name: " + account_name);
		System.out.println("Balance: " + balance);
	}
    





    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  
    

}