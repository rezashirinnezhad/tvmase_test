package test.reza.tvmaze.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import test.reza.tvmaze.R;
import test.reza.tvmaze.model.Show;

public class ShowDetailsActivity extends AppCompatActivity {

    /**
     * Selected Show in Shows List
     */
    private Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Button back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView poster = (ImageView) findViewById(R.id.poster);
        TextView  name = (TextView) findViewById(R.id.title);
        TextView  schedule = (TextView) findViewById(R.id.schedule);
        TextView  genres = (TextView) findViewById(R.id.genres);
        TextView  runtime = (TextView) findViewById(R.id.runtime);
        TextView  summary = (TextView) findViewById(R.id.summary);
        TextView  site = (TextView) findViewById(R.id.site);
        TextView  rating = (TextView) findViewById(R.id.rating);

        Bundle bundle = getIntent().getExtras();
        show = (Show) bundle.getSerializable("show");

        //Page configuration based on selected Show

        RequestOptions ro = new RequestOptions();
        ro.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

        Glide
                .with(getApplicationContext())
                .load(show.getImage().getOriginal())
                .transition(com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade(1000))
                .apply(ro)
                .into(poster);

        name.setText(show.getName());
        rating.setText(show.getRating().getAverage() + " / 10");
        genres.setText(show.getGenres().toString());
        runtime.setText(show.getRuntime() + " minutes");
        schedule.setText(show.getSchedule().getTime() + " " +show.getSchedule().getDays());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            summary.setText(Html.fromHtml(show.getSummary(),Html.FROM_HTML_MODE_COMPACT));
        else
            summary.setText(Html.fromHtml(show.getSummary()));

        site.setText(show.getSite());


    }
}
