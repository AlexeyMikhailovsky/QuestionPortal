package by.htp.main.QuestionPortal.repository;

import by.htp.main.QuestionPortal.entity.Question;
import by.htp.main.QuestionPortal.service.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query(value = "DELETE FROM Question where idCustomer=?1")
    public void deleteQuestionsByCustomerId(Long id) ;

    @Query(value = "from Question where idCustomer=?1")
    public List<Question> getCustomerQuestions(Long id);

    @Query(value = "from Question where toCustomerEmail=?1")
    public List<Question> getCustomerAnswers(String email);
}
