package com.example.academy.ui.academy;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academy.data.CourseEntity;
import com.example.academy.databinding.FragmentAcademyBinding;
import com.example.academy.ui.viewmodel.AcademyViewModel;
import com.example.academy.ui.viewmodel.ViewModelFactory;

import java.util.List;

public class AcademyFragment extends Fragment {

    private FragmentAcademyBinding binding;

    public AcademyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAcademyBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() !=null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            AcademyViewModel viewModel = new ViewModelProvider(this, factory).get(AcademyViewModel.class);

            AcademyAdapter adapter = new AcademyAdapter();

            binding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getCourses().observe(requireActivity(), courses -> {
                binding.progressBar.setVisibility(View.GONE);
                        adapter.setCourses(courses);
                        adapter.notifyDataSetChanged();
                    }
            );

            binding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvAcademy.setHasFixedSize(true);
            binding.rvAcademy.setAdapter(adapter);
        }
    }
}