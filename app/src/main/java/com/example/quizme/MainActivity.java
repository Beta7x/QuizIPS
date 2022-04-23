package com.example.quizme;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.quizme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        this.setTitle("Quiz IPS");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        binding.bottomBar.setOnItemSelectedListener(i -> {
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            switch (i) {
                case 0:
                    transaction1.replace(R.id.content, new HomeFragment());
                    transaction1.commit();
                    break;
                case 1:
                    transaction1.replace(R.id.content, new LeaderboardsFragment());
                    transaction1.commit();
                    break;
                case 2:
                    transaction1.replace(R.id.content, new WalletFragment());
                    transaction1.commit();
                    break;
                case 3:
                    transaction1.replace(R.id.content, new ProfileFragment());
                    transaction1.commit();
                    break;
            }
            return false;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.wallet) {
            Toast.makeText(this, "wallet is clicked.", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}