import { useEffect, useState } from "react"


export const Hello = () => {
    const[messages,setMessages] = useState([]);

    useEffect(()=>{
        fetch('http://localhost:8080/p',{
             method:"GET"
           }).then((response)=>
           response.json())
           .then((result)=>{
           setMessages(result);
       })
    },[]);
  

    
    return (
        <div>{messages}</div>
        )
}