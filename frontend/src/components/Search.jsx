import React, { useState, useEffect } from 'react';
import { Card } from "antd";
import { Select, Space } from 'antd';


export const Search =() =>{
  const [searchTerm, setSearchTerm] = useState('');
  const [searchTick, setSearchTick] = useState('lyricists');

  
  const [songs, setSongs] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/songs/matchAllSongs')
      .then((response) => response.json())
      .then((data) => setSongs(data))
      .catch((error) => console.error('Error fetching data: ', error));
  }, []);
 
  const handleSearch = (search) => {
    setSearchTerm(search)
    const val = {searchTerm}
    console.log(val)

    fetch('http://localhost:8080/songs/matchLyristicsAllSongs',{
          method:"POST",
          headers:{"Content-Type":"application/json"
        },
          body:JSON.stringify(val)
      }).then((response)=>{
        console.log(response)
        
    })
  };

  const handleChange = (value) => {
    setSearchTick(value)
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

          <Space className='drop'>
    <Select
      defaultValue="lyricists"
      style={{
        width: 120,
      }}
      onChange={handleChange}
      options={[
        {
          value: 'Year',
          label: 'Year',
        },
        {
          value: 'lyricists',
          label: 'lyricists',
        },
        {
          value: 'lyrisc',
          label: 'lyrisc',
        },
      ]}
    />
    
  </Space>
        </div>
       
       
        
  <div className="App">
      <h1>Song List</h1>

      {songs.map((song) => (
        <Card key={song.id} title={song.songNameInSinahala}>
          <p>Year: {song.year}</p>
          <p>Lyricists: {song.lyricists}</p>
        </Card>
      ))}
    </div>
    </div>
  );
}

