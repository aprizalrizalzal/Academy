package com.example.academy.data.source.remote;

import com.example.academy.data.source.remote.response.ContentResponse;
import com.example.academy.data.source.remote.response.CourseResponse;
import com.example.academy.data.source.remote.response.ModuleResponse;
import com.example.academy.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private final JsonHelper jsonHelper;

    public RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public List<CourseResponse> getAllCourses() {
        return jsonHelper.loadCourses();
    }

    public List<ModuleResponse> getModules(String courseId) {
        return jsonHelper.loadModule(courseId);
    }

    public ContentResponse getContent(String moduleId) {
        return jsonHelper.loadContent(moduleId);
    }
}
