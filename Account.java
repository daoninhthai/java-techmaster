import java.util.ArrayList;
import java.util.Scanner;

/**
 * Account
 */
public class Account {

    private long account_number;
    private String account_name;
    private double balance = 0;//số dư
    private String username;
    private String password;
    // ArrayList<User> users;
    
    
    // public void setUsers() {
    //     users.add(new User(String.valueOf(users.size() + 1), "DAO THAI", 100000,"thai1", "123"));
    // }





    Scanner sc = new Scanner(System.in);

    public Account() {

    }

    public Account(long account_number, String account_name, double balance,String username, String password) {
        this.account_number = account_number;
        this.account_name = account_name;
        this.balance = balance;
        this.password = password;
        this.username = username;
        
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
			System.out.println("Rút không thành công vì không có đủ tiền trong tài khoản !");
		}
    }
    public void loan(){

    }
    public void display() {
        System.out.println("---------------------------------");
		System.out.println("Id: " + account_number);
		System.out.println("Name: " + account_name);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------------");
	}
    




    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
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