package com.example.ineed.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ineed.R;
import com.example.ineed.databinding.FragmentHomeBinding;

import java.util.List;

import model.Account;
import model.Category;
import model.Language;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Spinner spServiceType, spService, spLanguage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        init(container);
        return root;
    }

    private void init(ViewGroup container) {
        spServiceType = container.findViewById(R.id.spServiceType);
        spLanguage = container.findViewById(R.id.spLanguage);
        this.loadServiceTypes(container);
        this.loadLanguages(container);
    }

    private void loadServiceTypes(ViewGroup container) {
        Call<List<Category>> call = MyApiAdapter.getApiService().getFullCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(@NonNull Call<List<Category>> call, @NonNull Response<List<Category>> response) {
                if(response.isSuccessful()){
                    List<Category> res = response.body();
                    if (res == null) throw new AssertionError();
                    ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(container.getContext(), android.R.layout.simple_spinner_item, res);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spServiceType.setAdapter(adapter);
                }else {
                    Toast.makeText(container.getContext(), "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Category>> call, @NonNull Throwable t) {
                Toast.makeText(container.getContext(), "Fail calling service", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadLanguages(ViewGroup container) {
        Call<List<Language>> call = MyApiAdapter.getApiService().getLanguages();
        call.enqueue(new Callback<List<Language>>() {
            @Override
            public void onResponse(@NonNull Call<List<Language>> call, @NonNull Response<List<Language>> response) {
                if(response.isSuccessful()){
                    List<Language> res = response.body();
                    if (res == null) throw new AssertionError();
                    ArrayAdapter<Language> adapter = new ArrayAdapter<Language>(container.getContext(), android.R.layout.simple_spinner_item, res);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spServiceType.setAdapter(adapter);
                }else {
                    Toast.makeText(container.getContext(), "Error in response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Language>> call, @NonNull Throwable t) {
                Toast.makeText(container.getContext(), "Fail calling service", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadResults() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}