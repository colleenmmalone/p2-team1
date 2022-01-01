

export default function NavBar() {
  return (
    <div className="App" onLoad="title()" >
     <a href="">Home</a>&emsp;
     <a href="">Store</a>&emsp;
     <a href="">About</a>&emsp;
     <a href="">Settings</a>&emsp;
    </div>
  );
}

/*
function title(){
    var head = document.getElementById("pageTitle");
    head.innerHTML = "hello";
}
*/