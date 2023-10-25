import { useEffect, useState } from "react"
import { Card } from "antd";

export const GetSong = () => {
    const [songs, setSongs] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/songs/matchAllSongs')
      .then((response) => response.json())
      .then((data) => setSongs(data))
      .catch((error) => console.error('Error fetching data: ', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/songs/matchAllSongs')
      .then((response) => response.json())
      .then((data) => setSongs(data))
      .catch((error) => console.error('Error fetching data: ', error));
  }, []);

  return (
    <div className="App">
      <h1>Song List</h1>
      {songs.map((song) => (
        <Card key={song.id} title={song.songNameInSinahala}>
          <p>Year: {song.year}</p>
          <p>Lyricists: {song.lyricists}</p>
          <h3>Lyrics</h3>
          <pre>{song.lyrics}</pre>
        </Card>
      ))}
    </div>
  );
}