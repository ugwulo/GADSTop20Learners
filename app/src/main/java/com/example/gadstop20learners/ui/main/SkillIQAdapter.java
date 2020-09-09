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
import com.example.gadstop20learners.model.SkillIQLeaders;

import java.util.List;

/**
 * adapter class for {@link SkillIQLeaders} using {@link RecyclerView}
 */
public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.IQViewHolder> {

    private final List<SkillIQLeaders> mSkillIQLeaders;
    SkillIQAdapter(List<SkillIQLeaders> skillIqLeaders){
        this.mSkillIQLeaders = skillIqLeaders;
    }

    @NonNull
    @Override
    public IQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_skill_iq_leaders, parent, false);
        return new IQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IQViewHolder holder, int position) {
        holder.bind(mSkillIQLeaders.get(position));
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaders.size();
    }

    /**
     * view holder class for {@link SkillIQAdapter} using {@link RecyclerView.ViewHolder}
     */
    public class IQViewHolder extends RecyclerView.ViewHolder {
        TextView learnerName, skillIQ, learnerCountry;
        ImageView badgeUrl;

        public IQViewHolder(@NonNull View itemView) {
            super(itemView);

            learnerName = itemView.findViewById(R.id.iq_learner_name);
            skillIQ = itemView.findViewById(R.id.text_skill_iq);
            learnerCountry = itemView.findViewById(R.id.iq_learner_country);
            badgeUrl = itemView.findViewById(R.id.iq_learner_badge);
        }

        public void bind(SkillIQLeaders skillIqLeaders){
            learnerName.setText(skillIqLeaders.getName());
            skillIQ.setText(String.valueOf(skillIqLeaders.getSkillIq()));
            learnerCountry.setText(skillIqLeaders.getCountry());

            Glide.with(itemView.getContext())
                    .load(skillIqLeaders.badgeUrl)
                    .into(badgeUrl);
        }

    }
}
