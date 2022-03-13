package com.example.ineed.ui.profile;

import android.content.Intent;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void Tester()
    {
        Call<List<Customer>> call = MyApiAdapter.getApiService().getCustomerByAccountId(4);
        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(@NonNull Call<List<Customer>> call, @NonNull Response<List<Customer>> response) {
                if(response.isSuccessful()){
                    List<Customer> res = response.body();
                    if (res == null) throw new AssertionError();
                    Customer ca = res.get(0);
                    Toast.makeText(getActivity(), ca.toString(), Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getActivity(), "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Customer>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), "Fail calling service", Toast.LENGTH_LONG).show();
            }
        }

        );

  //  @Override
    //public void onDestroyView() {
      //  super.onDestroyView();
        //binding = null;

}
}
