import React from 'react';
import {Button, Form, FormControl, Nav, Navbar} from "react-bootstrap";
import {NavLink} from "react-router-dom";

class MyNavbar extends React.Component {
    render() {
        return (
            <Navbar fixed="top" bg="primary" variant="dark">
                <Navbar.Brand href="#home">Navbar</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link as={NavLink} to="/">Home</Nav.Link>
                    <Nav.Link as={NavLink} to="/recipe">Recipe</Nav.Link>
                    <Nav.Link href="#pricing">Pricing</Nav.Link>
                </Nav>
                <Form inline>
                    <FormControl type="text" placeholder="Search" className="mr-sm-2"/>
                    <Button variant="outline-light">Search</Button>
                </Form>
            </Navbar>
        )
    }
}

export default MyNavbar
