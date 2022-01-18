package com.example.bankapplication.main;



import com.example.bankapplication.account.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "customer", uniqueConstraints = @UniqueConstraint(columnNames = "kra"))
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String kra;

    private String ssn;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customers_roles",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles =new HashSet<>();


    @OneToOne
    private Account account;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String kra, String ssn, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.kra = kra;
        this.ssn = ssn;
        this.password = password;

    }


    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public String getKra() {

        return kra;
    }
    public void setKra(String kra) {

        this.kra = kra;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
