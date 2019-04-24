public class BankAccount {

    private Status status = Status.CLOSE;
    private int balance = 0;

    public void open() {
        this.status = Status.OPEN;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (status.equals(Status.CLOSE))
            throw new BankAccountActionInvalidException("Account closed");

        int currentBalance;

        synchronized (this) {
            currentBalance = this.balance;
        }

        return currentBalance;
    }

    public void deposit(int amount) throws BankAccountActionInvalidException {
        if (amount < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (status.equals(Status.CLOSE))
            throw new BankAccountActionInvalidException("Account closed");

        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(int amount) throws BankAccountActionInvalidException {
        if (balance == 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if (balance < amount)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        if (amount < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (status.equals(Status.CLOSE))
            throw new BankAccountActionInvalidException("Account closed");

        synchronized (this) {
            balance -= amount;
        }
    }

    public void close() {
        this.status = Status.CLOSE;
    }

    enum Status {
        OPEN,
        CLOSE
    }

}
