package com.example.bankapplication.Repository;

import com.example.bankapplication.account.Account;
import com.example.bankapplication.main.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u FROM Customer u WHERE u.kra = ?1")
    Customer findByKra(String kra);

}
