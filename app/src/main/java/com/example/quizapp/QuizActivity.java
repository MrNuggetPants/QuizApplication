package com.example.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submit;

    int score = 0;
    int totalQuestion = Questions.question.length;
    int currentIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        submit = findViewById(R.id.submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        totalQuestionsTextView.setText("Fine");

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit) {
            if(selectedAnswer.equals(Questions.correctAnswers[currentIndex])) {
                score += 1;
                currentIndex += 1;
                loadNewQuestion();
            } else {
                totalQuestionsTextView.setText("Wrong");
            }

        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion() {
        questionTextView.setText(Questions.question[currentIndex]);
        ansA.setText(Questions.choices[currentIndex][0]);
        ansA.setText(Questions.choices[currentIndex][1]);
        ansA.setText(Questions.choices[currentIndex][2]);
        ansA.setText(Questions.choices[currentIndex][3]);
    }
}
