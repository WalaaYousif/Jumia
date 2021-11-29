package com.jumia.api.customer.mapper;

import com.jumia.model.Customer;
import com.jumia.swagger.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(Customer customerPage);
}