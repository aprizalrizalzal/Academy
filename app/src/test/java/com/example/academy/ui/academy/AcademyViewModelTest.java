package com.example.academy.ui.academy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.academy.data.CourseEntity;
import com.example.academy.data.source.AcademyRepository;
import com.example.academy.ui.viewmodel.AcademyViewModel;
import com.example.academy.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AcademyViewModelTest {
    private AcademyViewModel viewModel;

    @Mock
    private AcademyRepository academyRepository;

    @Before
    public void setUp() {
        viewModel = new AcademyViewModel(academyRepository);
    }

    @Test
    public void getCourses() {
        when(academyRepository.getAllCourses()).thenReturn(DataDummy.generateDummyCourses());
        List<CourseEntity> courseEntities = viewModel.getCourses();
        verify(academyRepository).getAllCourses();

        assertNotNull(courseEntities);
        assertEquals(5,courseEntities.size());
    }
}