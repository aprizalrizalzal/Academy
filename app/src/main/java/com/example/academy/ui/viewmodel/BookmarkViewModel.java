package com.example.academy.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.source.AcademyRepository;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    private final AcademyRepository academyRepository;
    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<List<CourseEntity>> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }
}
