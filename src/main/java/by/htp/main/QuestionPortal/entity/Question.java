package by.htp.main.QuestionPortal.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idQ;

    @Column(name="email_to_customer")
    private String toCustomerEmail;

    @Column(name="question_text")
    private String question;

    @Column(name="answer_type")
    private String answerType;

    @Column(name="customer_id")
    private Long idCustomer;

    @Column(name="answer")
    private String answer;

    public Question(){}

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQ=" + idQ +
                ", toCustomerEmail='" + toCustomerEmail + '\'' +
                ", question='" + question + '\'' +
                ", answerType=" + answerType +
                ", idCustomer=" + idCustomer +
                ", answer='" + answer + '\'' +
                '}';
    }
}
