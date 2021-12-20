package com.example.academy.ui.detail;

import static org.junit.Assert.*;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.ModuleEntity;
import com.example.academy.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DetailCourseViewModelTest {
    private DetailCourseViewModel viewModel;
    private final CourseEntity dummyCourse = DataDummy.generateDummyCourses().get(0);
    private final String courseId = dummyCourse.getCourseId();

    @Before
    public void setUp() {
        viewModel = new DetailCourseViewModel();
        viewModel.setSelectedCourse(courseId);
    }

    @Test
    public void getCourse() {
        viewModel.setSelectedCourse(dummyCourse.getCourseId());
        CourseEntity courseEntity = viewModel.getCourse();
        assertNotNull(courseEntity);
        assertEquals(dummyCourse.getCourseId(), courseEntity.getCourseId());
        assertEquals(dummyCourse.getDeadline(), courseEntity.getDeadline());
        assertEquals(dummyCourse.getDescription(), courseEntity.getDescription());
        assertEquals(dummyCourse.getImagePath(), courseEntity.getImagePath());
        assertEquals(dummyCourse.getTitle(), courseEntity.getTitle());
    }

    @Test
    public void getModules() {
        List<ModuleEntity> moduleEntities = viewModel.getModules();
        assertNotNull(moduleEntities);
        assertEquals(7,moduleEntities.size());
    }
}