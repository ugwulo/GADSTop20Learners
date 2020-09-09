package com.example.gadstop20learners.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadstop20learners.R;
import com.example.gadstop20learners.model.LearningLeaders;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.LearningViewHolder> {

    private List<LearningLeaders> mLearningHours;
    LearningLeadersAdapter(List<LearningLeaders> hours){
        this.mLearningHours = hours;
    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_learning_leaders, parent, false);
        return new LearningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        holder.bind(mLearningHours.get(position));
    }

    @Override
    public int getItemCount() {
        return mLearningHours.size();
    }

    public class LearningViewHolder extends RecyclerView.ViewHolder {
        TextView learnerName, learningHours, learnerCountry;
        ImageView imageUrl;

        public LearningViewHolder(View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.text_learner_name);
            learningHours = itemView.findViewById(R.id.text_hours);
            learnerCountry = itemView.findViewById(R.id.text_learner_country);
            imageUrl = itemView.findViewById(R.id.learner_badge);
        }

        public void bind(LearningLeaders hours) {
            learnerName.setText(hours.getName());
            learningHours.setText(String.valueOf(hours.getHours()));
            learnerCountry.setText(hours.getCountry());

            Glide.with(itemView.getContext())
                    .load(hours.getBadgeUrl())
                    .into(imageUrl);
        }
    }
}
