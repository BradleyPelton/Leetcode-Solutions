package contests.contests2021.lc1016.mediumone;

// Accepted after second attempt
// Forgot the extra conditional check in the transfer method
// Trivial medium

class Bank {
    long[] bal;

    public Bank(long[] balance) {
        bal = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isValidTransaction(account1, money) && isValidTransaction(account2, Long.MIN_VALUE)) {
            bal[account1 - 1] -= money;
            bal[account2 - 1] += money;
            return true;
        } else {
            return false;
        }

    }

    public boolean deposit(int account, long money) {
        if (isValidTransaction(account, Long.MIN_VALUE)) {
            bal[account - 1] += money;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(int account, long money) {
        if (isValidTransaction(account, money)) {
            bal[account - 1] -= money;
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidTransaction(int accountNumber, long requiredMoney) {
        if (!(accountNumber >= 1 && accountNumber <= bal.length)) {
            return false;
        }

        if (bal[accountNumber - 1] < requiredMoney) {
            return false;
        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3,10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }

}
/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */