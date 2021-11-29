package com.jumia.api.customer.service;

import com.jumia.api.customer.repository.CustomerRepository;
import com.jumia.entity.CustomerEntity;
import com.jumia.model.Customer;
import com.jumia.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerValidator customerValidator;

    @Override
    public Page<Customer> getCustomers(Pageable pageable) {
        Page<CustomerEntity> customers = customerRepository.findAll(pageable);
        List<Customer> customerListWithMoreDetails = getPhoneNumbers(customers.getContent());
        Page<Customer> customerPageWithMoreDetails = new PageImpl<>(customerListWithMoreDetails, customers.getPageable(), customers.getTotalElements());
        return customerPageWithMoreDetails;
    }

    private List<Customer> getPhoneNumbers(List<CustomerEntity> customerList) {
        List<Customer> customerListWithMoreDetails = new ArrayList<>();
        for (CustomerEntity customer : customerList) {
            Customer customerWithMoreDetails = new Customer();
            String phoneNumber = customer.getPhone();
            customerValidator.validatePhoneNumber(phoneNumber, customerWithMoreDetails);
            customerWithMoreDetails.setName(customer.getName());
            setCountry(phoneNumber, customerWithMoreDetails);
            customerListWithMoreDetails.add(customerWithMoreDetails);
        }
        return customerListWithMoreDetails;
    }

    private void setCountry(String phoneNumber, Customer customerWithMoreDetails) {
        if (phoneNumber.startsWith("(237)")) {
            customerWithMoreDetails.setCountryName("Cameroon");
        } else if (phoneNumber.startsWith("(251)")) {
            customerWithMoreDetails.setCountryName("Ethiopia");
        } else if (phoneNumber.startsWith("(212)")) {
            customerWithMoreDetails.setCountryName("Morocco");
        } else if (phoneNumber.startsWith("(258)")) {
            customerWithMoreDetails.setCountryName("Mozambique");
        } else if (phoneNumber.startsWith("(256)")) {
            customerWithMoreDetails.setCountryName("Uganda");
        }
    }
}