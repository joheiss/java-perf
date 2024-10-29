package com.jovisco.tutorial;

import com.jovisco.tutorial.customer.CustomerRecord;
import com.jovisco.tutorial.customer.CustomerRecords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapingReferencesTest {

    @Nested
    @DisplayName("Test Escaping References")
    class TestEscapingReferences {

        CustomerRecords customers;

        @BeforeEach
        public void setUp() {
            customers = new CustomerRecords();
            customers.addCustomer(new CustomerRecord("John"));
            customers.addCustomer(new CustomerRecord("Simon"));
        }

        @Test
        @DisplayName("... should throw an exception if somebody tries to clear the returned immutable map")
        void test_throws_exception_when_clearing() {
            assertThrows(UnsupportedOperationException.class, () -> {
                customers.getCustomers().clear();
            });
        }

        @Test
        @DisplayName("... should throw an exception if somebody tries to add to the returned immutable map")
        void test_throws_exception_when_adding() {
            assertThrows(UnsupportedOperationException.class, () -> {
                customers.getCustomers().put("Joe", new CustomerRecord("Joe"));
            });
        }

        @Test
        @DisplayName("... should allow to iterate over the returned immutable map")
        void test_iterate_over_map() {
            for (var next : customers.getCustomers().values()) {
                assertNotNull(next);
            }
        }

        @Test
        @DisplayName("... should find a customer and not allow to change it")
        void test_change_customer() {
            var found = customers.find("John");
            assertNotNull(found);
            assertEquals("John", found.name());
            // since the record does not provide any methods to manipulate the
            // customer, we should not be able to change it
        }
    }
}