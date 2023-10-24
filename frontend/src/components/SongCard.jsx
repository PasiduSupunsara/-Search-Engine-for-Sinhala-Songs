import { Card } from "antd";
import myImage from '../images/music.jpg'; 

export function SongCard(props){

    const textWithLineBreaks = props.lyrisc;
    const lines = textWithLineBreaks.split('\n');

    return(
        <Card className="SongCard">
            <div >
                <img className="music-image" src={myImage} alt="Music" />
                <h1>{props.name} </h1>
                {lines.map((line, index) => (
        <p key={index}>{line}</p>
      ))}
            </div> 
        </Card>
    )
}