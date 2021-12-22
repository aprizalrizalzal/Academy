package com.example.academy.ui.academy;

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

    private FragmentAcademyBinding fragmentAcademyBinding;

    public AcademyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(inflater, container,false);
        return fragmentAcademyBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() !=null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            AcademyViewModel viewModel = new ViewModelProvider(this, factory).get(AcademyViewModel.class);
            List<CourseEntity> courses = viewModel.getCourses();

            AcademyAdapter adapter = new AcademyAdapter();
            adapter.setCourse(courses);

            fragmentAcademyBinding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentAcademyBinding.rvAcademy.setHasFixedSize(true);
            fragmentAcademyBinding.rvAcademy.setAdapter(adapter);
        }
    }
}