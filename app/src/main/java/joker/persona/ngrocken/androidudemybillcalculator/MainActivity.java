package joker.persona.ngrocken.androidudemybillcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText noOfPeopleEdtTxt;
    private EditText costOfBillEdtTxt;
    private TextView resultTxtView;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strPeople = noOfPeopleEdtTxt.getText().toString();
                    int peopleCount = Integer.parseInt(strPeople);

                    String strCost = costOfBillEdtTxt.getText().toString();
                    double cost = Double.parseDouble(strCost);

                    resultTxtView.setText("The cost per person is $" + calculateBill(peopleCount, cost));

                } catch (Exception ex) {

                }

            }
        });
    }

    private void setUpViews() {
        noOfPeopleEdtTxt = findViewById(R.id.main_edit_no_of_people);
        costOfBillEdtTxt = findViewById(R.id.main_edit_bill_cost);

        resultTxtView = findViewById(R.id.main_txt_result);
        calculateBtn = findViewById(R.id.main_btn_calc);

    }

    private double calculateBill(int memberCount, double bill) {
        BigDecimal decimal = new BigDecimal(bill/memberCount);
        decimal = decimal.setScale(2, RoundingMode.UP);
        return decimal.doubleValue();

    }
}
