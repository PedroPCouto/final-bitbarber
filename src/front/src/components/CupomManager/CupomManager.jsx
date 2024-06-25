import UserTable from '../UserTable/UserTable';
import Navbar from '../Navbar/navbar';
import './CupomManager.css';
import {useState, useEffect, useContext} from "react";
import { AuthContext } from '../../AuthProvider/AuthProvider';

const CupomManager = () => {

    const {isLoggedIn, user} = useContext(AuthContext);

    const [selectedUsers, setSelectedUsers] = useState([]);
    const [daySpan, setDaySpan] = useState(null);
    const [userData, setUserData] = useState([]);
    const selectTimeSpan = (e) => {
        const elements = document.getElementsByClassName('selection-per-date');
        for(let i = 0; i < elements.length; i++){
            elements[i].className = 'selection-per-date';
        }
        e.target.className = 'selection-per-date time-span-selected';
        const span = parseInt(e.target.innerText.substring(0,2));
        if(daySpan === span) return;
        setDaySpan(span);
    }

    

    const criarCupom = (e) => {

        e.preventDefault();
        


        try {
            const nomeCupom = document.getElementsByClassName('nome-cupom')[0].value;
            const valorCupom = document.getElementsByClassName('valor-cupom')[0].value;
            const dataCupom = document.getElementsByClassName('data-cupom')[0].value;

            if(nomeCupom === '' || valorCupom === '' || dataCupom === '') throw new Error('Parâmetros do cupom inválidos');

            const dataExpiracao = new Date(dataCupom);
            if(dataExpiracao.toString() === 'Invalid Date') throw new Error('Data inválida');
            const desconto = parseInt(valorCupom);
            if(isNaN(desconto)) throw new Error('Valor inválido');

            const data = {
                nomeCupom,
                desconto,
                dataCupom,
                selectedUsers
            }
            fetch('http://3.144.215.154:8080/cupom/createCupom', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            }).then(response => {
                response.json().then(data => {
                    alert(data.message);
                })
            }).catch(e => {
                alert(e.message)
            }
            )
        }catch(e){
            alert('Parâmetros do cupom inválidos');
            return;
        }
    }
    useEffect(() => {
        if(daySpan === null) return;

        fetch(`http://3.144.215.154:8080/cliente/getClientesAusentes?days=${daySpan}`, {
        }).then(response => {
            response.json().then(data => {
                setUserData(data);
            })
        })

    
    }, [daySpan])

    if(user?.email.indexOf('@bitbarberadmin') < 0 || !isLoggedIn){
        return;
    }

    return (<>
    <div className="body-cupom-manager">
    <Navbar/>
    
    <div className="cupom-cliente-selector">
        <h3 className='selection-per-date' onClick={selectTimeSpan}>30 dias</h3>
        <h3 className='selection-per-date' onClick={selectTimeSpan}>60 dias</h3>
        <h3 className='selection-per-date' onClick={selectTimeSpan}>90 dias</h3>
    </div>
    <UserTable userData={userData} selectedUsers={selectedUsers} setSelectedUsers={setSelectedUsers}/>

    <div className='form-cupom-container'>
    <div className="ticketContainer">
  <div className="ticket">
    <input type='text' placeholder='Nome do cupom' className="ticketTitle nome-cupom"/>
    <hr/>
    <div className="ticketDetail">
    <input type='text' placeholder='Valor R$' className='ticketTitle valor-cupom'/>

    </div>
    <div className="ticketRip">
      <div className="circleLeft"></div>
      <div className="ripLine"></div>
      <div className="circleRight"></div>
    </div>
    <div className="ticketSubDetail">
    <input type='text' className='data-cupom' placeholder='AAAA-MM-DD'/>

    </div>
  </div>
  <div className="ticketShadow"></div>
</div>

<button className='btn-default-cupom' onClick={criarCupom}>Gerar cupom</button>
    </div>
    </div>
    </>)
}

export default CupomManager;