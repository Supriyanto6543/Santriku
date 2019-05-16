package supriyanto.santriku;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import supriyanto.fragment.FragmentDashboardPlp;

/**
 * Created by SUPRIYANTO on 27/04/2019.
 */

public class PlpActivity extends AppCompatActivity {

    private FrameLayout frame_home;
    private FragmentManager manager;
    private String active = "";
    private TextView title_big;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santri);

        frame_home = findViewById(R.id.frame_home);
        manager = getSupportFragmentManager();
        title_big = (TextView) findViewById(R.id.title_big);

        loadAllFragmentSantri();

    }

    public void loadAllFragmentSantri(){
        FragmentDashboardPlp santri = new FragmentDashboardPlp();
        loadFragment(santri, "");
    }

    private void loadFragment(Fragment fragment, String name) {

        active = name;
        for (int i = 0; i<manager.getBackStackEntryCount(); i++){
            manager.popBackStack();
        }

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_home, fragment, name);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
