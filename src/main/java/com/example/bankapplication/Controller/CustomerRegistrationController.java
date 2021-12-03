package com.example.bankapplication.Controller;

import com.example.bankapplication.Repository.CustomerRepository;
import com.example.bankapplication.Service.Account.TransactionServices;
import com.example.bankapplication.Service.CustomerService;
import com.example.bankapplication.account.Account;
import com.example.bankapplication.account.Transaction;
import com.example.bankapplication.main.Customer;

import com.example.bankapplication.main.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


@Controller

public class CustomerRegistrationController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/registration")
    public String RegistrationForm(Model model) {
        model.addAttribute("customer",new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String Registration(Customer customer){
        customerService.saveCustomerWithRole(customer);

        return "registration";

    }

    @RequestMapping("/customer_home")
    public String showCustomer(@AuthenticationPrincipal CustomerDetail customer, Account account, Model model) {
        model.addAttribute("account",account);
        model.addAttribute("customer", customer);

        return "customer_home";
    }



    @RequestMapping("/account")
    public String showAccountInfo(Principal principal, Model model) {
        List<Transaction> transactionList = transactionServices.findTransactionList(principal.getName());
        Customer customer = customerRepository.findByKra(principal.getName());
        Account account = customer.getAccount();

        model.addAttribute("account", account);
        model.addAttribute("transactionList", transactionList);

        return "account";
    }


}
