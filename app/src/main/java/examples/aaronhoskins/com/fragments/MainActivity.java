package examples.aaronhoskins.com.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class MainActivity extends AppCompatActivity
        implements BlueFragment.OnFragmentInteractionListener,
                    PinkFragment.OnFragmentInteractionListener{
    FragmentManager fragmentManager;
    BlueFragment blueFragment;
    PinkFragment pinkFragment;
    PinkFragment pinkFragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        blueFragment = BlueFragment.newInstance("","");
        pinkFragment = PinkFragment.newInstance("","");
        pinkFragmentTwo = PinkFragment.newInstance("","");

        fragmentManager
                .beginTransaction()
                .add(R.id.frmPlaceHolderOne, blueFragment)
                .addToBackStack("BLUE")
                .commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.frmPlaceHolderTwo, pinkFragment)
                .addToBackStack("PINK")
                .commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.frmPlaceHolderThree, pinkFragmentTwo)
                .addToBackStack("PINK_TWO")
                .commit();
    }


    @Override
    public void sendSocialToActivity(String string) {
        Log.d("TAG", "sendSocialToActivity: " + string);
        pinkFragment.setSSNNumber(string);
    }

    public void onClick(View view) {
        //fragmentManager.popBackStack();
        fragmentManager.popBackStack("BLUE", POP_BACK_STACK_INCLUSIVE);
        //fragmentManager.beginTransaction().remove(blueFragment).commit();
    }
}
