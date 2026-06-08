package lk.ijse.OrderManagementSystem.service.impl;

import lk.ijse.OrderManagementSystem.dto.CustomerDTO;
import lk.ijse.OrderManagementSystem.entity.Customer;
import lk.ijse.OrderManagementSystem.repository.CustomerRepository;
import lk.ijse.OrderManagementSystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Execute method saveCustomer");
        try {
            Customer customer = new Customer();
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());

            Customer savedCustomer = customerRepository.save(customer);
            log.info("Customer Saved ...");

            CustomerDTO savedCustomerDTO = new CustomerDTO();
            savedCustomerDTO.setCustomerId(savedCustomer.getCustomerId());
            savedCustomerDTO.setCustomerName(savedCustomer.getCustomerName());
            savedCustomerDTO.setEmail(savedCustomer.getEmail());
            savedCustomerDTO.setPhoneNumber(savedCustomer.getPhoneNumber());
            log.info("Save Customer Returned ...");
            return savedCustomerDTO;
        } catch (Exception e) {
            log.error("Error occurred while saving customer: " + e.getMessage());
            throw e;
        }
    }
}
