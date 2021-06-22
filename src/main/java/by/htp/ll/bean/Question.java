package by.htp.ll.bean;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="question_id")
    private int idQuestion;

    private String fromUserEmail;

    private String toUserEmail;

    private String question;

    private String answerType;

    private String answer;

    private String status;
}
