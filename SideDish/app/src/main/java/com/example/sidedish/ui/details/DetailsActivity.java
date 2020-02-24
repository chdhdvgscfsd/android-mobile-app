package com.example.sidedish.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sidedish.R;
import com.example.sidedish.models.Restaurant;
import com.example.sidedish.ui.list.ListViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {
    private DetailsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);

        int id = getIntent().getIntExtra("ID", -1);
        if (id == -1) finish();
        viewModel.setRestaurant(getApplicationContext(), id);

        viewModel.getRestaurant().observe(this, new Observer<Restaurant>() {
            @Override
            public void onChanged(Restaurant restaurant) {
                getNameEdit().setText(restaurant.name);
                getDescEdit().setText(restaurant.desc);
            }
        });

        final ListViewModel listViewModel =
            ViewModelProviders.of(this).get(ListViewModel.class);

        getFab().setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.onDelete(getApplicationContext(), listViewModel);
                    setResult(0);
                    finish();
                }
            }
        );
    }

    private TextView getNameEdit() { return findViewById(R.id.lbl_name); }
    private TextView getDescEdit() { return findViewById(R.id.lbl_desc); }
    private FloatingActionButton getFab() { return findViewById(R.id.btn_delete); }
}
