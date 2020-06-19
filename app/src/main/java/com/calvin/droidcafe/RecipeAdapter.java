package com.calvin.droidcafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private ArrayList<Recipe> recipeData;
    private Context myContext;
    RecipeAdapter(ArrayList<Recipe> mrecipeData, Context context){
        this.myContext=context;
        this.recipeData=mrecipeData;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        Recipe currentRecipe=recipeData.get(position);
        holder.bindTo(currentRecipe);

    }

    @Override
    public int getItemCount() {
        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView myrecipeImage;
        private TextView myrecipeTitle;
        private TextView myrecipeDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myrecipeImage=itemView.findViewById(R.id.recipe_image);
            myrecipeTitle=itemView.findViewById(R.id.recipe_title);
            myrecipeDescription=itemView.findViewById(R.id.recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition=getAdapterPosition();
                    Recipe currentDessert=recipeData.get(dessertPosition);
                    if (dessertPosition==0){
                        Intent donutIntent=new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }
                    else {
                        Toast.makeText(myContext,"Create an activity for the dessert",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bindTo(Recipe currentRecipe) {
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myrecipeImage);
            myrecipeTitle.setText(currentRecipe.getRecipeTitle());
            myrecipeDescription.setText(currentRecipe.getRecipeDescription());
        }
    }
}
