package comlandmarkbook.apk.ctyandnamegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.FileObserver;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class NormalGame extends AppCompatActivity {
    String cauntryAll, s3, hyphen;
    ArrayList<Character> arrayListcut;
    int number1, temp1 = 0, temp2 = 5,first=0;
    Random random;
    TextView ask, question, ansver;
    Button bell, skor;
    private String[] caunty = {"ADANA","KOCAELİ","ADIYAMAN","KONYA","AFYONKARAHİSAR", "KÜTAHYA", "AĞRI", "MALATYA",
            "AMASYA", "MANİSA", "ANKARA", "KAHRAMANMARAŞ", "ANTALYA", "MARDİN", "ARTVİN", "MUĞLA", "AYDIN", "MUŞ",
            "BALIKESİR", "NEVŞEHİR", "BİLECİK", "NİĞDE", "BİNGÖL", "ORDU", "BİTLİS", "RİZE ", "BOLU", "SAKARYA", "BURDUR", "SAMSUN",
            "BURSA", "SİİRT", "ÇANAKKALE", "SİNOP ", "ÇANKIRI", "SİVAS", "ÇORUM", "TEKİRDAĞ", "DENİZLİ", "TOKAT",
            "DİYARBAKIR", "TRABZON", "EDİRNE", "TUNCELİ", "ELAZIĞ", "ŞANLIURFA", "ERZİNCAN", "UŞAK", "ERZURUM", "VAN",
            "ESKİŞEHİR", "YOZGAT", "GAZİANTEP", "ZONGULDAK", "GİRESUN", "AKSARAY", "GÜMÜŞHANE", "BAYBURT",
            "HAKKARİ", "KARAMAN", "HATAY", "KIRIKKALE", "ISPARTA", "BATMAN", "MERSİN", "ŞIRNAK", "İSTANBUL", "BARTIN",
            "İZMİR", "ARDAHAN", "KARS", "IĞDIR", "KASTAMONU", "YALOVA", "KAYSERİ", "KARABÜK", "KIRKLARELİ", "KİLİS",
            "KIRŞEHİR","OSMANİYE","DÜZCE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);
        bell = (Button) findViewById(R.id.btnBell);
        skor = (Button) findViewById(R.id.btnSkor);
        ask = (TextView) findViewById(R.id.textAsk);
        question = (TextView) findViewById(R.id.textQuestion);
        ansver = (EditText) findViewById(R.id.edittextprediction);
        //can sayısı,skor
        String s1 = String.valueOf(temp1);
        String s2 = String.valueOf(temp2);
        bell.setText(s2);
        skor.setText(s1);
        again();
        if (cauntryAll.length()>=0){
            first=1;
        }
        if (cauntryAll.length()>=5){
            first=2;
        }
        if (cauntryAll.length()>=7){
            first=3;
        }
        if (cauntryAll.length()>=10){
            first=4;
        }
        for(int k=0 ; k<first;k++) {
            firstchar();

        }


    }


    public void btnansver(View view) {
        s3 = ansver.getText().toString();
        if (!TextUtils.isEmpty(s3)) {
            if (s3.equals(cauntryAll)) {
                Toast.makeText(NormalGame.this, "DOĞRU TAHMİN", Toast.LENGTH_LONG).show();
                temp2+=2;
                temp1 += 1;
                String s1 = String.valueOf(temp1);
                String s2 = String.valueOf(temp2);
                skor.setText(s1);
                bell.setText(s2);
                ansver.setText("");
                again();
                for(int k=0 ; k<1;k++) {
                    firstchar();
                    firstchar();
                }

            } else {
                Toast.makeText(NormalGame.this, "YANLIŞ TAHMİN", Toast.LENGTH_LONG).show();
                temp2--;
                String s2 = String.valueOf(temp2);
                bell.setText(s2);
                ansver.setText("");
                int i = Integer.valueOf((String) bell.getText());
                if (i < 0) {
                    MainActivity mainActivity=new MainActivity();
                    Toast.makeText(NormalGame.this, "KAYBETTİNİZ!!  SKORUN :" + skor.getText(), Toast.LENGTH_SHORT).show();
                    mainActivity.buttonSave.setText(skor.toString());
                    finish();
                }
                again();
                for(int k=0 ; k<1;k++) {
                    firstchar();
                    firstchar();
                }
            }
        } else {
            Toast.makeText(NormalGame.this, "TAHMİN KISMI BOŞ OLAMAZ", Toast.LENGTH_SHORT).show();

        }
    }

    //button harf al
    public void btnChar(View view) {
        temp2--;
        String s2 = String.valueOf(temp2);
        bell.setText(s2);
        int i = Integer.valueOf((String) bell.getText());
        if (i < 0) {
            Toast.makeText(NormalGame.this, "KAYBETTİNİZ!!  SKORUN :" + skor.getText(), Toast.LENGTH_LONG).show();
            finish();
        }

    firstchar();
    }

    public void again() {
        hyphen = "";
        random = new Random();
        number1 = random.nextInt(caunty.length);
        cauntryAll = caunty[number1];
        //ilin - uzunlugunu bulduk
        ask.setText(cauntryAll.length() + " Harfli İlimiz");

        for (int i = 0; i < cauntryAll.length(); i++) {
            if (cauntryAll.length() > i)
                hyphen += "_ ";
            else
                hyphen += "_";
            question.setText(hyphen);
        //ilin harflerini parçalarına ayırma
            arrayListcut = new ArrayList<>();
            for (char c : cauntryAll.toCharArray()) {
                arrayListcut.add(c);
            }


        }
    }

    public void firstchar() {
        if (arrayListcut.size() > 0) {
            number1 = random.nextInt(arrayListcut.size());
            String[] txtChar = question.getText().toString().split(" ");
            char[] comeCauntryChar = cauntryAll.toCharArray();
            for (int i = 0; i <cauntryAll.length(); i++) {
                if (txtChar[i].equals("_") && comeCauntryChar[i] == arrayListcut.get(number1)) {
                    txtChar[i] = String.valueOf(comeCauntryChar[i]);
                    hyphen = "";
                    for (int j = 0; j < cauntryAll.length(); j++) {
                        if (i == j) {
                            hyphen += txtChar[j] + " ";
                        } else {
                            hyphen += txtChar[j] + " ";
                        }

                    }
                 break;
                }

            }
        }
        if (arrayListcut.size() > 0) {
            question.setText(hyphen);
            arrayListcut.remove(number1);
        }

    }


}