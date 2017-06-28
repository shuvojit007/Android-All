package com.example.shobojit.onesignaldemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import static android.provider.CalendarContract.CalendarCache.URI;

public class Main3Activity extends AppCompatActivity {
    SimpleDraweeView draweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String value = getIntent().getExtras().getString("img");
        /*final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);*/
        Uri uri = Uri.parse(value);
            draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
            draweeView.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
            draweeView.setImageURI(uri);
    }
    public class ImageLoadProgressBar extends ProgressBarDrawable {


        float level;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int color = R.color.colorPrimary;

        final RectF oval = new RectF();

        int radius = 10;

        public ImageLoadProgressBar(){
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected boolean onLevelChange(int level) {
            this.level = level;
            invalidateSelf();
            return true;
        }

        @Override
        public void draw(Canvas canvas) {
            oval.set(canvas.getWidth() / 2 - radius, canvas.getHeight() / 2 - radius,
                    canvas.getWidth() / 2 + radius, canvas.getHeight() / 2 + radius);

            drawCircle(canvas, level, color);
        }


        private void drawCircle(Canvas canvas, float level, int color) {
            paint.setColor(color);
            float angle;
            angle = 360 / 1f;
            angle = level * angle;
            canvas.drawArc(oval, 0, Math.round(angle), false, paint);
        }

    }
}
