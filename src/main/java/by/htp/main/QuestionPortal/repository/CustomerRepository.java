package by.htp.main.QuestionPortal.repository;

import by.htp.main.QuestionPortal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "from Customer where email=?1")
    public Customer getCustomerByEmail(String email);
}
