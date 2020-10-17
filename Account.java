
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
    private double debt;

    Scanner sc = new Scanner(System.in);

    public Account() {

    }

    public Account(long account_number, String account_name, double balance,double debt,String username, String password) {
        this.account_number = account_number;
        this.account_name = account_name;
        this.balance = balance;
        this.password = password;
        this.username = username;
        this.debt=debt;
        
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
        double amount;
        System.out.println("Nhập số tiền muốn vay");
        amount =sc.nextDouble();
        if(amount>=0){
            balance += amount;
            setDebt(amount);
            System.out.println("Bạn đã vay "+amount);

        }
        else{
            System.out.println("Số tiền nhập vào không hợp lệ!");
        }
        

    }
    public void pay(){
       
        if(debt<=0){
            System.out.println("Bạn không nợ");
        }
        if(balance < debt && debt>0){
            System.out.println("Tài khoản không đủ để trả nợ");
        }
        if(balance>=debt && debt>0){
            balance -= debt;
            System.out.println("Đã trả nợ ");
            setDebt(0);
        }
       

    }
    public void display() {
        System.out.println("---------------------------------");
        System.out.println("::THÔNG TIN TÀI KHOẢN::");
		System.out.println("Id: " + account_number);
		System.out.println("Name: " + account_name);
        System.out.println("Balance: " + balance);
        System.out.println("Debt: " + debt);
        System.out.println("---------------------------------");
	}
    



    public void setDebt(double debt) {
        this.debt = debt;
    }
    public double getDebt() {
        return debt;
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