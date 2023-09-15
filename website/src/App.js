import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Display from "./component/Display";
import Phone from "./component/RecipeList";

function App() {
    return (
    <Router>
        <Routes>
            <Route path='' element={<Phone />} />
            <Route path='display' element={<Display />} />
        </Routes>
    </Router>
    )
}

export default App;