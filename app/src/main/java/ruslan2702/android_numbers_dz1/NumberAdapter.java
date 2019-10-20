package ruslan2702.android_numbers_dz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberView> {
    private OnNumberClickInterface listener;
    private int maxNumber;

    NumberAdapter(int maxNumber, OnNumberClickInterface listener) {
        this.listener = listener;
        this.maxNumber = maxNumber;
    }

    @NonNull
    @Override
    public NumberView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.number_button,
                viewGroup, false);
        return new NumberView(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberView numberView, int i) {
        numberView.bind(i);
    }

    void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        notifyItemInserted(maxNumber);
    }

    int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getItemCount() {
        return maxNumber;
    }
}
