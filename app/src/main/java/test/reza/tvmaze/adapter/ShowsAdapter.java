package test.reza.tvmaze.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import test.reza.tvmaze.R;
import test.reza.tvmaze.activity.ShowDetailsActivity;
import test.reza.tvmaze.model.Show;

/**
 * Adapt a list of Shows to views
 */

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.ShowsVH> {

    Context context;
    List<Show> shows;

    /**
     * Initializing adapter by its constructor
     * @param context
     * @param shows
     */
    public ShowsAdapter(Context context, List<Show> shows){
        this.context = context;
        this.shows = shows;
    }

    /**
     * Method to set adapter dataset and automaticatlly notify itself
     * @param shows
     */
    public void setShowsList(List<Show> shows){
        this.shows = shows;
        this.notifyDataSetChanged();
    }
    @Override
    public ShowsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_card_layout, parent, false);

        return new ShowsVH(itemView);
    }

    /**
     * Setup every cardview based on every Show Object in Shows list
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ShowsVH holder, final int position) {
        Show show = shows.get(position);

        holder.title.setText(show.getName());
        holder.rating.setRating(show.getRating().getAverage()/2);

        RequestOptions ro = new RequestOptions();
        ro.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);


        Glide
                .with(context)
                .load(show.getImage().getMedium())
                .transition(com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade(1000))
                .apply(ro)
                .into(holder.poster);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ShowDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("show", shows.get(position));
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    /**
     * View holder of adapter
     */
    public class ShowsVH extends RecyclerView.ViewHolder {

        CardView card;
        TextView title;
        RatingBar rating;
        ImageView poster;

        /**
         *  Initializing  properties in constructor
         * @param view
         */
        public ShowsVH(View view) {
            super(view);

            card = (CardView) view.findViewById(R.id.card_view);
            title = (TextView) view.findViewById(R.id.thumbnail_title);
            rating = (RatingBar) view.findViewById(R.id.thumbnail_rating);
            poster = (ImageView) view.findViewById(R.id.thumbnail_poster);

        }
    }
}
