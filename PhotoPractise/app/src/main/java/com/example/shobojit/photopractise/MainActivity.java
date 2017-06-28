package com.example.shobojit.photopractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.jeancsanchez.photoviewslider.PhotosViewSlider;

public class MainActivity extends AppCompatActivity {
    PhotosViewSlider photoViewSlider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoViewSlider = (PhotosViewSlider) findViewById(R.id.photosViewSlider);
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/17021855_1397687256959254_320853815736305706_n.jpg?oh=d85021917c73eff6fa88ef6ff35ec126&oe=5964883B", "Shuvojit Kar Manna");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14203271_1207281255999856_3606913486676649205_n.jpg?oh=bf3d6e83fe770042c8eb97c2357aba5d&oe=596B88FF","Prisma Effect");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12474009_1067022200025763_4105979473522221035_o.jpg?oh=c7802bef9ea51dcee07bb6c2f5da69ef&oe=5968F9FE","Palki Restaurent");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12661784_1065384853522831_255781304862669646_n.jpg?oh=67aec4faf04c98dba96ef655fc5e3059&oe=59671FE4","Keyahagat");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12548866_1052629758131674_2239969277112863433_n.jpg?oh=010f769f80bb5983115e60d06626e271&oe=5973CE3D","American Corner");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707655_956088447785806_7953393621807768804_n.jpg?oh=349fb7704df1085b346bf8e8db44684d&oe=59610905","River Side");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/17021855_1397687256959254_320853815736305706_n.jpg?oh=d85021917c73eff6fa88ef6ff35ec126&oe=5964883B", "Shuvojit Kar Manna");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14203271_1207281255999856_3606913486676649205_n.jpg?oh=bf3d6e83fe770042c8eb97c2357aba5d&oe=596B88FF","Prisma Effect");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12474009_1067022200025763_4105979473522221035_o.jpg?oh=c7802bef9ea51dcee07bb6c2f5da69ef&oe=5968F9FE","Palki Restaurent");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12661784_1065384853522831_255781304862669646_n.jpg?oh=67aec4faf04c98dba96ef655fc5e3059&oe=59671FE4","Keyahagat");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12548866_1052629758131674_2239969277112863433_n.jpg?oh=010f769f80bb5983115e60d06626e271&oe=5973CE3D","American Corner");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707655_956088447785806_7953393621807768804_n.jpg?oh=349fb7704df1085b346bf8e8db44684d&oe=59610905","River Side");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/17021855_1397687256959254_320853815736305706_n.jpg?oh=d85021917c73eff6fa88ef6ff35ec126&oe=5964883B", "Shuvojit Kar Manna");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14203271_1207281255999856_3606913486676649205_n.jpg?oh=bf3d6e83fe770042c8eb97c2357aba5d&oe=596B88FF","Prisma Effect");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12474009_1067022200025763_4105979473522221035_o.jpg?oh=c7802bef9ea51dcee07bb6c2f5da69ef&oe=5968F9FE","Palki Restaurent");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12661784_1065384853522831_255781304862669646_n.jpg?oh=67aec4faf04c98dba96ef655fc5e3059&oe=59671FE4","Keyahagat");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12548866_1052629758131674_2239969277112863433_n.jpg?oh=010f769f80bb5983115e60d06626e271&oe=5973CE3D","American Corner");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707655_956088447785806_7953393621807768804_n.jpg?oh=349fb7704df1085b346bf8e8db44684d&oe=59610905","River Side");

        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/17021855_1397687256959254_320853815736305706_n.jpg?oh=d85021917c73eff6fa88ef6ff35ec126&oe=5964883B", "Shuvojit Kar Manna");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14203271_1207281255999856_3606913486676649205_n.jpg?oh=bf3d6e83fe770042c8eb97c2357aba5d&oe=596B88FF","Prisma Effect");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12474009_1067022200025763_4105979473522221035_o.jpg?oh=c7802bef9ea51dcee07bb6c2f5da69ef&oe=5968F9FE","Palki Restaurent");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12661784_1065384853522831_255781304862669646_n.jpg?oh=67aec4faf04c98dba96ef655fc5e3059&oe=59671FE4","Keyahagat");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12548866_1052629758131674_2239969277112863433_n.jpg?oh=010f769f80bb5983115e60d06626e271&oe=5973CE3D","American Corner");
        photoViewSlider.setPhotoUrl("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707655_956088447785806_7953393621807768804_n.jpg?oh=349fb7704df1085b346bf8e8db44684d&oe=59610905","River Side");


        photoViewSlider.initializePhotos();
    }
}
