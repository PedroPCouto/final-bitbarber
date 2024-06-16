import ApointmentCard from "../ApointmentCard/ApointmentCard";
import './ApointmentPicker.css';
const ApointmentPicker = ({visible, descricao, apointmentData}) => {

    if(!visible) return null;
    return (
        <>
            <div className="apointment_picker" >
            <h2>{descricao}</h2>
            {apointmentData.map((apointment, index) => {
                return(
                    <ApointmentCard key={index} data={apointment}  />
                    )
            })}
            </div>
        </>
    )
}

export default ApointmentPicker;