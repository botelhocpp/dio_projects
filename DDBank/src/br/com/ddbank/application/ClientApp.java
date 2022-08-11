package br.com.ddbank.application;

import java.util.Locale;

import br.com.ddbank.clientside.Account;
import br.com.ddbank.serverside.Agency;
import br.com.ddbank.serverside.Bank;

public class ClientApp {
     public static void main(String[] args) {
          Locale.setDefault(Locale.US);
          Bank bank = new Bank("DDBank Singular", "23-0728596");
          System.out.println(bank);

          Agency brazil = bank.createAgency();
          System.out.println(brazil);
          System.out.println(bank);

          bank.removeAgency(brazil.getAgencyNumber());
          System.out.println(bank);

          brazil = bank.createAgency();
          System.out.println(brazil);
          System.out.println(bank);

          brazil.createClient("123-456-789", "Pedro Botelho", "Brazil St.", "88996888324");
          System.out.println(brazil);

          Account pedro = brazil.getAccount(1);
          System.out.println(pedro);

     }
}
