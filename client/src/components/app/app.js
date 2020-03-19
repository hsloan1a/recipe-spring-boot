import React from 'react';
import './app.css';
import MyNavbar from "../navbar/navbar";
import {Route, Switch} from 'react-router-dom'
import Recipe from "../recipe/recipe";
import Home from "../home/home";
import Jumbotron from "react-bootstrap/Jumbotron";
import NotFound from "../not_found/notFound";


function App() {
    return (
        <div>
            <header>
                <MyNavbar/>
            </header>
            <section>
                <Jumbotron>
                    <Switch>
                        <Route exact path='/recipe' component={Recipe}/>
                        <Route exact path='/' component={Home}/>
                        <Route component={NotFound}/>
                    </Switch>
                </Jumbotron>
            </section>
        </div>
    );
}

export default App;
