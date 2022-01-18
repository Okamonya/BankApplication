package com.example.bankapplication.Service;

import com.example.bankapplication.Repository.AccountRepo;
import com.example.bankapplication.Repository.CustomerRepository;
import com.example.bankapplication.Repository.RoleRepository;
import com.example.bankapplication.main.Customer;
import com.example.bankapplication.main.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepo accountRepo;

    public void saveCustomerWithRole (Customer customer){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        Role roleCustomer = roleRepository.findByName("customer");
        customer.addRole(roleCustomer);



        customerRepository.save(customer);
    }

}
