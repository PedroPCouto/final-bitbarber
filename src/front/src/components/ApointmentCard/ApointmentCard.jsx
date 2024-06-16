import { useContext } from 'react';
import './ApointmentCard.css';
import { useNavigate } from "react-router-dom";
import { FeedbackContext } from '../../FeedbackContextProvider/FeedbackContextProvider';



const ApointmentCard = ({data, descricao}) => {
    let navigate = useNavigate();
    const {setServicoAgendaId} = useContext(FeedbackContext);
    const giveFeedback = () => {
        setServicoAgendaId(data.codigoServicoAgendado)
        navigate('/feedback');
    }

    return (
        <div className="apointment-card" onClick={giveFeedback}>
            <div className="apointment-card__header">
                <h3>Cliente:{data.cliente.nome}</h3>
                <p>Barbeiro:{data.barbeiro.nome}</p>
            </div>
            <div className="apointment-card__body">
                <p>Data: {data.dataMarcada}</p>
                <p>Horário: {`${data.hora}:00`}</p>
                <p>Serviço: Corte de cabelo</p>
            </div>
        </div>
    );
}

export default ApointmentCard;