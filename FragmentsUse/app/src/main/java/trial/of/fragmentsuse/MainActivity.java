package trial.of.fragmentsuse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragmentActivity homeFragmentActivity;
    private NotificationFragmentActivity notificationFragmentActivity;
    private RedeemFragmentActivity redeemFragmentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame =(FrameLayout) findViewById(R.id.main_FrameLayout);
        mMainNav=(BottomNavigationView) findViewById(R.id.mainBottom);

        homeFragmentActivity = new HomeFragmentActivity();
        notificationFragmentActivity = new NotificationFragmentActivity();
        redeemFragmentActivity = new RedeemFragmentActivity();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home_nav:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(homeFragmentActivity);
                        return true;

                    case R.id.redeem_nav:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(redeemFragmentActivity);
                        return true;

                    case R.id.Noti_nav:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notificationFragmentActivity);
                        return true;

                    default:
                        return false;

                }
            }

                   });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_FrameLayout, fragment);
        fragmentTransaction.commit();
    }

}
