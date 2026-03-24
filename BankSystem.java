import java.util.*;

// Customer Class
class Customer {
    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private String email;

    // Constructor
    Customer(int accountNumber, String name, double balance, String accountType, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }

    // Getters & Setters
    public int getAccountNumber() {
         return accountNumber;
         }
    public String getName() { 
        return name;
     }
    public double getBalance() {
         return balance;
         }
    public String getAccountType() { 
        return accountType;
     }
    public String getEmail() { 
        return email; 
    }

    public void setBalance(double balance) { 
        this.balance = balance;
     }

    public void display() {
        System.out.println("Acc No: " + accountNumber + ", Name: " + name +
                ", Balance: " + balance + ", Type: " + accountType + ", Email: " + email);
    }
}


public class BankSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> list = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Create\n2.Deposit\n3.Withdraw\n4.Balance\n5.Transfer\n6.Search\n7.Display All\n8.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: enquiry(); break;
                case 5: transfer(); break;
                case 6: search(); break;
                case 7: displayAll(); break;
                case 8: System.out.println("Exit"); break;
                default: System.out.println("Invalid");
            }
        } while (choice != 8);
    }

    
    public static void createAccount() {
        System.out.print("AccNo Name Balance Type Email: ");
        int acc = sc.nextInt();
        String name = sc.next();
        double bal = sc.nextDouble();
        String type = sc.next();
        String email = sc.next();

        list.add(new Customer(acc, name, bal, type, email));
    }

    
    public static Customer find(int acc) {
        for (Customer c : list) {
            if (c.getAccountNumber() == acc)
                return c;
        }
        return null;
    }

    
    public static void deposit() {
        System.out.print("Enter AccNo & Amount: ");
        int acc = sc.nextInt();
        double amt = sc.nextDouble();

        Customer c = find(acc);
        if (c != null) {
            c.setBalance(c.getBalance() + amt);
            System.out.println("Deposited");
        } else System.out.println("Not found");
    }

    
    public static void withdraw() {
        System.out.print("Enter AccNo & Amount: ");
        int acc = sc.nextInt();
        double amt = sc.nextDouble();

        Customer c = find(acc);
        if (c != null && c.getBalance() >= amt) {
            c.setBalance(c.getBalance() - amt);
            System.out.println("Withdrawn");
        } else System.out.println("Insufficient / Not found");
    }


    public static void enquiry() {
        System.out.print("Enter AccNo: ");
        int acc = sc.nextInt();

        Customer c = find(acc);
        if (c != null)
            System.out.println("Balance: " + c.getBalance());
        else System.out.println("Not found");
    }

    
    public static void transfer() {
        System.out.print("From AccNo To AccNo Amount: ");
        int from = sc.nextInt();
        int to = sc.nextInt();
        double amt = sc.nextDouble();

        Customer c1 = find(from);
        Customer c2 = find(to);

        if (c1 != null && c2 != null && c1.getBalance() >= amt) {
            c1.setBalance(c1.getBalance() - amt);
            c2.setBalance(c2.getBalance() + amt);
            System.out.println("Transferred");
        } else System.out.println("Transfer failed");
    }

    
    public static void search() {
        System.out.print("Enter AccNo: ");
        int acc = sc.nextInt();

        Customer c = find(acc);
        if (c != null) c.display();
        else System.out.println("Not found");
    }

    
    public static void displayAll() {
        for (Customer c : list) {
            c.display();
        }
    }
}