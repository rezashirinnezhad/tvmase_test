package test.reza.tvmaze.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import test.reza.tvmaze.R;

/**
 * Activity to handle connection lost situations
 * a dialog style activity with a message and
 * a try again button is shown to user
 */
public class ConnectionLostActivity extends Activity {

    private Button reconnect;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_no_connection);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1)
            this.setFinishOnTouchOutside(false);

        reconnect = (Button) findViewById(R.id.reconnect_btn);

        reconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
        }

    @Override
    public void onBackPressed() {
        finish();
    }

}
