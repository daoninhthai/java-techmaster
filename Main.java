
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
        Account account1=new Account(131232, "DAO THAI", 100000,"thai1", "123");
        
        
        
       
        int  n = 0;
        long s, d;
        
        boolean flag = true;
        do{
        Account a[] = null;
        System.out.println("Chọn 1 nếu muốn đăng nhập , chọn 2 nếu muốn đăng ký: ");
        int login = sc.nextInt();
        if(login == 1){
             System.out.println("Đăng nhập");
             System.out.println("Tên đăng nhập: ");
             String username = sc.next();
              
             System.out.println("Mật khẩu: ");
             
             String password = sc.next();
            
            //tai khoan quan ly
            if(username.equals("admin")&& password.equals("admin")){
                do {
                    System.out.println("---------------------------------");
                    System.out.println("Bạn chọn làm gì: ");
                    System.out.println("1.Nhập thông tin của các khách hàng\n"
                        + "2.Xuất danh sách thông tin của các khách hàng\n" 
                        + "3.Nạp tiền\n" 
                        + "4.Rút tiền\n"
                        + "0 để thoát\n"
                        +"---------------------------------");
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
                            System.out.printf("Danh sách thông tin khách hàng:");
                            for (int i = 0; i < n; i++) {
                                account1.display();
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
                        case 0:
                            System.out.println("Bye");
                            flag=false;
                            break;
                }
            } while (flag);
        }
        if(username.equals(account1.getUsername())  && password.equals(account1.getPassword())){
            
            do {
                System.out.println("---------------------------------");
                

                System.out.println("Bạn chọn làm gì: ");
                System.out.println(
                    "---------------------------------\n"
                    +"1.Xem thông tin tài khoản\n"
                    + "2.Nạp tiền\n" 
                    + "3.Rút tiền\n"
                    + "0 để thoát\n"
                    +"---------------------------------");
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
                    case 0:
                        System.out.println("Bye");
                        flag=false;
                        break;
                    
                    default:
                        System.out.println("Không có số này");
                        break;
                        
                }
            } while (flag);
        }
        else{
            System.out.println("Sai tài khoản , mời chọn lại !");
            
        }

        }
        
        if(login == 2){
            User user = new User();
            System.out.println("Đăng ký tài khoản");
            System.out.println("---------------------------------");
            System.out.println("Nhập tên đăng nhập: ");
            String username = sc.next();
            System.out.println("Nhập tên tài khoản: ");
            String Account_Name=sc.next();
            user.setAccount_name(Account_Name);
            System.out.println("Nhập mật khẩu: ");
            String password =sc.next();
            System.out.println("---------------------------------");
            if(!" ".equals(username) && !" ".equals(password) && !" ".equals(Account_Name)){
                do {
                    System.out.println("---------------------------------");
                    
    
                    System.out.println("Bạn muốn gì "+username+": ");
                    System.out.println(
                        "---------------------------------\n"
                        +"1.Xem thông tin tài khoản\n"
                        + "2.Nạp tiền\n" 
                        + "3.Rút tiền\n"
                        + "0 để thoát\n"
                        +"---------------------------------");
                    int choice =sc.nextInt();
                    switch (choice) {
                        
                        case 1:        
                            user.display();
                            break;
                        case 2:
                            System.out.println("Nạp tiền: ");
                            user.deposit();
                            break;
                        case 3:
                            System.out.println("Rút tiền: ");
                            user.withdraw();
                        break;
                        case 0:
                            System.out.println("Bye");
                            flag=false;
                            break;
                        
                        default:
                            System.out.println("Không có số này");
                            break;
                            
                    }
                } while (flag);
            }
            else{
                System.out.println("f");
            }
        }
        } while (flag);     
       }
        
    }
