package com.jumia.api.customer.service;

import com.jumia.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> getCustomers(Pageable pageable);
}