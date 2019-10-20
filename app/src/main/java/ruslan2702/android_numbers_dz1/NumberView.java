package ruslan2702.android_numbers_dz1;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class NumberView extends RecyclerView.ViewHolder {
    private Button numberButton;
    private int number;

    NumberView(@NonNull View itemView, final OnNumberClickInterface onNumberClickInterface) {
        super(itemView);
        numberButton = itemView.findViewById(R.id.numberButton);
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickInterface.onNumberClick(number, getColor(number));
            }
        });
    }

    void bind(int num) {
        this.number = num;
        numberButton.setText(String.valueOf(number));
        numberButton.setTextColor(getColor(number));
    }

    @ColorInt
    private static int getColor(int num) {
        if (num % 2 == 0) {
            return Color.RED;
        }
        return Color.BLUE;
    }
}
