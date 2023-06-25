import axios from "axios";
import { useEffect, useRef, useState } from "react";
import React from "react";


export const useInterval = (callback, delay) => {
    const savedCallback = useRef();
    useEffect(() => {
        savedCallback.current = callback;
    }, [callback]);

    useEffect(() => {
        function tick() {
        savedCallback.current();
    }
        if (delay !== null) {
            const id = setInterval(tick, delay);
            return () => clearInterval(id);
        }
    }, [delay]);
}

function Display() {

    const [data, setData] = React.useState(null);

    React.useEffect(() => {
        axios.get("http://localhost:8080/recipe/6").then((response) => {
        setData(response.data);
        });
    }, []);
    
    if (!data) return null;

    return (
        <div>
            <h1>{data.name}</h1>
            {data.ingredients.map((item, i) => (
                <ul key={i}>
                  <li>{data.ingredients[i]}</li>
                </ul>
              ))}
        </div>
    )
}

export default Display;