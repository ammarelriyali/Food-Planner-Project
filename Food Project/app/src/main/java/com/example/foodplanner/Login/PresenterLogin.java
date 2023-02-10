package com.example.foodplanner.Login;

import android.app.Activity;

import com.example.foodplanner.reomtlydatabase.DatabaseConnection;

public class PresenterLogin implements NetworkDelegate{
    private DatabaseConnection  databaseConnection ;
    private Communication communication;

    public PresenterLogin(DatabaseConnection databaseConnection, Communication communication) {
        this.databaseConnection = databaseConnection;
        this.communication = communication;
    }

    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void login(String email , String password) {
        databaseConnection.login(email,password,this);
    }

    @Override
    public void onSuccessful() {
        communication.login();

    }

    @Override
    public void onFailure(String msg) {
        communication.onFailure(msg);

    }


}
