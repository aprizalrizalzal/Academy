package com.example.academy.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.source.AcademyRepository;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    private final AcademyRepository academyRepository;
    public AcademyViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<List<CourseEntity>> getCourses() {
        return academyRepository.getAllCourses();
    }
}
