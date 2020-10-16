import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void newAccount(Account acc) {
            System.out.println("Nhập số tài khoản: ");
            acc.setAccount_number(sc.nextInt());
            sc.nextLine();
            System.out.println("Nhập tên tài khoản: ");
            acc.setAccount_name(sc.nextLine());
            acc.setBalance(sc.nextDouble());
        }
    public static void main(String[] args) {
        Account account1=new Account(131232, "DAO THAI", 100000, "123");
        
       
        int  n = 0;
        long s, d;
        
        Account a[] = null;
        System.out.println("Chọn 1 nếu muốn đăng nhập , chọn 2 nếu muốn đăng ký: ");
        int login = sc.nextInt();
        if(login == 1){
             System.out.println("Đăng nhập");
             System.out.println("Tên đăng nhập: ");
             String username = sc.next();
              
             System.out.println("Mật khẩu: ");
             
             int password = sc.nextInt();
            
            //tai khoan quan ly
            if(username == "daoninhthai"&& password == 1){
                System.out.println("nhap");
                
                int choice =sc.nextInt();
                switch (choice) {
                   case 1:
                      System.out.println("Nhập số lượng khách hàng bạn muốn nhập: ");
                        n = sc.nextInt();
                        a = new Account[n];
                        for (int i = 0; i < n; i++) {
                            System.out.println("Khách hàng số: " + (i+1));
                            a[i] = new Account();
                            newAccount(a[i]);
                        }
                        break;
                    case 2:
                        System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                        for (int i = 0; i < n; i++) {
                            a[i].display();
                        }
                        break;
                    case 3:
                        System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
                        s = sc.nextLong();
                        for (int i = 0; i < n; i++) {
                            d = a[i].getAccount_number();
                            if (s == d) {
                                System.out.println("Bạn chọn tài khoản: " + d);
                                a[i].deposit();
                            } else {
                                System.out.println("");
                        }
                    }
                    break;
                    case 4:
                        System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
                        s = sc.nextLong();
                        for (int i = 0; i < n; i++) {
                            d = a[i].getAccount_number();
                            if (s == d) {
                                System.out.println("Bạn chọn tài khoản: " + d);
                                a[i].withdraw();
                            }
                        }
                        break;
            }
        }
        if(username == "daoninhthai" && password == 2){
            int choice =sc.nextInt();
            switch (choice) {
              
                case 1:        
                    account1.display();
                    break;
                case 2:
                    System.out.println("Nạp tiền: ");
                    account1.deposit();
                    break;
                case 3:
                    System.out.println("Rút tiền: ");
                    account1.withdraw();
                break;
            }
        }
        else{
            System.out.println("Sai tài khoản");
            System.out.println(username);
            System.out.println(password);
        }
        }
        if(login == 2){
            System.out.println("Đăng ký tài khoản");

        }









       
       
        
       
       
       }
        
    }
