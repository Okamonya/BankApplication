package com.example.bankapplication.Service;

import com.example.bankapplication.Repository.CustomerRepository;
import com.example.bankapplication.main.Customer;
import com.example.bankapplication.main.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String kra) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByKra(kra);
        if (customer == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerDetail(customer);
    }
}
