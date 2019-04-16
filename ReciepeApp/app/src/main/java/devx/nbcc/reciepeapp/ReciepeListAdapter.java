package devx.nbcc.reciepeapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.LinkedList;

public class ReciepeListAdapter extends RecyclerView.Adapter<ReciepeListAdapter.RecipeViewHolder>  {


    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Serializable{
        public final TextView nameView;
        public final TextView briefDescView;
        final ReciepeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, ReciepeListAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameView = itemView.findViewById(R.id.name);
            briefDescView = itemView.findViewById(R.id.briefDesc);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mWordList.
            Reciepe r = mReciepeList.get(mPosition);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

            itemView.setOnClickListener(this);


            Intent intent = new Intent(view.getContext(),recipeIntent.class);
            intent.putExtra("RECIEPE", (Serializable) r);
            view.getContext().startActivity(intent);
        }
    }

    private final LinkedList<Reciepe> mReciepeList;
    private LayoutInflater mInflater;


    public ReciepeListAdapter(Context context,
                              LinkedList<Reciepe> reciepeList) {
        mInflater = LayoutInflater.from(context);
        this.mReciepeList = reciepeList;
    }

    @NonNull
    @Override
    public ReciepeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item,
                parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Reciepe mCurrent = mReciepeList.get(position);
        holder.nameView.setText(mCurrent.getName());
        holder.briefDescView.setText(mCurrent.getDescription());
    }

    @Override
    public int getItemCount() {
        return mReciepeList.size();
    }
}
