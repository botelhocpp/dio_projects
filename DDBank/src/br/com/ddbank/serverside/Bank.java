package br.com.ddbank.serverside;

import java.util.Map;
import java.util.TreeMap;

import br.com.ddbank.serverside.exceptions.InexistentAgencyException;

public class Bank {
     private final String bankName;
     private final String bankEin; //12-3456789
     private Map<Integer, Agency> agencyList;
     private static int nextAgencyNumber = 1;
     private static int nextAccountNumber = 1;
     private static int nextClientID = 1;

     public Bank(String bankName, String bankEin) throws IllegalArgumentException {
          if(bankName == null || bankName.isEmpty()) {
               throw new IllegalArgumentException("Invalid bank name.");
          }
          else if(bankName == null || bankName.isEmpty()) {
               throw new IllegalArgumentException("Invalid Employer Identification Number.");
          }
          this.bankName = bankName;
          this.bankEin = bankEin;
          this.agencyList = new TreeMap<>();
     }

     public Agency createAgency() {
          Agency newAgency = new Agency(nextAgencyNumber++);
          this.agencyList.put(newAgency.getAgencyNumber(), newAgency);
          return newAgency;
     }

     public void removeAgency(int agencyNumber) {
          if(this.agencyList.remove(agencyNumber) == null) {
               throw new InexistentAgencyException();
          }
     }

     public Agency getAgency(int agencyNumber) {
          return this.agencyList.get(agencyNumber);
     }

     public static int newAccount() {
          return nextAccountNumber++;
     }

     public static int newClient() {
          return nextClientID++;
     }

     public String getBankName() {
          return this.bankName;
     }

     public String getBankEin() {
          return this.bankEin;
     }

     @Override
     public String toString() {
          return String.format("Bank: %s%n" +
                              "Employer Identification Number(EIN): %s%n" +
                              "Number of Agencies: %d",
                              this.bankName, this.bankEin, this.agencyList.size());
     }
}