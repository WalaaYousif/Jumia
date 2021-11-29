package com.jumia.api.customer.controller;

import com.jumia.api.customer.mapper.CustomerMapper;
import com.jumia.api.customer.service.CustomerService;
import com.jumia.model.Customer;
import com.jumia.response.PageModel;
import com.jumia.response.PageResponse;
import com.jumia.response.PaginationUtils;
import com.jumia.swagger.model.CustomerDTO;
import com.jumia.swagger.resource.CustomerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import static com.jumia.response.PaginationUtils.toPageModel;

@CrossOrigin
@RestController
public class CustomerController implements CustomerApi {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    public ResponseEntity<PageResponse> getCustomers(Integer pageNo, Integer pageSize) {
        logger.info("getCustomers");
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Customer> customerPage = customerService.getCustomers(pageable);
        PageModel<CustomerDTO> customersDTO = toPageModel(customerPage.map(customerMapper::toDto));
        return ResponseEntity.ok(PageResponse.of(customersDTO));
    }
}