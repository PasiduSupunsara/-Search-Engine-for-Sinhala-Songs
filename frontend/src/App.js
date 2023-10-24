import React from 'react';
import './App.css';
import { Route,Routes,BrowserRouter} from 'react-router-dom';
import { Search } from './components/Search';
import { SongCard } from './components/SongCard';
import { GetSong } from './components/GetSong';
import { Hello } from './components/Hello';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
        <Route path="/h" element={<Hello/>}/>
          <Route path="/get" element={<GetSong/>}/>
          <Route path="/" element={<Search/>}/>
          <Route path="/S" element={<SongCard/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
