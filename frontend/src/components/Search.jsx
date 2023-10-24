import React, { useState } from 'react';
import { Select, Space } from 'antd';


export const Search =() =>{
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [songs, setSongs] = useState([]);
  

  const handleChange = (value) => {
    console.log(`selected ${value}`);
  };

  const handleSearch = () => {
    const filteredSongs = songs.filter(song => song.toLowerCase().includes(searchTerm.toLowerCase()));
    setSearchResults(filteredSongs);
    console.log(searchTerm)
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
        <Space wrap>
    <Select
      defaultValue="lucy"
      style={{
        width: 120,
      }}
      onChange={handleChange}
      options={[
        {
          value: 'jack',
          label: 'Jack',
        },
        {
          value: 'lucy',
          label: 'Lucy',
        },
        {
          value: 'Yiminghe',
          label: 'yiminghe',
        },
      ]}
    />    
  </Space>
          
        

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

