import { useEffect, useState } from "react"
import { SongCard } from "./SongCard";


export const GetSong = () => {
    const[songs,setSongs] = useState([]);

    useEffect(()=>{
        fetch('http://localhost:8080/apis/findall',{
             method:"GET"
           }).then((response)=>
           response.json())
           .then((result)=>{
            setSongs(result.content);
            console.log(songs)
       })
    },[songs]);

    
    return (
        <>{songs.map((song) => <SongCard title={song.name} id={song.id} price={song.price}
        />)}
        </>
       
        )
}