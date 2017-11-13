package be.cegeka.orders.order.domain.customers;

public class CustomerDto {

    public String name;
    public String lastName;
    public String email;
    public String adress;
    public String phoneNumber;

    public CustomerDto() {
    }

    public CustomerDto(String name, String lastName, String email, String adress, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
