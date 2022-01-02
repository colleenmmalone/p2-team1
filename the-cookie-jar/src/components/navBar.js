import ReactDOM from 'react-dom';
import React from 'react';

import Settings from "./Settings"
import About from "./About";
import Store from "./Store";
import Home from "./Home";
import "../App.css"
import Orders from './Orders';
import Cart from './Cart';


export default function NavBar() {
  return (
    <div className="App">
     <button onClick={home}>Home</button>&emsp;
     <button onClick={store}>Store</button>&emsp;
     <button onClick={about}>About</button>&emsp;
     <button onClick={settings}>Settings</button>&emsp;
     <button onClick={orders}>Orders</button>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
     <button onClick={cart}>Cart</button>
    </div>
  );
}


function home(){
  ReactDOM.render(
    <React.StrictMode>
      <Home/>
    </React.StrictMode>,
    document.getElementById('main')
  );
}

function store(){
  ReactDOM.render(
    <React.StrictMode>
      <Store />
    </React.StrictMode>,
    document.getElementById('main')
  );
}

function settings(){
  ReactDOM.render(
    <React.StrictMode>
      <Settings />
    </React.StrictMode>,
    document.getElementById('main')
  );
}




function about(){
  ReactDOM.render(
    <React.StrictMode>
      <About />
    </React.StrictMode>,
    document.getElementById('main')
  );
}

function orders(){
  ReactDOM.render(
    <React.StrictMode>
      <Orders />
    </React.StrictMode>,
    document.getElementById('main')
  );
}

function cart(){
  ReactDOM.render(
    <React.StrictMode>
      <Cart />
    </React.StrictMode>,
    document.getElementById('main')
  );
}