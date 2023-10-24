import { Card } from "antd";
import myImage from '../images/music.jpg'; 

export function SongCard(props){


    return(
        <Card className="SongCard">
            <div >
                <img className="music-image" src={myImage} alt="Music" />
                <h1>{props.title} </h1>
                <h1>{props.id}</h1>
                <h1>{props.price}</h1>
                <h1>{props.description}</h1> 
            </div> 
        </Card>
    )
}