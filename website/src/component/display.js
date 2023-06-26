import axios from "axios";
import { useEffect, useRef, useState } from "react";
import React from "react";
import './styles/Display.css'

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

    const [data, setData] = useState(null);

    useInterval(() => {
        axios.get("http://localhost:8080/display").then((response) => {
            setData(response.data);
        }).catch(e => {
            setData("none");
        });
    },100*10);

    useEffect(() => {
        axios.get("http://localhost:8080/display").then((response) => {
            setData(response.data);
        }).catch(e => {
            setData("none");
        });
    }, []);
    
    if (!data) return null;

    return (
        <div className="recipe-container">
            <h1 className="recipe-name">{data.name}</h1>
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
            </div>
        </div>
    )
}

export default Display;