package com.example.foodplanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.foodplanner.DBConnection.localdatabase.ConcreteLocalData;
import com.example.foodplanner.DBConnection.reomtlydatabase.FireBaseConnection;
import com.example.foodplanner.Helper.CheckConnection;
import com.example.foodplanner.Helper.Tags;
import com.example.foodplanner.Login.PresenterLogin;
import com.example.foodplanner.databinding.ActivityMainBinding;
import com.example.foodplanner.meal.MealActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    private ActivityMainBinding binding;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    String personEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

         navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        NavigationUI.setupWithNavController(binding.navView, navController);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            System.out.println(personName);
            System.out.println(personEmail);
            /*if (CheckConnection.isConnect(getApplicationContext())) {
                PresenterLogin presenterLogin = new PresenterLogin(new FireBaseConnection(), this);
                presenterLogin.login(personEmail,personName);
            } else {
                //Snackbar.make(personEmail, "No Internet Connection", Snackbar.LENGTH_LONG)
                     //   .show();
            }*/
        }






    }

    /*public void login() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.userEmail), personEmail);
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }*/
    public void goToMeal(View view) {
        Intent intent=new Intent(this, MealActivity.class);
        intent.putExtra(Tags.TAG_ID_INTENT,view.getTag().toString());
        startActivity(intent);

    }

    public void addToPlan(View view) {
        navController.navigate(R.id.navigation_search);
        new Thread(()->{   ConcreteLocalData db;
            db=ConcreteLocalData.getInstance(this);}).start();

    }

}
