package com.example.jessica.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoDigitacao;
    private TextView campoResultado;
    float numeroA = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoDigitacao =(TextView)findViewById(R.id.visorDigitacao);
        campoDigitacao.setText("0");


        campoResultado = (TextView)findViewById(R.id.visorResultado);
        campoResultado.setText("");
    }


    public void clicaBotao(View view){
       switch (view.getId()){

          case R.id.clear:
              campoDigitacao.setText("0");
              numeroA = 0;
              campoResultado.setText("0");
              numeroA = 0;
              operacao = "";
              break;

          case R.id.soma:
              calculaNumeros("+");
              break;

          case R.id.subtracao:
              calculaNumeros("-");
              break;

           case R.id.divisao:
               calculaNumeros("/");
               break;

           case R.id.multiplicacao:
               calculaNumeros("*");
               break;

           case R.id.igual:
               mostraResultado();
               break;

           default:
               String numb;
               numb = ((Button)view).getText().toString();
               getKeyboard(numb);
               break;

       }
    }

    public void calculaNumeros(String tipoOperacao){
        numeroA = Float.parseFloat(campoDigitacao.getText().toString());
        operacao = tipoOperacao;
        campoDigitacao.setText("0");
    }

    public void getKeyboard(String str){
        String ScrCurrent = campoDigitacao.getText().toString();
        ScrCurrent += str;
        campoDigitacao.setText(ScrCurrent);
    }

    public void mostraResultado(){
        float numeroB = Integer.parseInt(campoDigitacao.getText().toString());
        float result = 0;

        if(operacao.equals("+")){
            result = numeroA + numeroB;
            campoDigitacao.setText(campoDigitacao.getText()+"+");


        }if (operacao.equals("-")){
            result = numeroA - numeroB;
            campoDigitacao.setText(campoDigitacao.getText()+"-");

        }if(operacao.equals("*")){
            result = numeroA * numeroB;
            campoDigitacao.setText(campoDigitacao.getText()+"*");

        }if (operacao.equals("/")){
            result = numeroA / numeroB;
            campoDigitacao.setText(campoDigitacao.getText()+"/");

        }
        campoResultado.setText(String.valueOf(result));
    }



}
