package com.example.academy.ui.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academy.data.ModuleEntity;
import com.example.academy.databinding.ItemsModuleListBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseAdapter extends RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder> {

    private final List<ModuleEntity> listModules = new ArrayList<>();

    public void setModules(List<ModuleEntity> listModules){
        if (listModules == null) return;
        this.listModules.clear();
        this.listModules.addAll(listModules);
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsModuleListBinding binding = ItemsModuleListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ModuleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        ModuleEntity module = listModules.get(position);
        holder.bind(module);
    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {
        private final ItemsModuleListBinding binding;

        public ModuleViewHolder(ItemsModuleListBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(ModuleEntity module) {
            binding.textModuleTitle.setText(module.getTitle());
        }
    }
}
