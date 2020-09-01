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
import com.example.gadstop20learners.model.LearningHours;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private final List<LearningHours> mLearningHours;
    LearningLeadersAdapter(List<LearningHours> hours){
        this.mLearningHours = hours;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_learning_leaders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mLearningHours.get(position));
    }

    @Override
    public int getItemCount() {
        return mLearningHours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView learnerName, learningHours, learnerCountry;
        ImageView imageUrl;
        public ViewHolder(View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.text_learner_name);
            learningHours = itemView.findViewById(R.id.text_hours);
            learnerCountry = itemView.findViewById(R.id.text_learner_country);
            imageUrl = itemView.findViewById(R.id.learner_badge);
        }

        public void bind(LearningHours hours) {
            learnerName.setText(hours.getLearnerName());
            learningHours.setText(hours.getLearningHours());
            learnerCountry.setText(hours.getLearnerCountry());

            Glide.with(itemView.getContext())
                    .load(hours.getBadgeUrl())
                    .into(imageUrl);
        }
    }
}
