import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Display from "./component/display";
import Phone from "./component/phone";

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