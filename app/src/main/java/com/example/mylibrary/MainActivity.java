 package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

 public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks,btnCurrentlyReading, btnAlreadyRead, btnWantToRead, btnFavourite, btnAbout;
    private TextView txtName, txtLisence;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CurrentlyReadingBooksActivity.class);
                startActivity(intent);
            }
        });

        btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FavouriteBooksActivity.class);
                startActivity(intent);
            }
        });

        Utils.getInstance();
    }

     private void initViews() {
         setContentView(R.layout.activity_main);
         btnAllBooks = findViewById(R.id.btnAllBooks);
         btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
         btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
         btnWantToRead = findViewById(R.id.btnWantToRead);
         btnFavourite = findViewById(R.id.btnFavourite);
         btnAbout = findViewById(R.id.btnAbout);
         txtName = findViewById(R.id.txtName);
         txtLisence = findViewById(R.id.txtLicense);
         imgLogo = findViewById(R.id.imgLogo);
     }
 }