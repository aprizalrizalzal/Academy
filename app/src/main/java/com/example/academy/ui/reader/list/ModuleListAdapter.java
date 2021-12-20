package com.example.academy.ui.reader.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academy.data.ModuleEntity;
import com.example.academy.databinding.ItemsModuleListCustomBinding;

import java.util.ArrayList;
import java.util.List;

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>{

    private final MyAdapterClickListener listener;
    private final List<ModuleEntity> listModules = new ArrayList<>();

    public ModuleListAdapter(MyAdapterClickListener listener){
        this.listener = listener;
    }

    public void setModules (List<ModuleEntity> modules){
        if (modules == null)return;
        listModules.clear();
        listModules.addAll(modules);
    }

    @NonNull
    @Override
    public ModuleListAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsModuleListCustomBinding binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ModuleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleListAdapter.ModuleViewHolder holder, int position) {
        ModuleEntity module = listModules.get(position);
        holder.bind(module);
        holder.itemView.setOnClickListener(v ->
                listener.onItemClicked(holder.getAdapterPosition(), listModules.get(holder.getAdapterPosition()).getModuleId())
        );
    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {
        private final ItemsModuleListCustomBinding binding;

        ModuleViewHolder(ItemsModuleListCustomBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(ModuleEntity module) {
            binding.textModuleTitle.setText(module.getTitle());
        }
    }

    public interface MyAdapterClickListener {
        void onItemClicked(int position, String moduleId);
    }
}
