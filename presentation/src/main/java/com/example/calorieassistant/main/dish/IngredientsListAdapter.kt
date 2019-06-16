package com.example.calorieassistant.main.dish

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calorieassistant.R
import com.example.calorieassistant.models.Ingredient
import kotlinx.android.synthetic.main.card_ingredient.view.*

class IngredientsListAdapter(val context: Context) :
    ListAdapter<Ingredient, IngredientsListAdapter.IngredientViewHolder>(DishesDiffUtilCallback()) {

    override fun onCreateViewHolder(container: ViewGroup, pos: Int): IngredientViewHolder {
        val view = LayoutInflater.from(container.context).inflate(R.layout.card_ingredient, container, false)
        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, pos: Int) {
        holder.bind(getItem(pos))
    }

    inner class IngredientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(ingredient: Ingredient) {
            itemView.card_ingredient_name.text = ingredient.name
            "Калорий: ${ingredient.calories.toInt()}".let{
                itemView.card_ingredient_calories.text = it
            }
            "${ingredient.weight.toInt()} гр.".let {
                itemView.card_ingredient_weight.text = it
            }

        }
    }

    class DishesDiffUtilCallback : DiffUtil.ItemCallback<Ingredient>() {

        override fun areItemsTheSame(new: Ingredient, old: Ingredient): Boolean {
            return new.name == old.name
        }

        override fun areContentsTheSame(new: Ingredient, old: Ingredient): Boolean {
            return new.calories == old.calories
        }

    }
}