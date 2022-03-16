import logo from './logo.svg';
import './App.css';
import Nav from './components/Nav';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Home from './components/Home';

function App() {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/map" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;


