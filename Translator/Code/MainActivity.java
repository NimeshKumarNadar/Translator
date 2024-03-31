package com.example.translator;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    ImageView help;
    Button clear, translate;
    EditText edittext;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        help = findViewById(R.id.help);
        clear = findViewById(R.id.clear);
        translate = findViewById(R.id.translate);
        edittext = findViewById(R.id.edittext);
        textview = findViewById(R.id.textview);

        Spinner spinner = findViewById(R.id.languages_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setText("");
                textview.setText("");
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String language = spinner.getSelectedItem().toString();
                String input = edittext.getText().toString();

                if (input.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter text", Toast.LENGTH_SHORT).show();

                }

                if (language.equals("German")) {
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                                    .setTargetLanguage(TranslateLanguage.GERMAN)
                                    .build();
                    final Translator englishGermanTranslator =
                            Translation.getClient(options);

                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    englishGermanTranslator.downloadModelIfNeeded(conditions);
                    englishGermanTranslator.translate(input)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            textview.setText(translatedText);
                                            englishGermanTranslator.close();
                                        }
                                    });


                } else if (language.equals("French")) {
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                                    .setTargetLanguage(TranslateLanguage.FRENCH)
                                    .build();
                    final Translator englishFrenchTranslator =
                            Translation.getClient(options);

                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    englishFrenchTranslator.downloadModelIfNeeded(conditions);
                    englishFrenchTranslator.translate(input)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            textview.setText(translatedText);
                                            englishFrenchTranslator.close();
                                        }
                                    });
                } else if (language.equals("Hindi")) {
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                                    .setTargetLanguage(TranslateLanguage.HINDI)
                                    .build();
                    final Translator englishHindiTranslator =
                            Translation.getClient(options);

                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    englishHindiTranslator.downloadModelIfNeeded(conditions);
                    englishHindiTranslator.translate(input)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            textview.setText(translatedText);
                                            englishHindiTranslator.close();
                                        }
                                    });
                }else if (language.equals("Kannada")) {
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                                    .setTargetLanguage(TranslateLanguage.KANNADA)
                                    .build();
                    final Translator englishKannadaTranslator =
                            Translation.getClient(options);

                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    englishKannadaTranslator.downloadModelIfNeeded(conditions);
                    englishKannadaTranslator.translate(input)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            textview.setText(translatedText);
                                            englishKannadaTranslator.close();
                                        }
                                    });
                }else if (language.equals("Spanish")) {
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                                    .setTargetLanguage(TranslateLanguage.SPANISH)
                                    .build();
                    final Translator englishSpanishTranslator =
                            Translation.getClient(options);

                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    englishSpanishTranslator.downloadModelIfNeeded(conditions);
                    englishSpanishTranslator.translate(input)
                            .addOnSuccessListener(
                                    new OnSuccessListener<String>() {
                                        @Override
                                        public void onSuccess(@NonNull String translatedText) {
                                            textview.setText(translatedText);
                                            englishSpanishTranslator.close();
                                        }
                                    });
                }else {
                    Toast.makeText(getApplicationContext(),"Please select a language to translate into", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void onButtonShowPopupWindowClick(View view) {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.help_popup_window, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}