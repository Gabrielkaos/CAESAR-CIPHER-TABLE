package com.example.jabogaaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String inputs,alphabet;
    private int k;
    private int m;

    Map<Character, Character> for_enc = new HashMap<>();
    Map<Character, Character> for_dec= new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText outputText=findViewById(R.id.outputTEXT);

        alphabet = "abcdefghijklmnopqrstuvwxyz";

        outputText.setFocusable(false);
        outputText.setClickable(false);
    }

    public void generate_table(View view){
        EditText M_val=findViewById(R.id.m_val);
        EditText K_val=findViewById(R.id.k_val);

        m = Integer.parseInt(M_val.getText().toString());
        k = Integer.parseInt(K_val.getText().toString());



        ArrayList<TextView> Moved = new ArrayList<>();
        
        Moved.add(findViewById(R.id.id1));
        Moved.add(findViewById(R.id.id2));
        Moved.add(findViewById(R.id.id3));
        Moved.add(findViewById(R.id.id4));
        Moved.add(findViewById(R.id.id5));
        Moved.add(findViewById(R.id.id6));
        Moved.add(findViewById(R.id.id7));
        Moved.add(findViewById(R.id.id8));
        Moved.add(findViewById(R.id.id9));
        Moved.add(findViewById(R.id.id10));
        Moved.add(findViewById(R.id.id11));
        Moved.add(findViewById(R.id.id12));

        Moved.add(findViewById(R.id.id13));
        Moved.add(findViewById(R.id.id14));
        Moved.add(findViewById(R.id.id15));
        Moved.add(findViewById(R.id.id16));
        Moved.add(findViewById(R.id.id17));
        Moved.add(findViewById(R.id.id18));
        Moved.add(findViewById(R.id.id19));
        Moved.add(findViewById(R.id.id20));
        Moved.add(findViewById(R.id.id21));
        Moved.add(findViewById(R.id.id22));
        Moved.add(findViewById(R.id.id23));
        Moved.add(findViewById(R.id.id24));

        Moved.add(findViewById(R.id.id25));
        Moved.add(findViewById(R.id.id26));

        ArrayList<TextView> Ciphers = new ArrayList<>();

        Ciphers.add(findViewById(R.id.d1));
        Ciphers.add(findViewById(R.id.d2));
        Ciphers.add(findViewById(R.id.d3));
        Ciphers.add(findViewById(R.id.d4));
        Ciphers.add(findViewById(R.id.d5));
        Ciphers.add(findViewById(R.id.d6));
        Ciphers.add(findViewById(R.id.d7));
        Ciphers.add(findViewById(R.id.d8));
        Ciphers.add(findViewById(R.id.d9));
        Ciphers.add(findViewById(R.id.d10));
        Ciphers.add(findViewById(R.id.d11));
        Ciphers.add(findViewById(R.id.d12));

        Ciphers.add(findViewById(R.id.d13));
        Ciphers.add(findViewById(R.id.d14));
        Ciphers.add(findViewById(R.id.d15));
        Ciphers.add(findViewById(R.id.d16));
        Ciphers.add(findViewById(R.id.d17));
        Ciphers.add(findViewById(R.id.d18));
        Ciphers.add(findViewById(R.id.d19));
        Ciphers.add(findViewById(R.id.d20));
        Ciphers.add(findViewById(R.id.d21));
        Ciphers.add(findViewById(R.id.d22));
        Ciphers.add(findViewById(R.id.d23));
        Ciphers.add(findViewById(R.id.d24));

        Ciphers.add(findViewById(R.id.d25));
        Ciphers.add(findViewById(R.id.d26));

        for(int i = 0; i < alphabet.length(); ++i){
            Moved.get(i).setText(String.valueOf((m * i + k) % alphabet.length()));
            Ciphers.get(i).setText(String.valueOf(alphabet.charAt((m * i + k) % alphabet.length())).toUpperCase());
        }
    }

    public void encrypt_button(View view){
        EditText inputText=findViewById(R.id.inputTEXT);
        EditText M_val=findViewById(R.id.m_val);
        EditText K_val=findViewById(R.id.k_val);

        inputs = inputText.getText().toString().toLowerCase();
        m = Integer.parseInt(M_val.getText().toString());
        k = Integer.parseInt(K_val.getText().toString());

        for(int i = 0;i<alphabet.length();++i){
            for_enc.put(alphabet.charAt(i),alphabet.charAt((m*i+k) % alphabet.length()));
            for_dec.put(alphabet.charAt((m*i+k) % alphabet.length()),alphabet.charAt(i));
        }

        StringBuilder new_str = new StringBuilder();
        for(int i=0;i<inputs.length();++i){
            char at_index = inputs.charAt(i);
            if(for_enc.containsKey(at_index)){
                new_str.append(for_enc.get(at_index));
            }else{
                new_str.append(" ");
            }
        }

        EditText outputText=findViewById(R.id.outputTEXT);
        outputText.setText(new_str.toString());
    }

    public void decrypt_button(View view){
        EditText inputText=findViewById(R.id.inputTEXT);
        EditText M_val=findViewById(R.id.m_val);
        EditText K_val=findViewById(R.id.k_val);

        inputs = inputText.getText().toString().toLowerCase();
        m = Integer.parseInt(M_val.getText().toString());
        k = Integer.parseInt(K_val.getText().toString());

        for(int i = 0;i<alphabet.length();++i){
            for_enc.put(alphabet.charAt(i),alphabet.charAt((m*i+k) % alphabet.length()));
            for_dec.put(alphabet.charAt((m*i+k) % alphabet.length()),alphabet.charAt(i));
        }

        StringBuilder new_str = new StringBuilder();
        for(int i=0;i<inputs.length();++i){
            char at_index = inputs.charAt(i);
            if(for_dec.containsKey(at_index)){
                new_str.append(for_dec.get(at_index));
            }else{
                new_str.append(" ");
            }

        }

        EditText outputText=findViewById(R.id.outputTEXT);
        outputText.setText(new_str.toString());
    }
}