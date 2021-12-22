package com.example.academy.ui.reader.content;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academy.data.ModuleEntity;
import com.example.academy.databinding.FragmentModuleContentBinding;
import com.example.academy.ui.viewmodel.CourseReaderViewModel;
import com.example.academy.ui.viewmodel.ViewModelFactory;

public class ModuleContentFragment extends Fragment {

    public static final String TAG = ModuleContentFragment.class.getSimpleName();
    private FragmentModuleContentBinding binding;

    public ModuleContentFragment() {
        // Required empty public constructor
    }

    public static ModuleContentFragment newInstance(){
        return new ModuleContentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentModuleContentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(requireActivity());
            CourseReaderViewModel viewModel = new ViewModelProvider(requireActivity(), factory).get(CourseReaderViewModel.class);

            binding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getSelectedModule().observe(requireActivity(), module -> {
                binding.progressBar.setVisibility(View.GONE);
                if (module != null) {
                    populateWebView(module);
                }
            });
        }
    }

    private void populateWebView(ModuleEntity module) {
        binding.webView.loadData(module.contentEntity.getContent(), "text/html", "UTF-8");
    }
}