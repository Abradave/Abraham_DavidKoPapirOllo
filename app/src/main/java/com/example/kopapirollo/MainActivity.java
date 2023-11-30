package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView emberImg;
    private ImageView gepImg;
    private TextView emberResult;
    private TextView gepResult;
    private Button btnKo;
    private Button btnPapir;
    private Button btnOllo;
    private int gepRandom;
    private int emberScore;
    private int gepScore;


    private AlertDialog.Builder alertdialog;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnKo.setOnClickListener(v -> {
            emberImg.setImageResource(R.drawable.rock);
            gepRandom = random.nextInt(3);
            gepChoice();
            check();
            if (gepRandom == 0){
                Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                emberScore += 0;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            } else if (gepRandom == 1) {
                Toast.makeText(MainActivity.this, "A Gép nyert!", Toast.LENGTH_SHORT).show();
                emberScore += 0;
                gepScore += 1;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            }
            else {
                Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
                emberScore += 1;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            }
        });
        btnPapir.setOnClickListener(v -> {
            emberImg.setImageResource(R.drawable.paper);
            gepRandom = random.nextInt(3);
            gepChoice();
            check();
            if (gepRandom == 0){
                Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
                emberScore += 1;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            } else if (gepRandom == 1) {
                emberScore += 0;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
                Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
                emberScore += 0;
                gepScore += 1;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            }
        });
        btnOllo.setOnClickListener(v -> {
            emberImg.setImageResource(R.drawable.scissors);
            gepRandom = random.nextInt(3);
            gepChoice();
            check();
            if (gepRandom == 0){
                Toast.makeText(MainActivity.this, "A Gép nyert!", Toast.LENGTH_SHORT).show();
                emberScore += 0;
                gepScore += 1;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            } else if (gepRandom == 1) {
                Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
                emberScore += 1;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            }
            else {
                Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                emberScore += 0;
                gepScore += 0;
                gepResult.setText(String.valueOf(gepScore));
                emberResult.setText(String.valueOf(emberScore));
            }
        });
    }

    public void init(){
        emberImg = findViewById(R.id.emberimg);
        gepImg = findViewById(R.id.gepimg);
        btnKo = findViewById(R.id.btnko);
        btnPapir = findViewById(R.id.btnpapir);
        btnOllo = findViewById(R.id.btnollo);
        emberScore = 0;
        gepScore = 0;
        emberResult = findViewById(R.id.ember);
        gepResult = findViewById(R.id.gep);
        alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Vége a játéknak");
        alertdialog.setMessage("Szeretnél új játékot?");
        alertdialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertdialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        });
        alertdialog.setCancelable(false);
    }

    public int gepChoice(){
        if (gepRandom == 0){
            gepImg.setImageResource(R.drawable.rock);
        } else if (gepRandom == 1) {
            gepImg.setImageResource(R.drawable.paper);
        }
        else {
            gepImg.setImageResource(R.drawable.scissors);
        }
        return gepRandom;
    }

    public void newGame(){
        emberScore = 0;
        gepScore = 0;
        gepResult.setText(String.valueOf(gepScore));
        emberResult.setText(String.valueOf(emberScore));
    }

    public void check(){
        if (emberScore == 3 || gepScore == 3){
            alertdialog.show();
        }
    }
}