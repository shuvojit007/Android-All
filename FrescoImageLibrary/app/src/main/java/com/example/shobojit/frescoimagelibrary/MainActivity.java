package com.example.shobojit.frescoimagelibrary;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
public class MainActivity extends AppCompatActivity {
    SimpleDraweeView im1,im2,im3,im4,im5;
    Uri uri1,uri2,uri3,uri4,uri5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im1 = (SimpleDraweeView) findViewById(R.id.img1);
        im2 = (SimpleDraweeView) findViewById(R.id.img2);
        im3 = (SimpleDraweeView) findViewById(R.id.img3);
        im4 = (SimpleDraweeView) findViewById(R.id.img4);
        im5 = (SimpleDraweeView) findViewById(R.id.img5);
        uri1 = Uri.parse("https://www.lamborghini.com/en-en/sites/en-en/files/DAM/it/models_gateway/blocks/special.png");
        uri2 = Uri.parse("https://s-media-cache-ak0.pinimg.com/736x/fa/a7/8a/faa78a27e2ae99624db8d141e023aab4.jpg");
        uri3 = Uri.parse("https://www.lamborghini.com/en-en/sites/en-en/files/DAM/lamborghini/share%20img/aventador-coupe-facebook-og.jpg");
        uri4 = Uri.parse("http://s1.cdn.autoevolution.com/images/news/ad-personam-lamborghini-aventador-sv-has-matte-carbon-roof-109916_1.jpg");
        uri5 = Uri.parse("http://gearheads.org/wp-content/uploads/2016/07/ad-personam-lamborghini-aventador-sv-has-matte-carbon-roof_1.jpg");
        String path="res:/" + R.drawable.des;
        im1.setImageURI(uri1);
        im2.setImageURI(uri2);
        im3.setImageURI(uri3);
        im4.setImageURI(uri4);
        im5.setImageURI(Uri.parse("res:/" + R.drawable.des));
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Image Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
