import React from 'react';
import Home from "./components/home/home";
import Recipe from "./components/recipe/recipe";

export const routes = [
    {
        path: "/recipe",
        component: Recipe,
        loadData: () => {
            return null;
            //getSomeData()
        }
    },
    {
        path: "/",
        component: Home,
        pathMatch: "full"
    },
    {
        path: "/not-found",
        component: () => {
            return (<h1>404</h1>);
        }
    }

];

