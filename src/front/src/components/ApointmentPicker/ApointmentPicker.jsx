import ApointmentCard from "../ApointmentCard/ApointmentCard";
import './ApointmentPicker.css';
const ApointmentPicker = ({visible, descricao, apointmentData, path}) => {

    if(!visible) return null;
    return (
        <>
            <h2 className="color-white-style">{descricao}</h2>
            <div className="apointment_picker" >
            {apointmentData.map((apointment, index) => {
                return(
                    <ApointmentCard key={index} data={apointment} path={path}  />
                    )
            })}
            </div>
        </>
    )
}

export default ApointmentPicker;