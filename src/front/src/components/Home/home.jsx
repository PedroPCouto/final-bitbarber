import Navbar from "../Navbar/navbar";
import ApointmentPicker from "../ApointmentPicker/ApointmentPicker";
import { AuthContext } from '../../AuthProvider/AuthProvider';
import { useEffect, useContext, useState } from "react";
import './home.css';
import "react-multi-carousel/lib/styles.css";

const Home = () => {
  const {isLoggedIn} = useContext(AuthContext);
  const {user} = useContext(AuthContext);
  const [newApointments, setnewApointments] = useState([]);
  const [pastApointments, setpastApointments] = useState([]);


  useEffect(() => {
    if(isLoggedIn === true){
        fetch(`http://18.217.70.108:8080/apointment/getNewApointments?clientId=${user.email}`).then(response => {
          response.json().then(data => {
            setnewApointments(data);
          });
        })
        fetch(`http://18.217.70.108:8080/apointment/getPastApointments?clientId=${user.email}`).then(response => {
          response.json().then(data => {
            setpastApointments(data);
          });
        })
    }
  }, [isLoggedIn, user]);

  return (
    <>
      <Navbar/>
      <div className="home-container">
        <ApointmentPicker descricao="Sua agenda" path={'/'} visible={isLoggedIn && user?.email.indexOf('@bitbarberadmin') < 0} apointmentData={newApointments}/> 
        <ApointmentPicker descricao="Serviços passados" path={'/feedback'} visible={isLoggedIn && user?.email.indexOf('@bitbarberadmin') < 0} apointmentData={pastApointments}/>
      </div>
    </>
  );
}

export default Home;