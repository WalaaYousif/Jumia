package com.jumia.api.customer.mapper;

import com.jumia.model.Customer;
import com.jumia.swagger.model.CustomerDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T22:39:54+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDto(Customer customerPage) {
        if ( customerPage == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setName( customerPage.getName() );
        customerDTO.setPhone( customerPage.getPhone() );
        customerDTO.setStatus( customerPage.getStatus() );
        customerDTO.setCountryName( customerPage.getCountryName() );

        return customerDTO;
    }
}
