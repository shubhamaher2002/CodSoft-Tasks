import javax.swing.*;

class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private String accountNumber;

    public ATM(BankAccount account) {
        this.account = account;
        this.accountNumber = JOptionPane.showInputDialog("Enter account number:");
        JFrame frame = new JFrame("ATM Screen");

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JLabel balanceLabel = new JLabel("Balance: " + account.getBalance());

        withdrawButton.setBounds(100, 50, 150, 50);
        depositButton.setBounds(100, 120, 150, 50);
        checkBalanceButton.setBounds(100, 190, 150, 50);
        balanceLabel.setBounds(100, 260, 150, 50);

        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw:"));
            account.withdraw(amount);
            balanceLabel.setText("Balance: " + account.getBalance());
        });

        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to deposit:"));
            account.deposit(amount);
            balanceLabel.setText("Balance: " + account.getBalance());
        });

        checkBalanceButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Balance: " + account.getBalance());
        });

        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(checkBalanceButton);
        frame.add(balanceLabel);

        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ATM atm = new ATM(account);
    }
}
