package idv.seventhmoon.toolbarsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fung on 26/08/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements ItemTouchHelperAdapter  {


    private ArrayList<String> mDataset;
    private Context mContext;


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder  implements
            ItemTouchHelperViewHolder{
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageViewPoster;
        public ViewHolder(View v) {
            super(v);

            v.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

//                    menu.setHeaderTitle("Select The Action");
                    menu.add(0, v.getId(), 0, "Add to wishlist");//groupId, itemId, order, title
                    menu.add(0, v.getId(), 0, "Share...");
                }
            });
            mTextView = (TextView) v.findViewById(R.id.text_view);
            mImageViewPoster = (ImageView) v.findViewById(R.id.image_poster);
        }

        @Override
        public void onItemSelected() {

        }

        @Override
        public void onItemClear() {

        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, String[] myDataset) {
        mContext = context;
        mDataset = new ArrayList<String>(Arrays.asList(myDataset));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_cell_text, parent, false);
        // set the view's size, margins, paddings and layout parameters



        ViewHolder vh = new ViewHolder(v);



        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText("XYZ Animation Studios Shorts Collection (2015) item #" + mDataset.get(position));
//        double imageViewWidth = holder.mImageViewPoster.getWidth();
//        holder.mImageViewPoster.setLayoutParams(new LinearLayout.LayoutParams((int)imageViewWidth,  (int)(imageViewWidth/16*9)));

//        holder.mImageViewPoster.getLayoutParams().height = (int)(imageViewWidth/16*9);
//        holder.mImageViewPoster.setMinimumHeight((int)(imageViewHeight/16*9));

        Glide.with(mContext).load("http://www.walloza.com/download/5889-captain-america-the-winter-soldier-movie-poster-hd-wallpaper-1920x1080.jpg").into(holder.mImageViewPoster);
//        if (position == mDataset.size()-1){
//
//        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}