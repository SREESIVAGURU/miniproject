import java.util.*;
class Main{
    static Scanner scan = new Scanner(System.in);
    static String u_name= "sivaguru";
    static int u_pass=1234;
    static int trail=3;
    static int total=0;
    static int flag=1;
    static int balance=1000;
    static HashMap<Integer,Integer>history = new HashMap<Integer,Integer>();
    static HashMap<Integer,Integer>atm_amount = new HashMap<Integer,Integer>();
    static HashMap<Integer,Integer>user_deno = new HashMap<Integer,Integer>();
    public static void withdraw(){
        System.out.println("Enter the amount to be withdrawn : ");
        int w_amount=scan.nextInt();
        if(w_amount<=balance){
            if(w_amount<=total){
                
                int temp=w_amount;
                user_deno.put(2000,0);
                user_deno.put(500,0);
                user_deno.put(200,0);
                user_deno.put(100,0);
                while(temp!=0){
                    if(temp>=2000 && atm_amount.get(2000)!=0){
                        temp-=2000;
                        balance-=2000;
                        total-=2000;
                        user_deno.put(2000,user_deno.get(2000)+1);
                        atm_amount.replace(2000,atm_amount.get(2000)-1);
                    }
                    else if(temp>=500 && atm_amount.get(500)!=0 && total!=0){
                        temp-=500;
                        balance-=500;
                        total-=500;
                        user_deno.put(500,user_deno.get(500)+1);
                        atm_amount.replace(500,atm_amount.get(500)-1);
                    }
                    else if(temp>=200 && atm_amount.get(200)!=0 && total!=0){
                        temp-=200;
                        balance-=200;
                        total-=200;
                        user_deno.put(200,user_deno.get(200)+1);
                        atm_amount.replace(200,atm_amount.get(200)-1);
                    }
                    else if(temp>=100 && atm_amount.get(100)!=0 && total!=0){
                        temp-=100;
                        balance-=100;
                        total-=100;
                        user_deno.put(100,user_deno.get(100)+1);
                        atm_amount.replace(100,atm_amount.get(100)-1);
                    }
                }
                history.put(w_amount,balance);
                System.out.println("Please collect the amount :"+ w_amount);
            }
            else{
                System.out.println("Insufficient balance in ATM \n Please try nearby ATM ");
            }
        }
        else{
            System.out.println("Insufficient balance\nYou can only take :"+balance);
        }
    }
    public static void pin_change(){
        while(true){
            System.out.println("Enter the new pin");
            int new_pin=scan.nextInt();
            if(new_pin==u_pass){
                System.out.println("Already exist ");
            }
            else{
                u_pass=new_pin;
                System.out.println("password changed successfully");
                break;
            }
        }
    }
    public static void user_work(){
        while(true){
            System.out.println("Withdraw  ->1\nBalance   ->2\nchange_pin->3\nhistory   ->4\nExit      ->5");
            int x = scan.nextInt();
            if(x==1){
                withdraw();
            }
            else if(x==2){
                System.out.println("Your balance is : "+balance);
            }
            else if(x==3){
                pin_change();
                break;
            }
            else if(x==4){
                for(Map.Entry j : history.entrySet()){
                    System.out.println("withdrawn amount:"+j.getKey()+"\navailable_balance"+j.getValue());
                }
            }
            else if(x==5){
                break;
            }
        }
    }
    public static void user(){
        while(trail!=0){
            scan.nextLine();
            System.out.println("Enter your user_name :");
            String user_name = scan.nextLine();
            System.out.println("Enter your password :");
            int pass = scan.nextInt();
            if(user_name.equals(u_name) && pass==u_pass){
                System.out.print("\033[H\033[2J");
                System.out.println("Welcome "+user_name);
                user_work();
                break;
            }
            else{
                trail-=1;
                if(trail==0){
                    System.out.println("You have no trails");
                    break;
                }
                else{
                    System.out.println("You have only "+trail +" trails");
                }
            }
        }
    }
    public static void deposit(){
        while(true){
            System.out.println("Enter no of 2000 to be deposited");
            int n=scan.nextInt();
            total+=2000*n;
            atm_amount.put(2000,atm_amount.get(2000)+n);
        
            System.out.println("Enter no of 500 to be deposited");
            int m = scan.nextInt();
            total+=500*m;
            atm_amount.put(500,atm_amount.get(500)+m);
        
            System.out.println("Enter no of 200 to be deposited");
            int o = scan.nextInt();
            total+=200*o;
            atm_amount.put(200,atm_amount.get(200)+o);
        
            System.out.println("Enter no of 100 to be deposited");
            int p = scan.nextInt();
            total+=100*p;
            atm_amount.put(100,atm_amount.get(100)+p);
        
            System.out.println("Amount added Successfully");
            break;
        }
    }
    public static void admin(){
        while(true){
            System.out.println("Deposit->1 \nBalance->2 \nExit   ->3");
            int n = scan.nextInt();
            if(n==1){
                deposit();
            }
            else if(n==2){
                for(Map.Entry i : atm_amount.entrySet()){
                    System.out.println(i.getKey()+":"+i.getValue());
                }
                System.out.println("Total : "+total);
            }
            else if(n==3){
                break;
            }
            else{
                System.out.println("Enter no from 1-3 to proceed");
            }
            
        }
    }
    public static void main(String[] args){
        history.put(0,balance);
        atm_amount.put(2000,0);
        atm_amount.put(500,0);
        atm_amount.put(200,0);
        atm_amount.put(100,0);
        while(true){
            System.out.println("-----Welcome to canara bank-----");
            System.out.println("Admin ->1 \nUser  ->2 \nExit  ->3");
            int n = scan.nextInt();
            if(n==1){
                System.out.println("Enter your id : ");
                scan.nextLine();
                String user_name = scan.nextLine();
                System.out.println("Enter your password : ");
                int password = scan.nextInt();
                if(user_name.equals("admin") && password==4321){
                    System.out.print("\033[H\033[2J");
                    System.out.println("Welcome admin");
                    admin();
                }
                else{
                    System.out.println("The entered id or password is wrong");
                }
            }
            else if(n==2){
                user();
            }
            else if(n==3){
                break;
            }
            else{
                System.out.println("Please enter the number between 1 - 3");
            }
        }
    }
}