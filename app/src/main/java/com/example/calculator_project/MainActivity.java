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
    private Button plusMinusButton;
    private Button sqrtButton;
    private TextView display;
    String expressionToCalculate = "0";

    void displayText(String expressionSingle){
        if(expressionToCalculate == "0") {
            display.setText(expressionSingle);
            expressionToCalculate = expressionSingle;
        }else {
            expressionToCalculate = expressionToCalculate.concat(expressionSingle);
            display.setText(expressionToCalculate);
        }
    }


    public static double evaluateExpression(String expressionToCalculate) {
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
            if (c == '√') {
                currentNumber = Math.sqrt(currentNumber); // Square root operation
            }

            if (!Character.isDigit(c) && c != '.' && c != '√' || i == expressionToCalculate.length() - 1) {
                switch (operation) {
                    case '+':
                        result += currentNumber;
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
        //clearButton = findViewById(R.id.clearbutton);
        percentageButton = findViewById(R.id.percentageButton);
        plusMinusButton = findViewById(R.id.plusMinusButton);
        sqrtButton = findViewById(R.id.sqrtButton);
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
                displayText("+");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for minusButton
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("-");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for multiplicationButton
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("×");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for divisionButton
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText("÷");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for dotButton
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText(".");
                // Update display or perform any other action needed
            }
        });

// Set OnClickListener for equalButton
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle equal button click
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

// Set OnClickListener for clearButton
       /* clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle clear button click
                expressionToCalculate = "0";
                display.setText(expressionToCalculate);
            }
        });*/

// Set OnClickListener for percentageButton
        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle percentage button click
                displayText("%");
            }
        });

// Set OnClickListener for plusMinusButton
        plusMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle plus/minus button click
            }
        });

// Set OnClickListener for sqrtButton
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Handle square root button click
                displayText("√");
            }
        });





    }
}