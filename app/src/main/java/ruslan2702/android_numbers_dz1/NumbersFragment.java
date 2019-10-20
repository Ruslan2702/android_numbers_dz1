package ruslan2702.android_numbers_dz1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersFragment extends Fragment implements OnNumberClickInterface {
    static final String TAG = "NumbersFragment";

    private NumberAdapter mAdapter;
    private int maxNumber = 101;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            maxNumber = savedInstanceState.getInt("max_number", 101);
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        int orientation = view.getContext().getResources().getConfiguration().orientation;
        int numberOfColumns;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            numberOfColumns = 4;
        } else {
            numberOfColumns = 3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), numberOfColumns));

        mAdapter = new NumberAdapter(maxNumber, this);
        recyclerView.setAdapter(mAdapter);

        Button addNumberButton = view.findViewById(R.id.addNumber);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxNumber = mAdapter.getMaxNumber() + 1;
                mAdapter.setMaxNumber(maxNumber);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("max_number", maxNumber);
    }

    @Override
    public void onNumberClick(int num, @ColorInt int color) {
        if (getActivity() == null || !(getActivity() instanceof OnNumberClickInterface)) {
            return;
        }
        ((OnNumberClickInterface) getActivity()).onNumberClick(num, color);
    }
}
