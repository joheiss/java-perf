package com.jovisco.tutorial.customer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<CustomerRecord> {

    private final Map<String, CustomerRecord> records;

    public CustomerRecords() {
        this.records = new HashMap<String, CustomerRecord>();
    }

    public void addCustomer(CustomerRecord c) {
        this.records.put(c.name(), c);
    }

    public Map<String, CustomerRecord> getCustomers() {
        return Map.copyOf(records);
    }

    // this method is only needed to play with GC
    public void clear() {
        records.clear();
    }

    public CustomerRecord find(String name) {
        return records.get(name);
    }

    @Override
    public Iterator<CustomerRecord> iterator() {
        return records.values().iterator();
    }
}
