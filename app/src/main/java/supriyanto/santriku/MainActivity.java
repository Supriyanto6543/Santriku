package supriyanto.santriku;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import supriyanto.fragment.FragmentDashboard;
import supriyanto.fragment.FragmentDashboardSantri;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame_home;
    private FragmentManager manager;
    private String active = "";
    private SpaceNavigationView space;
    private TextView title_big;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        title_big = (TextView) findViewById(R.id.title_big);

        space = (SpaceNavigationView) findViewById(R.id.space);
        space.initWithSaveInstanceState(savedInstanceState);
        space.addSpaceItem(new SpaceItem(getString(R.string.home), R.drawable.ic_home_black_24dp));
        space.addSpaceItem(new SpaceItem(getString(R.string.foto), R.drawable.ic_add_a_photo_black_24dp));
        space.addSpaceItem(new SpaceItem(getString(R.string.portfolio), R.drawable.ic_polymer_black_24dp));
        space.addSpaceItem(new SpaceItem(getString(R.string.about), R.drawable.ic_info_black_24dp));

        space.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(getApplicationContext(), "BUTTON TENGAH", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0:
                        loadAllFragment();
                        title_big.setText(getString(R.string.app_name));
                        break;
                    case 1:
                        loadAllFragmentSantri();
                        title_big.setText("Santri");
                        break;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

        loadAllFragment();

    }

    private void loadAllFragment() {
        FragmentDashboard dashboard = new FragmentDashboard();
        loadFragment(dashboard, getString(R.string.dashboard));
    }

    public void loadAllFragmentSantri(){
        FragmentDashboardSantri santri = new FragmentDashboardSantri();
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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
