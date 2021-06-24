package by.htp.main.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName",
                        Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    public void saveCustomer(Customer theCustomer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);

    }

    public Customer getCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }


    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery =
                currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public Customer authorization(String email, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("from Customer where email = '" + email + "' and password = '" + password + "'", Customer.class);
        System.out.println("kon");
        Customer customer = new Customer();
        customer =(Customer) theQuery.uniqueResult();
        return customer;
    }

}












