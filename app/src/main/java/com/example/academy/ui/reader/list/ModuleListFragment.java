package com.example.academy.ui.reader.list;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academy.data.ModuleEntity;
import com.example.academy.databinding.FragmentModuleListBinding;
import com.example.academy.ui.reader.CourseReaderActivity;
import com.example.academy.ui.reader.CourseReaderCallback;
import com.example.academy.ui.reader.CourseReaderViewModel;

import java.util.List;

public class ModuleListFragment extends Fragment implements ModuleListAdapter.MyAdapterClickListener {

    public static final String TAG = ModuleListFragment.class.getSimpleName();

    private FragmentModuleListBinding fragmentModuleListBinding;
    private ModuleListAdapter adapter;
    private CourseReaderCallback courseReaderCallback;

    private CourseReaderViewModel viewModel;

    public ModuleListFragment() {
        // Required empty public constructor
    }

    public static ModuleListFragment newInstance() {
        return new ModuleListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false);
        return fragmentModuleListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            viewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.NewInstanceFactory()).get(CourseReaderViewModel.class);
            adapter = new ModuleListAdapter(this);
            populateRecyclerView(viewModel.getModules());
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        courseReaderCallback = ((CourseReaderActivity) context);
    }

    @Override
    public void onItemClicked(int position, String moduleId) {
        courseReaderCallback.moveTo(position, moduleId);
        viewModel.setSelectedModule(moduleId);
    }

    private void populateRecyclerView(List<ModuleEntity> modules) {
        fragmentModuleListBinding.progressBar.setVisibility(View.GONE);
        adapter.setModules(modules);
        fragmentModuleListBinding.rvModule.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentModuleListBinding.rvModule.setHasFixedSize(true);
        fragmentModuleListBinding.rvModule.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        fragmentModuleListBinding.rvModule.addItemDecoration(dividerItemDecoration);
    }
}