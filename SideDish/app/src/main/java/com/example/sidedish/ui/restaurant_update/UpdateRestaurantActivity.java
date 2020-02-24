package com.example.sidedish.ui.restaurant_update;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sidedish.R;
import com.example.sidedish.SideDishDatabase;
import com.example.sidedish.models.Restaurant;

public class UpdateRestaurantActivity extends AppCompatActivity {
    public static final String ID_DATA_KEY = "ID";

    private UpdateRestaurantViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_restaurant);
        updateViewModel();

        String appTitle = getString(R.string.app_name);
        if (viewModel.isNewRestaurant()) {
            setTitle(appTitle + " - New Restaurant");
        } else {
            setTitle(appTitle + " - Update Restaurant");

            Restaurant restaurant = viewModel.getRestaurant();
            getNameEdit().setText(restaurant.name);
            getDescEdit().setText(restaurant.desc);
            getPhoneNoEdit().setText(restaurant.phoneNum);
        }
        getSubmitButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant restaurant = viewModel.getRestaurant();
                restaurant.name = getNameEdit().getText().toString();
                restaurant.desc = getDescEdit().getText().toString();
                restaurant.phoneNum = getPhoneNoEdit().getText().toString();
                // TODO: Validation
                SideDishDatabase db = SideDishDatabase.instance(getApplicationContext());
                viewModel.onSubmit(db, restaurant);
                setResult(0);
                finish();
            }
        });
    }

    private Button getSubmitButton() { return findViewById(R.id.btnSubmit); }
    private TextView getNameEdit() { return findViewById(R.id.txt_name); }
    private TextView getDescEdit() { return findViewById(R.id.txt_desc); }
    private TextView getPhoneNoEdit() { return findViewById(R.id.txt_phone_no); }

    private void updateViewModel() {
        viewModel =
            ViewModelProviders.of(this).get(UpdateRestaurantViewModel.class);
        Intent intent = getIntent();
        if (intent.hasExtra(ID_DATA_KEY)) {
            int id = intent.getIntExtra(ID_DATA_KEY, -1);
            if (id >= 0) {
                Restaurant restaurant = SideDishDatabase.instance(
                    getApplicationContext()
                ).restaurantDao().getById(id);
                if (restaurant != null)
                    viewModel.setToUpdate(restaurant);
            }
        }
    }
}
