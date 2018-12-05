package de.thro.inf.prg3.a09.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.model.Fighter;

public class FighterRecyclerViewAdapter extends RecyclerView.Adapter<FighterRecyclerViewAdapter.ViewHolder>
{
    private List<Fighter> fighters;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView pilotNameView;
        private TextView fighterTypeView;
        private ImageView fighterImageView;

        ViewHolder(View view)
        {
            super(view);

            pilotNameView = view.findViewById(R.id.pilotNameView);
            fighterTypeView = view.findViewById(R.id.fighterTypeView);
            fighterImageView = view.findViewById(R.id.fighterImageView);
        }

        void setPilot(String pilot)
        {
            pilotNameView.setText(pilot);
        }

        void setFighterType(String fighterType)
        {
            fighterTypeView.setText(fighterType);
        }

        void setFighterImage(Drawable fighterImage)
        {
            fighterImageView.setImageDrawable(fighterImage);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FighterRecyclerViewAdapter(List<Fighter> fighters)
    {
        this.fighters = fighters;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fighter_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Fighter f = fighters.get(position);

        holder.setPilot(f.getPilot());
        holder.setFighterType(f.getFighterType());
        holder.setFighterImage(f.getFighterImage());

    }

    @Override
    public int getItemCount()
    {
        if (fighters != null)
        {
            return fighters.size();
        }

        return 0; // TODO: change this to 0
    }
}
