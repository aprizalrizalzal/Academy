package com.example.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.example.academy.data.CourseEntity;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    public List<CourseEntity> getBookmarks(){
        return DataDummy.generateDummyCourses();
    }
}
