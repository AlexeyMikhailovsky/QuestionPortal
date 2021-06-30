package by.htp.main.QuestionPortal.service;

import by.htp.main.QuestionPortal.entity.Customer;
import by.htp.main.QuestionPortal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static by.htp.main.QuestionPortal.service.validation.ValidationLogin.validateAuthorisation;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public void save(Customer customer) throws ServiceException{
        if(!validateAuthorisation(customer.getEmail(),customer.getPassword())){
            throw new ServiceException("Email and password must be filled!");
        }
        customerRepository.save(customer);
    }

    @Transactional
    public Customer getById(Long id){
        return customerRepository.getById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    public Customer getCustomerByEmail(String email)throws ServiceException {
        if(!validateAuthorisation(email)){
            throw new ServiceException("Login is empty.");
        }
        try {
            return customerRepository.getCustomerByEmail(email);
        }catch (Exception e){
            throw new ServiceException("Such customer are not exists.");
        }

    }
}
