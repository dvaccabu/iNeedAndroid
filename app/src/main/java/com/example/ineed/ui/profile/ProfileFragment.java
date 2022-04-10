package com.example.ineed.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ineed.Search;
import com.example.ineed.databinding.FragmentProfileBinding;

import java.util.List;

import model.Account;
import model.Customer;
import model.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private TextView tvFname, tvLname, tvPhone, tvAddress;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        init(container);
        return root;
    }

    private void init(ViewGroup container) {
        tvFname = binding.textFname;
        tvLname = binding.textLname;
        tvPhone = binding.textPhone;
        tvAddress = binding.textAddress;
        getProfileDataForLoggedInUser();
    }


    public void getProfileDataForLoggedInUser() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        int loggedInAccountId = sharedPref.getInt("account_id", 4);//default value = 4

        Call<List<Customer>> call = MyApiAdapter.getApiService().getCustomerByAccountId(loggedInAccountId);
        call.enqueue(new Callback<List<Customer>>() {
                         @Override
                         public void onResponse(@NonNull Call<List<Customer>> call, @NonNull Response<List<Customer>> response) {
                             if (response.isSuccessful()) {
                                 List<Customer> res = response.body();
//                                 if (res == null || res.isEmpty() || res.size() == 0) throw new AssertionError();

                                 if (res != null && res.size() > 0) {
                                     Customer ca = res.get(0);
                                     tvFname.setText(ca.getFname());
                                     tvLname.setText(ca.getLname());
                                     tvPhone.setText(ca.getPhone());
                                     tvAddress.setText(ca.getAddress());
                                 } else {
                                     Toast.makeText(getActivity(), "No data found", Toast.LENGTH_LONG).show();

                                 }
                             } else {
                                 Toast.makeText(getActivity(), "Error in response", Toast.LENGTH_LONG).show();
                             }
                         }

                         @Override
                         public void onFailure(@NonNull Call<List<Customer>> call, @NonNull Throwable t) {
                             Toast.makeText(getActivity(), "Fail calling service", Toast.LENGTH_LONG).show();
                         }
                     }

        );

    }
}