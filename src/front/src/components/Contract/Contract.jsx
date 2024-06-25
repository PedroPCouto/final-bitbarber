import corte from '../../resources/corte_cabelojpg.jpg'
import barba from '../../resources/trimming-beard.jpg'
import pintura from '../../resources/pintura_cabelo.jpg'
import './Contract.css'
import Navbar from "../Navbar/navbar";
import Card from "../Card/Card";
import {useState, useEffect, useContext} from "react";
import 'animate.css';
import TimePicker from '../TimePicker/TimePicker';
import CalendarDatePicker from '../CalendarDatePicker/CalendarDatePicker';

import { AuthContext } from '../../AuthProvider/AuthProvider';
import { useNavigate } from "react-router-dom";
import CupomPicker from '../CupomPicker/CupomPicker';





const Contract = () => {
    const {user} = useContext(AuthContext);
    const [service, setService] = useState('');
    const [date, setDate] = useState('');
    const [barbeiro, setBarbeiro] = useState('');
    const [horario, setHorario] = useState('');
    const [cupons, setCupons] = useState(null);
    const [selectedCupom, setSelectedCupom] = useState(0);

    let navigate = useNavigate(); 
    const backHome = () =>{ 
      let path = `/`; 
      navigate(path);
    }  

    const [dadosIniciais, setDadosIniciais] = useState(null);
    const [dadosAgenda, setDadosAgenda] = useState([]);

    const selectService = (serviceTitle) => {
        setService(serviceTitle);
    }
    
    const selectBarbeiro = (barbeiroTitle) => {
        setBarbeiro(barbeiroTitle);
    }
    

    const handleDateChange = (newValue) => {
        const dateObj = new Date(newValue);
        const year = dateObj.getFullYear();
        const month = (dateObj.getMonth() + 1).toString().padStart(2, '0'); 
        const day = dateObj.getDate().toString().padStart(2, '0');
        const outputDateString = year + '-' + month + '-' + day;
        setDate(outputDateString); 
    }

    useEffect(() => {
        if(dadosIniciais === null){
            fetch(`http://3.144.215.154:8080/barbeiro/getAll`, {
                method: 'GET'
            }).then(response => {
                response.json().then(data => {
                    setDadosIniciais(data);
                })
            })
        }

        if(user !== null){
            fetch(`http://3.144.215.154:8080/cupom/getCuponsByCliente?email=${user.email}`, {
                method: 'GET'
            }).then(response => {
                response.json().then(data => {
                    setCupons(data);
                })
            })
        }


        if(date !== '' && barbeiro !== ''){
            fetch(`http://3.144.215.154:8080/apointment/getForScheduling?data=${date}&barbeiro=${barbeiro}`, {
                method: 'GET'
            }).then(response => {
                response.json().then(data => {
                    setDadosAgenda(data);
                })
            })
        }
    }, [date, barbeiro, dadosIniciais, user]);


    const realizarAgendamento = () => {
        const horarioNumber = parseInt(horario);
        fetch(`http://3.144.215.154:8080/apointment/createNewApointment`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                barbeiro: barbeiro,
                cliente: user.email,
                horario: horarioNumber,
                data: date,
                servico: service,
                cupom: selectedCupom
            }),
        }).then(response => {
            response.json().then(data => {
                alert(data.message);
                backHome()

            })
        })
    }

    return (

       <>
       <Navbar/>
       <div className='service-selector animate__fadeInDown animate__animated'>
        <h1 className='color-white-style'>Escolha um serviço</h1>
            <div className='service-cards-container'>
            <Card image={corte} title="Corte" isSelected={"Corte" === service} identifier="Corte" selectService={selectService}/>
            <Card image={barba} title="Barba" isSelected={"Barba" === service} identifier="Barba" selectService={selectService}/>
            <Card image={pintura} title="Pintura" isSelected={"Pintura" === service} identifier="Pintura" selectService={selectService}/>
            </div>
        </div>
       <div className='service-selector animate__fadeInDown animate__animated'>
        <h1 className='color-white-style'>Escolha um profissional</h1>
            <div className='service-cards-container'>
            {dadosIniciais && dadosIniciais.map((barbeiroData, index) => {
                return(
                    <Card key={index} image={barbeiroData.profilPictureURL} title={barbeiroData.nome} identifier={barbeiroData.email} isSelected={barbeiroData.email === barbeiro} selectService={selectBarbeiro}/>
                )
            })}
            </div>
        </div>
        <div className='service-selector animate__fadeInDown animate__animated'>
        <h1 className='color-white-style'>Escolha uma data</h1>
            <div className='service-cards-container'>
                <CalendarDatePicker handler={handleDateChange}/>
            </div>
        </div>
        <div className='service-selector animate__fadeInDown animate__animated'>
            <h1 className='color-white-style'>Escolha um horário</h1>
            <div className='service-cards-container'>
                <TimePicker agendaBarbeiro={dadosAgenda} selectHorario={setHorario}/>
            </div>
        </div>
        <CupomPicker setSelectedCupom={setSelectedCupom} cupons={cupons}/>
        <div className='agendamento-botao'>
            <button className='btn-default' onClick={realizarAgendamento}>Agendar</button>
        </div>
        </>

    );
}

export default Contract;