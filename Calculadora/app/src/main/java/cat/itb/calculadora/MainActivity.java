package cat.itb.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView proves;
    private boolean active = false;
    private String n1, n2;

    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private Button b_divisio, b_multiplicacio, b_resta, b_suma, b_decimal, b_igual, b_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proves = (TextView) findViewById(R.id.proves);
        editText = (EditText) findViewById(R.id.edittext);
        editText.setEnabled(false);
        b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(this);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(this);
        b_divisio = (Button) findViewById(R.id.divisio);
        b_divisio.setOnClickListener(this);
        b_multiplicacio = (Button) findViewById(R.id.multiplicacio);
        b_multiplicacio.setOnClickListener(this);
        b_resta = (Button) findViewById(R.id.resta);
        b_resta.setOnClickListener(this);
        b_suma = (Button) findViewById(R.id.suma);
        b_suma.setOnClickListener(this);
        b_decimal = (Button) findViewById(R.id.decimal);
        b_decimal.setOnClickListener(this);
        b_igual = (Button) findViewById(R.id.igual);
        b_igual.setOnClickListener(this);
        b_clear = (Button) findViewById(R.id.clear);
        b_clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String str = b.getText().toString();
        if (!str.isEmpty()) {
            switch (str) {
                case "/":
                    break;
                case "*":
                    if (!active) {
                        n1 = editText.getText().toString();
                        proves.setText(n1);
                        editText.getText().clear();
                        active = true;
                    }else{
                        //calcular
                    }

                    break;
                case "-":
                    break;
                case "+":
                    break;
                case "=":
                    if (active){
                        n2 = editText.getText().toString();
                        proves.setText(n2);
                        editText.getText().clear();
                        active = false;
                        multiplicar(n1,n2);
                    }
                    break;
                case ".":
                    break;
                case "C":
                    active = false;
                    editText.getText().clear();
                    break;
                default:
                    afegir(str);
                    break;
            }
        } else {
            afegir(str);
        }

    }

    public void afegir(String str) {
        String aux = editText.getText().toString();
        editText.setText(aux.concat(str));
    }

    public void multiplicar(String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int aux = num1 * num2;
        String res = String.valueOf(aux);
        //editText.setText(res);
        proves.setText(res);

    }
}

