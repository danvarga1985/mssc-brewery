package com.danvarga.msscbrewery.web.mappers;

import com.danvarga.msscbrewery.domain.Customer;
import com.danvarga.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}
