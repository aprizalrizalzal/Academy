package com.example.academy;

import android.content.Context;

import com.example.academy.data.source.AcademyRepository;
import com.example.academy.data.source.remote.RemoteDataSource;
import com.example.academy.utils.JsonHelper;

public class Injection {
    public static AcademyRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return AcademyRepository.getInstance(remoteDataSource);
    }
}
