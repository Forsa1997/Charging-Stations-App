import logo from './logo.svg';
import './App.css';
import Nav from './components/Nav';
import {
  Routes,
  Route,
  BrowserRouter,
} from "react-router-dom";
import Home from './components/Home';
import Map from './components/Map'

function App() {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/map" element={<Map />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;


