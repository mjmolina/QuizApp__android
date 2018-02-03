package com.example.mariajosemolina.quizapp;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.view.View;
import android.graphics.Color;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;


public class Main2Activity extends AppCompatActivity {

    // This List of List of Strings will contain all the data
    // related to the questions.
    //     Each question will be a List of Strings that will contain the
    //     following elements
    //        0: Category ("0", "1", "2"), for Chemistry, Biology and Physics
    //        1: Question, the title of the question.
    //        2: Option A
    //        3: Option B
    //        4: Option C
    //        5: Option D
    //        6: Solution, correct answer ("1", "2", "3" or "4")
    //        7: Extra text
    List<List<String>> questions = new ArrayList<List<String>>();

    // This is the declaration to access all the elements of the Quiz
    ImageView q1_image, q2_image, q3_image, q4_image, q5_image;
    TextView q1_title, q2_title, q3_title, q4_title, q5_title;
    TextView q1_optionA, q2_optionA, q3_optionA, q4_optionA, q5_optionA;
    TextView q1_optionB, q2_optionB, q3_optionB, q4_optionB, q5_optionB;
    TextView q1_optionC, q2_optionC, q3_optionC, q4_optionC, q5_optionC;
    TextView q1_optionD, q2_optionD, q3_optionD, q4_optionD, q5_optionD;
    TextView q1_message, q2_message, q3_message, q4_message, q5_message;
    RadioGroup q1_buttons, q2_buttons, q3_buttons, q4_buttons, q5_buttons;
    Boolean evaluated = Boolean.FALSE;

    // Buttons at the end of the questions
    Button again_button, send_button;

