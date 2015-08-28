package idv.seventhmoon.toolbarsample;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TabActivity extends AppCompatActivity implements DummyFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener {

    private HomeFragment mHomeFragment;
    private DummyFragment mDummyFragment;
    private FloatingActionButton mYtFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mHomeFragment = new HomeFragment();
        mDummyFragment = new DummyFragment();

        mYtFab = (FloatingActionButton) findViewById(R.id.fab_yt_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

//        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_white_24dp).setTag("HOME"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_history_white_24dp).setTag("HISTORY"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_favorite_white_24dp).setTag("FAVORITE"));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if ("HOME".equals(tab.getTag())) {
                    showFragment(mHomeFragment);
                    mYtFab.setVisibility(View.VISIBLE);
                } else if ("HISTORY".equals(tab.getTag())) {
                    showFragment(mDummyFragment);
                    mYtFab.setVisibility(View.GONE);
                } else if ("FAVORITE".equals(tab.getTag())) {
                    showFragment(mDummyFragment);
                    mYtFab.setVisibility(View.GONE);
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        showFragment(mHomeFragment);


        ImageView imageViewBkg = (ImageView) findViewById(R.id.image_background);
        Glide.with(this).load("https://lh3.googleusercontent.com/-MYdnUw1Bz68/Vbw6wY02aDI/AAAAAAACBb8/7kv24wdASeU/s1600-Ic42/IMG_0307.JPG").centerCrop().into(imageViewBkg);
    }

    private void showFragment(Fragment fragment){


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, fragment);
//        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
