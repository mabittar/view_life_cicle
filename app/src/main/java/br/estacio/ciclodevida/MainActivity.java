package br.estacio.ciclodevida;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Main";
    private String[] itens;
    private int itemChecado;
    private boolean[] itemsChecados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itens = getResources().getStringArray(R.array.opcoes);
        Log.i(TAG, "Executando o metodo onCrate");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Executando o metodo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "Executando o metodo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Executando o metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Executando o metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Executando o metodo onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "Executando o metodo onRestart");
    }

    public void btnActivityClick(View view){
        Toast.makeText(MainActivity.this, "Botao Clicado", Toast.LENGTH_SHORT).show();
    }

    public void btnAlertClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setPositiveButton("OK", null);
        builder.setMessage("Caixa de Alerta");

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void btnItemClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setItems(itens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, itens[i] + " selecionada.", Toast.LENGTH_SHORT).show();


            }
        });
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void btnRadioClick(View view){
        itemChecado = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setSingleChoiceItems(itens, itemChecado, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, itens[i] + " selecionada.", Toast.LENGTH_SHORT).show();


            }
        });
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void btnCheckClick(View view){
        itemsChecados = new boolean[itens.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setMultiChoiceItems(itens, itemsChecados, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, itens[i].toString() + " selecionada.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("OK", null);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void btnDatePiker(View view){
        Calendar data = Calendar.getInstance();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String msg = String.format("%d-%d-%d", i, i1, i2);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        }, ano, mes, dia);

        dialog.setTitle(R.string.app_name);
        dialog.show();


    }

    public void btnTimePickerClick(View view){
        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int minuto = data.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String msg = String.format("%d:%d", i, i1);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, hora, minuto, true);

        dialog.setTitle(R.string.app_name);
        dialog.show();


    }
}