    public void init_questions() {
        // Question 1
        List<String> q01 = Arrays.asList("0",
                "Which is the meaning of ATOM",
                "Divisible",
                "Indivisible",
                "The smallest",
                "Particle",
                "2",
                "The word ATOM comes from the Greek word for 'indivisible', but we know that is divisible!");
        questions.add(q01);

        // Question 2
        List<String> q02 = Arrays.asList("0",
                "Water is vital for the human existence, lets see how much do you know about it. Which of the following facts is False:",
                "~60% of earth's freshwater is trapped inside Glaciers",
                "~70% of our brain is water",
                "Males needs to drink on average 1.5lt while females need 3.5lt",
                "Every day, we lose about ~250ml of water in total when we exhale",
                "3",
                "The National Academies of Sciences, Engineering, and Medicine (US) determined that an adequate daily fluid intake is roughly 3.5lt and 2.5lt for an average male and female respectevely");
        questions.add(q02);

        // Question 3
        List<String> q03 = Arrays.asList("0",
                "Iron is fundamental for humans. Where in the body is most of the Iron located?",
                "In all our Bones",
                "Mainly in the Brain",
                "In our Blood",
                "Only in our Hair",
                "3",
                "Most of the body's Iron is locked up in the Haemoglobin found in red blood cells, used for oxygen transport.");
        questions.add(q03);

        // Question 4
        List<String> q04 = Arrays.asList("0",
                "What of the following statements is False:",
                "If you put a handful of salt into a glass of water that is full, the water level will go down",
                "From the total oxygen in our atmosphere, 20% is produced by the amazon forest",
                "If you mix half litre of alcohol with half litre of water, you end up of 1 litre of the mixture",
                "The only letter that does not appear on the periodic table is J",
                "3",
                "Surprisinly, the volume of the solution with water and salt will actually shrink by about 2%. Salt will break in ions, which will pull the water molecules closer!");
        questions.add(q04);

        // Question 5
        List<String> q05 = Arrays.asList("0",
                "Some frogs are colourful and warn us that they are extremely toxic. This animals have poison compounds, for instance the batrachotoxine a neurotoxine, in their skin. How could they avoid to be poison by themselves?",
                "They can not touch their own skin",
                "They have a mutation avoiding the entrance of the toxic",
                "They can be poisoned",
                "They have immunity of their poison",
                "2",
                "Batrachotoxin kills due to its effect on sodium ion channels in the body. It binds to these channels and jams them open, interfering with nerve transmission and causing muscles to contract. It turns out that the frogs avoid batrachotoxin's effects thanks to a single mutation in their version of the sodium ion channel protein. This mutation doesn't alter the properties of the sodium ion channel, but does confer resistance to batrachotoxin, meaning that the frogs are free to accumulate it without it killing them.");
        questions.add(q05);

        // Question 6
        List<String> q06 = Arrays.asList("1",
                "When plants grows near, start a competence for light. In this situation is activated a Syndrome. Do you know the name of the Syndrome?",
                "I am the Winner Syndrome (IWS)",
                "Avoiding Competence Syndrome (ACS)",
                "Shade Avoidance Syndrome (SAS)",
                "Light Competence Syndrome (LCS)",
                "3",
                "Shade avoidance is a set of responses that plants display when they are subjected to the shade of another plant, including elongation, altered flowering time, increased apical dominance and altered partitioning of resources.");
        questions.add(q06);

        // Question 7
        List<String> q07 = Arrays.asList("1",
                "Which of the following sentenced do you think is False about Ladybugs?",
                "A ladybug can practice cannibalism",
                "They are not really bug.",
                "They can control to lie fertile or infertile eggs",
                "You can tell how old a ladybug is according to the black dots",
                "4",
                "The patterns on the top of a ladybug are not related to how old they are");
        questions.add(q07);

        // Question 8
        List<String> q08 = Arrays.asList("1",
                "What is the average amount of bones that a adult human being has?",
                "30",
                "250",
                "180",
                "200",
                "4",
                "Humans are born with 270 bones, but while growing up some of them get fused and we end up with 206 bones.");
        questions.add(q08);

        // Question 9
        List<String> q09 = Arrays.asList("1",
                "Female sharks have thicker skins than males. How do you think they developed this feature?",
                "While mating, male sharks usually bite the females to anchor themself",
                "To contain the offsprings more safely, because any impact on her body can cause them damage",
                "To resist attacks from predators, that usually attack females only",
                "To be able to swim in deeper waters and resist the pressure",
                "1",
                "The skin of a female shark is much thicker than a male because these bite females during mating,");
        questions.add(q09);

        // Question 10
        List<String> q10 = Arrays.asList("1",
                "Which of the following statements is True:",
                "If you sneeze with your eyes open will they pop out",
                "You can survive in the desert drinking your own urine",
                "Humans cannot survive on a diet purely based on insects",
                "The temperature of a lighting bolt is hotter than the surface of the sun",
                "4",
                "A lighting bolt temperature is about 30,000 Kelvin, while the Sun's surface is only 6,000 Kelvin. The important aspect is that the Sun's surface is not so hot compared to its atmosphere");
        questions.add(q10);

        // Question 11
        List<String> q11 = Arrays.asList("2",
                "Which of the following options is False related to the planet Venus?",
                "One Venusian day is shorter than a Venusian year",
                "It is the second planet from the sun in our solar system",
                "Its diameter is only ~700 km less than our planet's diameter",
                "It is the hottest planet in our solar system",
                "1",
                "Venus cannot rotate on its own axis before it completes a whole orbit to the Sun, this means its day is longer than its year!");
        questions.add(q11);

        // Question 12
        List<String> q12 = Arrays.asList("2",
                "One of the most iconic buildings in the world is the Eiffel tower, which his around 324m tall. Roughly, how many Eiffel towers do we need to touch our Moon?",
                "Around 100 Eiffel towers",
                "Around 1,000,000 Eiffel towers",
                "Around 10,000 Eiffel towers",
                "Around 100,000,000 Eiffel towers",
                "2",
                "The proper amount is ~1,172,893 since the moon is 380,000 km away");
        questions.add(q12);

        // Question 13
        List<String> q13 = Arrays.asList("2",
                "The smallest planet in our solar system is Mercury (40% of earth's size) and upiter is the biggest planet (12 times bigger than earth). How many Solar System planets can fit between the distance of the earth and the moon?",
                "Only Jupiter",
                "Two, mercury and Venus, because they are the smallest",
                "We cannot fit any planets between the earth and the moon",
                "We can fit all the planets between the earth and the moon",
                "4",
                "We can fit all of them!, and we have 2,000 km left!");
        questions.add(q13);

        // Question 14
        List<String> q14 = Arrays.asList("2",
                "How big is the Sun's diameter in terms of the size of our planet?",
                "~10 planets earth can fit the sun diameter",
                "~1,000 planets earth can fit the sun diameter",
                "~100 planets earth can fit the sun diameter",
                "~1,000,000 planet earths can fit the sun diameter",
                "3",
                "We need roughly ~109 times our planet's diameter to fit the Sun's diameter");
        questions.add(q14);

        // Question 15
        List<String> q15 = Arrays.asList("2",
                "How Much Does the Earth Weight (kg)?",
                "6,000,000,000,000,000,000,000,000 kg",
                "6,000,000,000,000,000,000,000 kg",
                "6,000,000,000,000,000 kg",
                "6,000,000,000 kg",
                "1",
                "The earth is  5.972 x 10^(24) kg! that is 24 zeros!");
        questions.add(q15);

        // Since we have a list of questions, we can shuffle them to get random questions in our Quiz
        Collections.shuffle(questions);
    }

