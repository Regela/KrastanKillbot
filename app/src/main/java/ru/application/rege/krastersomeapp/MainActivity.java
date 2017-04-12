package ru.application.rege.krastersomeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MainSet mainSet = new YourClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bUp), MainSet.ButtonType.UP);
        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bLeft), MainSet.ButtonType.LEFT);
        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bStop), MainSet.ButtonType.STOP);
        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bRight), MainSet.ButtonType.RIGHT);
        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bDown), MainSet.ButtonType.DOWN);

        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bFire), MainSet.ButtonType.FIRE);
        prepareBtnForOnBtnEvent((ImageButton) findViewById(R.id.bShock), MainSet.ButtonType.SHOCK);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainSet.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainSet.onStop();
    }

    /**
     * @param ib
     * @param btn A button type of MainSet.ButtonType
     */
    private void prepareBtnForOnBtnEvent(ImageButton ib, final MainSet.ButtonType btn) {
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String errMsg = null;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundColor(Color.GRAY);
                        errMsg = mainSet.onButtonEvent(btn, MainSet.ButtonEvent.ON);
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setBackgroundColor(Color.TRANSPARENT);
                        errMsg = mainSet.onButtonEvent(btn, MainSet.ButtonEvent.OFF);
                        break;
                }
                if (errMsg != null) Toast.makeText(v.getContext(), errMsg, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
