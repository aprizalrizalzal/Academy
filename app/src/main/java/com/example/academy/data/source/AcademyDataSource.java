package com.example.academy.data.source;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.ModuleEntity;

import java.util.List;

public interface AcademyDataSource {
    List<CourseEntity> getAllCourses();

    CourseEntity getCourseWithModules(String courseId);

    List<ModuleEntity> getAllModulesByCourse(String courseId);

    List<CourseEntity> getBookmarkedCourses();

    ModuleEntity getContent(String courseId, String moduleId);
}