    // Method that will find each element on the activity_main2.xml layout
    // and will connect it to our variables.
    public void init_elements() {

        q1_image = (ImageView) findViewById(R.id.q1_image);
        q2_image = (ImageView) findViewById(R.id.q2_image);
        q3_image = (ImageView) findViewById(R.id.q3_image);
        q4_image = (ImageView) findViewById(R.id.q4_image);
        q5_image = (ImageView) findViewById(R.id.q5_image);

        q1_title = (TextView) findViewById(R.id.q1_title);
        q2_title = (TextView) findViewById(R.id.q2_title);
        q3_title = (TextView) findViewById(R.id.q3_title);
        q4_title = (TextView) findViewById(R.id.q4_title);
        q5_title = (TextView) findViewById(R.id.q5_title);

        q1_optionA = (TextView) findViewById(R.id.q1_optionA);
        q2_optionA = (TextView) findViewById(R.id.q2_optionA);
        q3_optionA = (TextView) findViewById(R.id.q3_optionA);
        q4_optionA = (TextView) findViewById(R.id.q4_optionA);
        q5_optionA = (TextView) findViewById(R.id.q5_optionA);

        q1_optionB = (TextView) findViewById(R.id.q1_optionB);
        q2_optionB = (TextView) findViewById(R.id.q2_optionB);
        q3_optionB = (TextView) findViewById(R.id.q3_optionB);
        q4_optionB = (TextView) findViewById(R.id.q4_optionB);
        q5_optionB = (TextView) findViewById(R.id.q5_optionB);

        q1_optionC = (TextView) findViewById(R.id.q1_optionC);
        q2_optionC = (TextView) findViewById(R.id.q2_optionC);
        q3_optionC = (TextView) findViewById(R.id.q3_optionC);
        q4_optionC = (TextView) findViewById(R.id.q4_optionC);
        q5_optionC = (TextView) findViewById(R.id.q5_optionC);

        q1_optionD = (TextView) findViewById(R.id.q1_optionD);
        q2_optionD = (TextView) findViewById(R.id.q2_optionD);
        q3_optionD = (TextView) findViewById(R.id.q3_optionD);
        q4_optionD = (TextView) findViewById(R.id.q4_optionD);
        q5_optionD = (TextView) findViewById(R.id.q5_optionD);

        q1_message = (TextView) findViewById(R.id.q1_message);
        q2_message = (TextView) findViewById(R.id.q2_message);
        q3_message = (TextView) findViewById(R.id.q3_message);
        q4_message = (TextView) findViewById(R.id.q4_message);
        q5_message = (TextView) findViewById(R.id.q5_message);

        q1_buttons = (RadioGroup) findViewById(R.id.q1_buttons);
        q2_buttons = (RadioGroup) findViewById(R.id.q2_buttons);
        q3_buttons = (RadioGroup) findViewById(R.id.q3_buttons);
        q4_buttons = (RadioGroup) findViewById(R.id.q4_buttons);
        q5_buttons = (RadioGroup) findViewById(R.id.q5_buttons);

        again_button = (Button) findViewById(R.id.again);
        send_button = (Button) findViewById(R.id.send);
    }

