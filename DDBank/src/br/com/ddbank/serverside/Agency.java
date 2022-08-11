package br.com.ddbank.serverside;

import java.util.Map;
import java.util.TreeMap;

import br.com.ddbank.clientside.Account;
import br.com.ddbank.clientside.CheckingAccount;
import br.com.ddbank.clientside.Client;
import br.com.ddbank.clientside.SavingsAccount;
import br.com.ddbank.clientside.exceptions.InexistentAccountException;
import br.com.ddbank.clientside.exceptions.InexistentClientException;

public class Agency {

     private final int agencyNumber;
     private Map<Integer, Account> accountList;
     private Map<Integer, Client> clientList;

     public Agency(int agencyNumber) {
          this.agencyNumber = agencyNumber;
          this.accountList = new TreeMap<>();
          this.clientList = new TreeMap<>();
     }

     public void createClient(String SSN, String name, String address, String phoneNumber) {
          Client newClient = new Client(Bank.newClient(), SSN, name, address, phoneNumber);
          clientList.put(this.createAccount(new SavingsAccount(this.agencyNumber, Bank.newAccount())), newClient);
          clientList.put(this.createAccount(new CheckingAccount(this.agencyNumber, Bank.newAccount())), newClient);
     }

     public Client getClient(int id) {
          Client target = this.clientList.get(id);
          if(target == null) {
               throw new InexistentClientException();
          }
          return target;
     }

     public void removeAccount(int accountNumber) {
          if(this.accountList.remove(agencyNumber) == null) {
               throw new InexistentAccountException();
          }
     }

     public Account getAccount(int accountNumber) {
          Account target = this.accountList.get(accountNumber);
          if(target == null) {
               throw new InexistentAccountException();
          }
          return target;
     }

     public int getAgencyNumber() {
          return agencyNumber;
     }

     @Override
     public String toString() {
          return String.format("Agency Number: %04d%n" +
                              "Number of Accounts: %d",
                              this.agencyNumber, this.accountList.size());
     }
 
     private int createAccount(Account newAccount) {
          this.accountList.put(newAccount.getAccountNumber(), newAccount);
          return newAccount.getAccountNumber();
     }
}