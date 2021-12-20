package com.example.academy.ui.bookmark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academy.BookmarkAdapter;
import com.example.academy.R;
import com.example.academy.data.CourseEntity;
import com.example.academy.databinding.FragmentBookmarkBinding;
import com.example.academy.utils.DataDummy;

import java.util.List;

public class BookmarkFragment extends Fragment implements BookmarkFragmentCallback{

    private FragmentBookmarkBinding fragmentBookmarkBinding;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container,false);
        return fragmentBookmarkBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() !=null){
            List<CourseEntity> courses = DataDummy.generateDummyCourses();

            BookmarkAdapter adapter = new BookmarkAdapter(this);
            adapter.setCourse(courses);

            fragmentBookmarkBinding.rvBookmark.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentBookmarkBinding.rvBookmark.setHasFixedSize(true);
            fragmentBookmarkBinding.rvBookmark.setAdapter(adapter);
        }
    }

    @Override
    public void onShareClick(CourseEntity course) {
        if (getActivity() !=null){
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang")
                    .setText(getResources().getString(R.string.share_text, course.getTitle()))
                    .startChooser();
        }
    }
}