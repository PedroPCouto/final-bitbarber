import './App.css';
import Login from './components/Login/login';
import Contract from './components/Contract/Contract';
import Home from './components/Home/home';
import Indicadores from './components/Indicadores/Indicadores';

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Register from './components/Register/register';
import Feedback from './components/Feedback/Feedback';
import CupomManager from './components/CupomManager/CupomManager';
import About from './components/About/About';

const router = createBrowserRouter([
  {path: '/', element: <Home />},
  {path: '/login', element: <Login />},
  {path: '/register', element: <Register/>},
  {path: '/contract', element: <Contract/>},
  {path: '/feedback', element: <Feedback/>},
  {path: '/cupom', element: <CupomManager/>},
  {path: '/indicadores', element: <Indicadores/>},
  {path: '/about', element: <About/>},
])


function App() {

  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
