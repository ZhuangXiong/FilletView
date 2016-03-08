package xemenes.filletview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import xemenes.filletlib.widget.FilletButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FilletButton filletButton = (FilletButton)findViewById(R.id.ft);
        filletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
