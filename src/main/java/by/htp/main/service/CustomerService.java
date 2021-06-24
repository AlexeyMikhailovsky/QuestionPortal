package by.htp.main.service;

import java.util.List;

import by.htp.main.entity.Customer;
import org.hibernate.service.spi.ServiceException;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    Customer authorization (String email, String password) ;

}

