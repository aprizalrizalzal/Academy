package com.example.academy.ui.bookmark;

import static org.junit.Assert.*;

import com.example.academy.data.CourseEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookmarkViewModelTest {
    private BookmarkViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new BookmarkViewModel();
    }

    @Test
    public void getBookmarks() {
        List<CourseEntity> courseEntities = viewModel.getBookmarks();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}