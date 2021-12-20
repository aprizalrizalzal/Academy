package com.example.academy.ui.academy;

import androidx.lifecycle.ViewModel;

import com.example.academy.data.CourseEntity;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    public List<CourseEntity> getCourses(){
        return DataDummy.generateDummyCourses();
    }
}
