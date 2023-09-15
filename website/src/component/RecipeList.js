import React, { useEffect, useState } from 'react';
import './styles/Phone.css'
import axios from 'axios';

function Phone() {

    const [data, setData] = useState(null);

    // useEffect(() => {
    //     axios.get("http://localhost:8080/recipe").then((response) => {
    //         setData(response.data);
    //     }).catch(e => {
    //         setData("none");
    //     });
    // }, [data]);

    return (
        <div className="recipe-container">
            {/* <h1 className="recipe-name">{data}</h1>
            <h1 className="recipe-types">{data.type}</h1>
            <h1 className="recipe-time">{data.time}</h1>
            
            <div  className="ingredient-container">
                {data.ingredients?.map((item, i) => (
                    <ul key={i}>
                        <li className="ingredient-step">{data.ingredients[i]}</li>
                    </ul>
                ))}
            </div>
            <div className="instruction-container">
                {data.instructions?.map((item, i) => (
                    <ul key={i}>
                        <li className="instruction-step">{data.instructions[i]}</li>
                    </ul>
                ))}
            </div> */}
        </div>
    )
}

export default Phone;