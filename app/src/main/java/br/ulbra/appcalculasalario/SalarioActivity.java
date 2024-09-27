package br.ulbra.appcalculasalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SalarioActivity extends AppCompatActivity {
    RadioGroup rgopCoes;
    Button btnCalcular;
    EditText edtSalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtSalario = (EditText) findViewById(R.id.edtSalario);
        rgopCoes = (RadioGroup) findViewById(R.id.rgopCoes);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double salario = Double.parseDouble(edtSalario.getText().toString());
                int op = rgopCoes.getCheckedRadioButtonId();
                double novo_salario = 0;

                if(op == R.id.rb40) {
                    novo_salario = salario + (salario * 0.4);
                }else if(op == R.id.rb45) {
                    novo_salario = salario + (salario * 0.45);
                }else {
                    novo_salario = salario + (salario * 0.5);
                }
                AlertDialog.Builder dialogo = new AlertDialog.Builder(SalarioActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setTitle("Seu novo salário é: R$" +String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}