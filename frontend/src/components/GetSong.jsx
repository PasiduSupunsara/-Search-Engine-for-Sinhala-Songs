import { useEffect, useState } from "react"
import { SongCard } from "./SongCard";


export const GetSong = () => {
    const[songs,setSongs] = useState([]);

    useEffect(()=>{
        fetch('http://localhost:8080/songs/matchAllSongs',{
             method:"GET"
           }).then((response)=>
           response.json())
           .then((result)=>{
            setSongs(result);
            console.log(songs)
       })
    },[]);
  

    
    return (
        <>{songs.map((song) => <SongCard name={song.name} lyrisc={song.lyrisc}
        />)}
        </>
       
        )
}