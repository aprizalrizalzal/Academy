package com.example.academy.data.source;

import androidx.lifecycle.LiveData;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.ModuleEntity;

import java.util.List;

public interface AcademyDataSource {
    LiveData<List<CourseEntity>> getAllCourses();

    LiveData<CourseEntity> getCourseWithModules(String courseId);

    LiveData<List<ModuleEntity>> getAllModulesByCourse(String courseId);

    LiveData<List<CourseEntity>> getBookmarkedCourses();

    LiveData<ModuleEntity> getContent(String courseId, String moduleId);
}