    // Method that will set the header image to each question
    // but depending on the category of the question.
    public void set_image_to_question(List<String> q, ImageView img) {

        // We get the category of the question
        String category = q.get(0);

        if (category == "0")
            img.setImageResource(R.drawable.chemistry);
        else if (category == "1")
            img.setImageResource(R.drawable.biology);
        else if (category == "2")
            img.setImageResource(R.drawable.physics);
    }

    // Method to set the values of the images, the questions and the options.
    public void set_questions_on_screen() {

        // Setting the images to the header of each question
        // depending on the category
        set_image_to_question(questions.get(0), q1_image);
        set_image_to_question(questions.get(1), q2_image);
        set_image_to_question(questions.get(2), q3_image);
        set_image_to_question(questions.get(3), q4_image);
        set_image_to_question(questions.get(4), q5_image);

        // Setting the title of each question
        q1_title.setText(questions.get(0).get(1));
        q2_title.setText(questions.get(1).get(1));
        q3_title.setText(questions.get(2).get(1));
        q4_title.setText(questions.get(3).get(1));
        q5_title.setText(questions.get(4).get(1));

        // Setting the options for each question
        q1_optionA.setText(questions.get(0).get(2));
        q1_optionB.setText(questions.get(0).get(3));
        q1_optionC.setText(questions.get(0).get(4));
        q1_optionD.setText(questions.get(0).get(5));

        q2_optionA.setText(questions.get(1).get(2));
        q2_optionB.setText(questions.get(1).get(3));
        q2_optionC.setText(questions.get(1).get(4));
        q2_optionD.setText(questions.get(1).get(5));

        q3_optionA.setText(questions.get(2).get(2));
        q3_optionB.setText(questions.get(2).get(3));
        q3_optionC.setText(questions.get(2).get(4));
        q3_optionD.setText(questions.get(2).get(5));

        q4_optionA.setText(questions.get(3).get(2));
        q4_optionB.setText(questions.get(3).get(3));
        q4_optionC.setText(questions.get(3).get(4));
        q4_optionD.setText(questions.get(3).get(5));

        q5_optionA.setText(questions.get(4).get(2));
        q5_optionB.setText(questions.get(4).get(3));
        q5_optionC.setText(questions.get(4).get(4));
        q5_optionD.setText(questions.get(4).get(5));

    }

