package com.example.academy.ui.academy;

import static org.junit.Assert.*;

import com.example.academy.data.CourseEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AcademyViewModelTest {
    private AcademyViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new AcademyViewModel();
    }

    @Test
    public void getCourses() {
        List<CourseEntity> courseEntities = viewModel.getCourses();
        assertNotNull(courseEntities);
        assertEquals(5,courseEntities.size());
    }
}