export default function Inventory(){
    const myInput= useRef();
    function newAlert(){
        alert("This is the latest inventory status for itemID:" + myInput.current.value)
    }
   return(
       <>
        <div > 
            <br/><br/>
            <table >
                <caption>Inventory Table</caption>
         
                    <tr>
                       
                        <td>ItemID</td>
                        <td>Items</td>
                        <td>Quantity</td>
                        <td>Price</td>
                        
                    </tr>
             
                
            </table>  
           
        </div>
        <br/><br/>
        <input ref={myInput}/>
        <button onclick = {newAlert} style= "background-color: pink; color:white"> View Inventory by itemID</button>
   
       </>
   )
}