    public void resume_questions_on_screen(Bundle savedInstanceState) {


        init_elements();

        List<String> q1_read = savedInstanceState.getStringArrayList("q1");
        List<String> q2_read = savedInstanceState.getStringArrayList("q2");
        List<String> q3_read = savedInstanceState.getStringArrayList("q3");
        List<String> q4_read = savedInstanceState.getStringArrayList("q4");
        List<String> q5_read = savedInstanceState.getStringArrayList("q5");

        Boolean eval = savedInstanceState.getBoolean("eval");

        Integer a1 = savedInstanceState.getInt("a1");
        Integer a2 = savedInstanceState.getInt("a2");
        Integer a3 = savedInstanceState.getInt("a3");
        Integer a4 = savedInstanceState.getInt("a4");
        Integer a5 = savedInstanceState.getInt("a5");

        if (a1 != -1)
            q1_buttons.check(a1);
        if (a2 != -1)
            q2_buttons.check(a2);
        if (a3 != -1)
            q3_buttons.check(a3);
        if (a4 != -1)
            q4_buttons.check(a4);
        if (a5 != -1)
            q5_buttons.check(a5);

        questions.add(q1_read);
        questions.add(q2_read);
        questions.add(q3_read);
        questions.add(q4_read);
        questions.add(q5_read);

        // Setting the images to the header of each question
        // depending on the category
        set_image_to_question(questions.get(0), q1_image);
        set_image_to_question(questions.get(1), q2_image);
        set_image_to_question(questions.get(2), q3_image);
        set_image_to_question(questions.get(3), q4_image);
        set_image_to_question(questions.get(4), q5_image);

        // Setting the title of each question
        q1_title.setText(questions.get(0).get(1));
        q2_title.setText(questions.get(1).get(1));
        q3_title.setText(questions.get(2).get(1));
        q4_title.setText(questions.get(3).get(1));
        q5_title.setText(questions.get(4).get(1));

        // Setting the options for each question
        q1_optionA.setText(questions.get(0).get(2));
        q1_optionB.setText(questions.get(0).get(3));
        q1_optionC.setText(questions.get(0).get(4));
        q1_optionD.setText(questions.get(0).get(5));

        q2_optionA.setText(questions.get(1).get(2));
        q2_optionB.setText(questions.get(1).get(3));
        q2_optionC.setText(questions.get(1).get(4));
        q2_optionD.setText(questions.get(1).get(5));

        q3_optionA.setText(questions.get(2).get(2));
        q3_optionB.setText(questions.get(2).get(3));
        q3_optionC.setText(questions.get(2).get(4));
        q3_optionD.setText(questions.get(2).get(5));

        q4_optionA.setText(questions.get(3).get(2));
        q4_optionB.setText(questions.get(3).get(3));
        q4_optionC.setText(questions.get(3).get(4));
        q4_optionD.setText(questions.get(3).get(5));

        q5_optionA.setText(questions.get(4).get(2));
        q5_optionB.setText(questions.get(4).get(3));
        q5_optionC.setText(questions.get(4).get(4));
        q5_optionD.setText(questions.get(4).get(5));

        if (eval) {
            evaluate_questions(eval);
        }

    }


    // Method to verify if a question is correct depending
    // on the selection that the user made.
    public int check_question(RadioGroup b, int index, TextView m) {

        // First we disable all the RadioButtons from the RadioGroup b
        // to avoid the user can change the answer
        for (int i = 0; i < b.getChildCount(); i=i+1) {
            // We get each "child" (RadioButton) for the "parent" (RadioGroup)
            // and we disable it.
            b.getChildAt(i).setEnabled(false);
        }

        // Set the text that will be displayed under the options
        // with the corresponding text that explains the answer.
        m.setText("Answer: " + questions.get(index).get(7));

        // We get the option that the user selected from the question (RadioGroup b)
        int id = b.getCheckedRadioButtonId();

        // If the user did not select any question, this value will be -1
        // We do the verification only if there was a selection.
        if (id != -1) {
            // Get a reference to that specific option the user selected (RadioButton)
            RadioButton radioButton = (RadioButton) findViewById(id);

            // Get the correct answer from our data
            int answer = Integer.parseInt(questions.get(index).get(6));

            // if the text of the selected option is the same as the text of the text
            // of the proper answer, we change the color of the RadioButton to green
            // and return 1 to add it to the score.
            if (radioButton.getText() == questions.get(index).get(answer + 1)) {
                radioButton.setBackgroundColor(Color.parseColor("#c8e6c9"));
                return 1;
                // If the answer is not correct, we set the RadioButton color to red
                // and we return 0 to not add points to the score
            } else {
                radioButton.setBackgroundColor(Color.parseColor("#ef9a9a"));
                return 0;
            }
        }
        // If the user did not select any answer, we will set it as incorrect and display
        // the correct answer in red (because the user did not selected it!)
        // We return 0 to not add points to the score
        else {
            // We get the index of the proper answer to this question (RadioGroup)
            int answer = Integer.parseInt(questions.get(index).get(6));
            // We get the RadioButton that has the proper answer
            RadioButton radioButton = (RadioButton) findViewById(b.getChildAt(answer - 1).getId());

            radioButton.setBackgroundColor(Color.parseColor("#ef9a9a"));
            return 0;
        }
    }

