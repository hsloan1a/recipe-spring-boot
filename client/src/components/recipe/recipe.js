import React from 'react'

class Recipe extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.state = {
            recipes: [],
        };
    }

    componentDidMount() {
        fetch('recipe/all_recipe')
            .then(response => response.json())
            .then((recipes) => this.setState(recipes))
    }

    render() {
        const {params} = this.props.match;
        return (
            <div>
                <p>Recipe docker</p>
                {params.id ? <p>{params.id}</p> : null}
            </div>
        )
    }
}

export default Recipe