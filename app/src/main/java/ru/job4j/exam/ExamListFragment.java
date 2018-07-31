package ru.job4j.exam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamListFragment extends Fragment {
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        this.recycler = view.findViewById(R.id.exams);
        this.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        List<Question> questions = new ArrayList<Question>();
        for (int index = 0; index != 100; index++) {
            questions.add(
                    new Question(
                            index, index + ". Question.",
                            Arrays.asList(
                                    new Option(1, "1.1"), new Option(2, "1.2"),
                                    new Option(3, "1.3"), new Option(4, "1.4")
                            ), 4
                    )
            );
        }
        this.recycler.setAdapter(new ExamAdapter(questions));
    }


    public class ExamHolder extends RecyclerView.ViewHolder {

        private View view;

        public ExamHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public class ExamAdapter extends RecyclerView.Adapter<ExamHolder> {

        private final List<Question> questions;

        public ExamAdapter(List<Question> questions) {
            this.questions = questions;
        }

        @NonNull
        @Override
        public ExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.exam, parent, false);
            return new ExamHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ExamHolder holder, int i) {
            Question question = this.questions.get(i);
            TextView text = holder.view.findViewById(R.id.q_text);
            text.setText(question.getText());
        }

        @Override
        public int getItemCount() {
            return this.questions.size();
        }
    }
}
