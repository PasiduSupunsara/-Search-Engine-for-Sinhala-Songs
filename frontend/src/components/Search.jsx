import React, { useState } from 'react';
import { Checkbox } from 'antd';


export const Search =() =>{
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);

  const songs = [
    "Song 1",
    "Song 2",
    "Song 3",
    "Song 4",
    "Song 5"
  ];

  const handleSearch = () => {
    const filteredSongs = songs.filter(song => song.toLowerCase().includes(searchTerm.toLowerCase()));
    setSearchResults(filteredSongs);
    console.log(searchTerm)
  };

  const onChange = (e) => {
    console.log(`checked = ${e.target.checked}`);
  };

  return (
    <div className="search">

        <div className="search-bar">
          <input
            className='bar'
            type="text"
            placeholder="Search for a song..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <button className="search-button" onClick={handleSearch}>Search</button>
        </div>
        <div className='check'>
          <Checkbox onChange={onChange}>Title</Checkbox>
          <Checkbox onChange={onChange}>Lyricist</Checkbox>
          <Checkbox onChange={onChange}>Year</Checkbox>
          <Checkbox onChange={onChange}>Metaphor</Checkbox>
          <Checkbox onChange={onChange}>Meaning</Checkbox>
          
        </div>
          
        

      <div className="results">
        <h2>Search Results</h2>
        <ul>
          {searchResults.length === 0 ? (
            <p>No results found</p>
          ) : (
            searchResults.map((song, index) => (
              <li key={index}>{song}</li>
            ))
          )}
        </ul>
      </div>
    </div>
  );
}

