package com.jovisco.tutorial;

import com.jovisco.tutorial.customer.CustomerRecord;
import com.jovisco.tutorial.customer.CustomerRecords;

public class EscapingReferences {

    public static void main(String[] args) {
       var customers = new CustomerRecords();

       customers.addCustomer(new CustomerRecord("John"));
       customers.addCustomer(new CustomerRecord("Simon"));

       for (var next : customers.getCustomers().values()) {
           System.out.println(next);
       }
    }
}
