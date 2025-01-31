
package entities;

import exceptions.BusinessException;// precisa importar

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {

    }
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    // a função abaixo é void, porque vc passa como argumento a quantia a ser depositada
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        validateWithdraw(amount);//se passar chama o balance, senão a função withdraw lança a exceção
        balance -= amount;
    }

    // 
    private void validateWithdraw(double amount) {//vou colocar private e chamar dentro do withdraw
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Withdrawal Error: Withdrawal amount exceeds the withdrawal limit");
            //lança e instancia a exceção, throw assim como o return corta o método(o if)  
                  
        }
        if (amount > getBalance()) {// não precisa else aqui porque o return já corta a função
            throw new BusinessException("Withdrawal Error: Insufficient balance");            
        }
        
    }
}
