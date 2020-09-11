package com.example.androidlifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SharedPreferences sharedpreferences;
    public static String text;
    public static String value;
    public static final String textFinal = "textFinal";
    SharedPreferences.Editor editor;
//    private static SharedPreferences getSharedPreference(Context context){
//        return PreferenceManager.getDefaultSharedPreferences(context);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        sharedpreferences = getSharedPreferences(text, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();


//        editText.setText(Preferences.(getBaseContext()));
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        text = editText.getText().toString();
        editor.putString(textFinal, text);
        editor.commit();
         value = sharedpreferences.getString(textFinal, "");
        Log.d("lifecycle",sharedpreferences.getString(textFinal, ""));
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
        editText.setText(value);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if (savedInstanceState != null){
            Log.d("nilai", savedInstanceState.getString("nilai"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("nilai1", "kena");
        outState.putString("nilai","hai");
    }
}