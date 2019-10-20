package ruslan2702.android_numbers_dz1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnNumberClickInterface {
    private OneNumberFragment oneNumberFragment;
    private NumbersFragment numbersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        oneNumberFragment = (OneNumberFragment) getSupportFragmentManager().findFragmentByTag(OneNumberFragment.TAG);
        numbersFragment = (NumbersFragment) getSupportFragmentManager().findFragmentByTag(NumbersFragment.TAG);

        if (oneNumberFragment == null) {
            oneNumberFragment = new OneNumberFragment();
        }

        if (numbersFragment == null) {
            numbersFragment = new NumbersFragment();
        }

        showNumbersFragment();
    }


    @Override
    public void onNumberClick(int num, @ColorInt int color) {
        showOneNumberFragment(num, color);
    }

    private void showOneNumberFragment(int number, @ColorInt int color) {
        oneNumberFragment.setNumber(number, color);

        if (getSupportFragmentManager().findFragmentByTag(OneNumberFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, oneNumberFragment, OneNumberFragment.TAG)
                .addToBackStack(OneNumberFragment.TAG)
                .commit();
    }

    private void showNumbersFragment() {
        if (getSupportFragmentManager().findFragmentByTag(NumbersFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, numbersFragment, NumbersFragment.TAG)
                .commit();
    }

}