    // Method that will check each question and keep track of the total score of the player
    public void evaluate_questions(Boolean eval) {

        // The user start with 0 points
        int result = 0;

        // Each time the answer is correct, the method will return 1
        // but if it is incorrect it will return 0, so adding up all the
        // results will not affect the total.
        result = result + check_question(q1_buttons, 0, q1_message);
        result = result + check_question(q2_buttons, 1, q2_message);
        result = result + check_question(q3_buttons, 2, q3_message);
        result = result + check_question(q4_buttons, 3, q4_message);
        result = result + check_question(q5_buttons, 4, q5_message);

        // We show a dialog to notify the user about the total score
        if (evaluated == Boolean.FALSE && eval == Boolean.FALSE)
            showResult(result);

        // After we do all this, we go automatically up to the top of the screen
        ScrollView sv = (ScrollView) findViewById(R.id.mainScrollView);
        sv.fullScroll(ScrollView.FOCUS_UP);
        evaluated = Boolean.TRUE;
    }

    // Method to configure the Dialog that the user will see once he finish the game
    public void showResult(int score) {

        // The title and content of the dialog will be set depending on the total score
        String title = "";
        String content = "";

        if (score >= 5) {
            title = "Amazing!";
            content = "You got all the answers!";
        } else if (score >= 3) {
            title = "Congratulations!";
            content = "You got " + Integer.toString(score) + "/5 correct answers!";
        } else if (score >= 1) {
            title = "Mmm...";
            content = "You got " + Integer.toString(score) + "/5 correct answers...you should practice more.";
        } else {
            title = "Ouch!";
            content = "All the answers are incorrect...it is time to study!";
        }

        // Initialisation of the dialog with all the information
        final AlertDialog dialog = new AlertDialog.Builder(Main2Activity.this)
                .setTitle(title)
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // We close the dialog when the user click OK
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    // Main method that is being executed when the Activity starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (savedInstanceState != null) {
            // If the game already started, we should keep the same questions
            // that we already have
            resume_questions_on_screen(savedInstanceState);

        } else {
            // Initialisation of the questions data (only the first time we create the activity)
            init_questions();

            // Initialisation of the elements on the Activity
            init_elements();

            // We do not want to show the answer text of each question,
            // so we set it to empty
            q1_message.setText("");
            q2_message.setText("");
            q3_message.setText("");
            q4_message.setText("");
            q5_message.setText("");

            // set questions on the screen
            set_questions_on_screen();
        }


        // When the send button is clicked, we start to evaluate the questions
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluate_questions(Boolean.FALSE);
            }
        });
        // When the player click on the Play Again button, we restart the activity
        // to get new questions.
        again_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle onState) {
        super.onSaveInstanceState(onState);

        // Sending the five questions
        onState.putStringArrayList("q1", new ArrayList<String>(questions.get(0)));
        onState.putStringArrayList("q2", new ArrayList<String>(questions.get(1)));
        onState.putStringArrayList("q3", new ArrayList<String>(questions.get(2)));
        onState.putStringArrayList("q4", new ArrayList<String>(questions.get(3)));
        onState.putStringArrayList("q5", new ArrayList<String>(questions.get(4)));

        // Saving the answers
        onState.putInt("a1", q1_buttons.getCheckedRadioButtonId());
        onState.putInt("a2", q2_buttons.getCheckedRadioButtonId());
        onState.putInt("a3", q3_buttons.getCheckedRadioButtonId());
        onState.putInt("a4", q4_buttons.getCheckedRadioButtonId());
        onState.putInt("a5", q5_buttons.getCheckedRadioButtonId());

        onState.putBoolean("eval", evaluated);
    }
}

