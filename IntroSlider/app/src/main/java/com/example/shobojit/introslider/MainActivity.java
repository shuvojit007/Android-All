package com.example.shobojit.introslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import static com.example.shobojit.introslider.R.id.wrap_content;

public class MainActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("SiuRoutine", "Which Makes ur Life Easier ",R.mipmap.ic_launcher);
        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard1.setTitleColor(R.color.white);
        ahoyOnboarderCard1.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard1.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard1.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard1.setIconLayoutParams(300, 300,200,5,5,5);


    String s = "There are many nice words in this paragraph, but it really works!\n" +
            "\n" +
            "Unfortunately at the first glance you will mention that the most of screenshots for this tool is on iPhone devices, and they didn’t mention that we can use it for Android, too.";
            String s2 = "The familiarity of visual editing with the flexibility of code. A seamless workflow, further complemented by device previewing, version control and easy sharing. Pioneer new interaction patterns and create groundbreaking apps. The design and prototyping tool preferred by product teams at startups, agencies and Fortune 500s worldwide. ";

        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Shuvojit Kkar ", s,R.mipmap.wifi);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setTitleColor(R.color.white);
        ahoyOnboarderCard2.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard2.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard2.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard2.setIconLayoutParams(100, 100, 10, 10, 10, 10);

        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Sazzadur Rahasmf", s2,R.mipmap.wifi);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setTitleColor(R.color.white);
        ahoyOnboarderCard3.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard3.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard3.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard3.setIconLayoutParams(100, 100, 10, 10, 10, 10);
        List<AhoyOnboarderCard> list = new ArrayList<>();
        list.add(ahoyOnboarderCard1);
        list.add(ahoyOnboarderCard2);
        list.add(ahoyOnboarderCard3);
        setOnboardPages(list);
        setGradientBackground();
    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(getApplicationContext(),"Shuvojit Kar ",Toast.LENGTH_SHORT).show();
    }
}
