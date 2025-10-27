package playground.leetcode;

public class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;

        if (!isValid(account1)) {
            return false;
        }
        if (!isValid(account2)) {
            return false;
        }
        if (balance[account1] < money) {
            return false;
        }
        balance[account1]-=money;
        balance[account2]+=money;
        return true;
    }

    private boolean isValid(int account1) {
        return account1 >= 0 && account1 < balance.length;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (!isValid(account)) {
            return false;
        }
        balance[account]+=money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (!isValid(account)) {
            return false;
        }
        if (balance[account] < money) {
            return false;
        }
        balance[account]-=money;
        return true;
    }
}
