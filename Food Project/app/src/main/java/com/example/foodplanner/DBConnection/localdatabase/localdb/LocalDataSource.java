package com.example.foodplanner.DBConnection.localdatabase.localdb;

import com.example.foodplanner.Model.FavoriteMeal;
import com.example.foodplanner.Model.Meal;
import com.example.foodplanner.plan.dialog.favorite.presenter.NetworkDelegateFavDialog;
import com.example.foodplanner.plan.dialog.search.presenter.NetworkDelegateSearchPlan;
import com.example.foodplanner.plan.presenter.NetworkDelegatePlan;
import com.example.foodplanner.searchresult.OnViewClickSearchPlan;
import com.example.foodplanner.searchresult.presenter.NetworkDelegateSearchResult;

import java.util.List;

public interface LocalDataSource {

    void getMeal(String email, NetworkDelegatePlan networkDelegatePlan);

    void deleteMeal(String idMeal, String email, NetworkDelegatePlan networkDelegatePlan);

    void clear();

    void setMeals(NetworkDelegateSearchPlan NetworkDelegateSearchPlan, List<Meal> listMeals);

    void addToPlan(FavoriteMeal tag, OnViewClickSearchPlan onViewClickSearchPlan, NetworkDelegateSearchResult networkDelegateSearchResult);

    void removeFav(FavoriteMeal meal, OnViewClickSearchPlan onViewClickSearchPlan,NetworkDelegateSearchResult networkDelegateSearchResult);

    void getListFav(String email, NetworkDelegateFavDialog networkDelegateFavDialog);
     void setMealsFromFav(NetworkDelegateFavDialog networkDelegateFavDialog, List<Meal> listMeals);

    void addToPlan(Meal meal);

    void deleteMealFormPlan(Meal meal);
}
