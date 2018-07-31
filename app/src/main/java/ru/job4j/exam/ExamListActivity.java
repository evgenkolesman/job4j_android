package ru.job4j.exam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class ExamListActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.exam_list);

        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.list);
        if (fragment == null) {
            fragment = new ExamListFragment();
            manager.beginTransaction()
                    .add(R.id.list, fragment)
                    .commit();
        }
    }
}
