package com.example.ineed.ui.history;

import android.content.Context;
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

import com.example.ineed.databinding.FragmentHistoryBinding;

import java.util.List;

import model.Booking;
import model.Customer;
import model.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MyApiAdapter;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private TextView tvServiceProviderName, tvServiceName, tvBookingDate, tvBookingStatus;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel notificationsViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        init(container);
        return root;
    }

    private void init(ViewGroup container) {
        tvServiceProviderName = binding.textServiceProviderName;
        tvServiceName = binding.textSname;
        tvBookingDate = binding.textBookingDate;
        tvBookingStatus = binding.textBookingStatus;
        getBookingData();
    }


    public void getBookingData() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        int loggedInAccountId = sharedPref.getInt("account_id", 4);//default value = 4

        Call<List<Booking>> call = MyApiAdapter.getApiService().getBookingsByAccountId(loggedInAccountId);
        call.enqueue(new Callback<List<Booking>>() {
                         @Override
                         public void onResponse(@NonNull Call<List<Booking>> call, @NonNull Response<List<Booking>> response) {
                             if (response.isSuccessful()) {
                                 List<Booking> res = response.body();
                                 if (res != null && res.size() > 0) {
                                     Booking booking = res.get(0);
                                     tvBookingDate.setText(booking.getBookingDate());
                                     tvBookingStatus.setText(booking.getState());
//                                     tvServiceProviderName.setText(booking.getServiceproviderId());
//                                     tvServiceName.setText(booking.getServiceId());
//                                 getService(booking.getServiceId());
                                 } else {
                                     Toast.makeText(getActivity(), "No data found", Toast.LENGTH_LONG).show();
                                 }
                             } else {
                                 Toast.makeText(getActivity(), "Error in response", Toast.LENGTH_LONG).show();
                             }
                         }

                         @Override
                         public void onFailure(@NonNull Call<List<Booking>> call, @NonNull Throwable t) {
                             Toast.makeText(getActivity(), "Fail calling service", Toast.LENGTH_LONG).show();
                         }
                     }

        );

    }

//    public void getService(int serviceId) {
//        Call<Service> call = MyApiAdapter.getApiService().getService(serviceId);
//        call.enqueue(new Callback<Service>() {
//                         @Override
//                         public void onResponse(@NonNull Call<Service> call, @NonNull Response<Service> response) {
//                             if (response.isSuccessful()) {
//                                 Service res = response.body();
//                                 if (res == null) throw new AssertionError();
//                                 tvServiceName.setText(res.getName());
//                             } else {
//                                 Toast.makeText(getActivity(), "Error in response", Toast.LENGTH_LONG).show();
//                             }
//                         }
//
//                         @Override
//                         public void onFailure(@NonNull Call<Service> call, @NonNull Throwable t) {
//                             Toast.makeText(getActivity(), "Fail calling service", Toast.LENGTH_LONG).show();
//                         }
//                     }
//
//        );
//
//    }
}
