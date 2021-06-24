package by.htp.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idQ;

    private String toUserEmail;

    private String question;

    private String answerType;

    private String answer;

    private String status;
}
