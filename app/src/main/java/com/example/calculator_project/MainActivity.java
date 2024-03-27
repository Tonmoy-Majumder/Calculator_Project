package com.example.calculator_project;

import android.os.*;
import android.widget.*;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;


public class MainActivity extends AppCompatActivity {

    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button plusButton;
    private Button minusButton;
    private Button multiplicationButton;
    private Button divisionButton;
    private Button dot;
    private Button equal;
    private Button acButton;
    //private Button clearButton;
    private Button percentageButton;
    private Button backSpaceButton;
    //private Button sqrtButton;
    private TextView display;
    boolean lastEqualPressed = false;
    String expressionToCalculate = "0";


    void displayText(String expressionSingle){

        if(lastEqualPressed){

            display.setText(expressionSingle);
            //expressionToCalculate = expressionSingle;
            lastEqualPressed = false;
        }
        else{
            /*if(expressionSingle.equals("+") || expressionSingle.equals("-") || expressionSingle.equals("×") || expressionSingle.equals("÷") || expressionSingle.equals(".") || expressionSingle.equals("%")){
                expressionToCalculate = expressionToCalculate.concat(expressionSingle);
                display.setText(expressionToCalculate);
            }*/
            if(expressionToCalculate.equals("0")) {
                display.setText(expressionSingle);
                expressionToCalculate = expressionSingle;

            }
            else {
              
                expressionToCalculate = expressionToCalculate.concat(expressionSingle);
                display.setText(expressionToCalculate);
            }
        }



    }



    void checkOperator(String expressionOperator){

        String check = expressionToCalculate.substring(expressionToCalculate.length() - 1);

        if(check.equals("+") || check.equals("-") || check.equals("×")  || check.equals("÷") || check.equals("%") || check.equals(".")){
            expressionToCalculate = expressionToCalculate.substring(0, expressionToCalculate.length() - 1).concat(expressionOperator);
            display.setText(expressionToCalculate);
        }
        else{
            displayText(expressionOperator);
        }
    }

    public static String popLastCharacter(String input) {
        if (input == null || input.isEmpty()) {
            // Handle empty or null input
            return input;
        } else {
            // Return the input string without the last character
            return input.substring(0, input.length() - 1);
        }
    }


    public  double evaluateExpression(String expressionToCalculate) {
        expressionToCalculate = expressionToCalculate.replaceAll("\\s+", "");

        double result = 0;
        double currentNumber = 0;
        char operation = '+';
        int decimalPointCount = 0; // Variable to count decimal places

        for (int i = 0; i < expressionToCalculate.length(); i++) {
            char c = expressionToCalculate.charAt(i);

            if (Character.isDigit(c)) {
                if (decimalPointCount > 0) {
                    currentNumber += (c - '0') / Math.pow(10, decimalPointCount); // Adjust for decimal point
                    decimalPointCount++;
                } else {
                    currentNumber = currentNumber * 10 + (c - '0');
                }
            } else if (c == '.') {
                decimalPointCount = 1; // Set the flag to indicate the presence of a decimal point
            }

            if (c == '%') {
                currentNumber /= 100; // Treat percentage as division by 100
            }

            if (!Character.isDigit(c) && c != '.' || i == expressionToCalculate.length() - 1) {
                switch (operation) {
                    case '+':
                        result = result + currentNumber;
                        break;
                    case '-':
                        result -= currentNumber;
                        break;
                    case '×':
                        result *= currentNumber;
                        break;
                    case '÷':
                        result /= currentNumber;
                        break;
                    default:
                        break;
                }

                operation = c;
                currentNumber = 0;
                decimalPointCount = 0; // Reset the decimal point count
            }
        }

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Initialize Button by finding its id
        oneButton = findViewById(R.id.oneButton);
        twoButton = findViewById(R.id.twoButton);
        threeButton = findViewById(R.id.threeButton);
        fourButton = findViewById(R.id.fourButton);
        fiveButton = findViewById(R.id.fiveButton);
        sixButton = findViewById(R.id.sixButton);
        sevenButton = findViewById(R.id.sevenButton);
        eightButton = findViewById(R.id.eightButton);
        nineButton = findViewById(R.id.nineButton);
        zeroButton = findViewById(R.id.zeroButton);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        divisionButton = findViewById(R.id.divisionButton);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        acButton = findViewById(R.id.acButton);
        percentageButton = findViewById(R.id.percentageButton);
        backSpaceButton = findViewById(R.id.backSpaceButton);
       // sqrtButton = findViewById(R.id.sqrtButton);
        display = findViewById(R.id.display);

        // Set OnClickListener for oneButton
        // Set OnClickListener for oneButton
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("1");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for twoButton
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("2");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for threeButton
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("3");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for fourButton
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("4");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for fiveButton
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("5");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for sixButton
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("6");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for sevenButton
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("7");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for eightButton
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("8");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for nineButton
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("9");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for zeroButton
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("0");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for plusButton
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                checkOperator("+");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for minusButton
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkOperator("-");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for multiplicationButton
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkOperator("×");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for divisionButton
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkOperator("÷");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for dotButton
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkOperator(".");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for equalButton
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle equal button click
                lastEqualPressed = true;
                String Temp = String.valueOf(evaluateExpression( expressionToCalculate));
                expressionToCalculate = "0";
                displayText(Temp);
            }
        });

// Set OnClickListener for acButton
        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle AC button click
                expressionToCalculate = "0";
                display.setText(expressionToCalculate);
            }
        });

// Set OnClickListener for percentageButton
        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle percentage button click
                checkOperator("%");
            }
        });

// Set OnClickListener for backSpaceButton
        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle plus/minus button click
                expressionToCalculate = popLastCharacter(expressionToCalculate);
                display.setText(expressionToCalculate);
            }
        });







    }
}