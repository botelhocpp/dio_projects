package br.com.ddbank.clientside;

public class Client implements Comparable<Client> {

     private final int ID;
     private final String SSN; //123-45-6789
     private String name;
     private String address;
     private String phoneNumber;
     
     public Client(int ID, String SSN, String name, String address, String phoneNumber) throws IllegalArgumentException {

          if(SSN == null || SSN.isEmpty() || SSN.length() != 11) {
               throw new IllegalArgumentException("Invalid Social Security Number.");
          }

          this.ID = ID;
          this.SSN = SSN;
          this.setName(name);
          this.setAddress(address);
          this.setPhone(phoneNumber);
     }

     // ------------------------------------------------------------------------
     // Client Management
     // ------------------------------------------------------------------------

     @Override
     public String toString() {
          return String.format("Name: %s%n" + 
                              "ID Number: %06d%n" + 
                              "Social Security Number: %s%n" + 
                              "Address: %s%n" +
                              "Phone Number: %s", 
                              this.name, this.ID, this.SSN, this.address, this.phoneNumber);
     }

     @Override
     public int compareTo(Client otherClient) {
          return this.name.compareTo(otherClient.getName());
     }

     // ------------------------------------------------------------------------
     // Getters
     // ------------------------------------------------------------------------

     public int getID() {
          return this.ID;
     }

     public String getName() {
          return this.name;
     }

     public String getAddress() {
          return this.address;
     }

     public String getPhone() {
          return this.phoneNumber;
     }

     public String getSSN() {
          return this.SSN;
     }
     
     // ------------------------------------------------------------------------
     // Setters
     // ------------------------------------------------------------------------

     public void setName(String name) {
          if(name == null || name.isEmpty()) {
               throw new IllegalArgumentException("Invalid client name.");
          }
          this.name = name;
     }

     public void setAddress(String address) {
          if(address == null || address.isEmpty()) {
               throw new IllegalArgumentException("Invalid address.");
          }
          this.address = address;
     }

     public void setPhone(String phoneNumber) {
          if(phoneNumber == null || phoneNumber.isEmpty()) {
               throw new IllegalArgumentException("Invalid phone number.");
          }
          this.phoneNumber = phoneNumber;
     }
     
}
