package com.example.academy.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.academy.data.ContentEntity;
import com.example.academy.data.ModuleEntity;
import com.example.academy.data.source.AcademyRepository;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class CourseReaderViewModel extends ViewModel {

    private String courseId;
    private String moduleId;

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }
    private final AcademyRepository academyRepository;
    public CourseReaderViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<List<ModuleEntity>> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }

    public LiveData<ModuleEntity> getSelectedModule() {
        return academyRepository.getContent(courseId, moduleId);
    }
}
