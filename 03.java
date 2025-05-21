class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public String toString() {
        return "Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}


class Bank {
    private BankAccount[] accounts = new BankAccount[5];
    private int count = 0;

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        } else {
            System.out.println("Bank is full.");
        }
    }

    public void withdrawFromAccount(int accNo, double amount) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i]);
        }
    }
}
class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();

    
        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        
        bank.withdrawFromAccount(1001, 6000.0);

        
        bank.withdrawFromAccount(1002, 1000.0);

        
        bank.displayAll();
    }
}
