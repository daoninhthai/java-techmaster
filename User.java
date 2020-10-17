public class User extends Account{
    private String name;
    private String cmt;
    


    public User(){

    }
    public User(long account_number, String account_name, double balance,String username, String password, String name, String cmt) {
        super(account_number, account_name, balance,username, password);
        this.name = name;
        this.cmt = cmt;
    }
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
    public void display(){
        super.display();
        
    }

    
}