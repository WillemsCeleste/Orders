package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ADRESS")
    private String email;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private List<Order> customerOrders = new ArrayList<>();

    private Customer() {
    }

    public Customer( String name, String lastName, String email, String adress, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void addOrderToThisCustomer(Order order){
        customerOrders.add(order);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (!name.equals(customer.name)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (!email.equals(customer.email)) return false;
        if (!adress.equals(customer.adress)) return false;
        if (!phoneNumber.equals(customer.phoneNumber)) return false;
        return customerOrders != null ? customerOrders.equals(customer.customerOrders) : customer.customerOrders == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + adress.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}
