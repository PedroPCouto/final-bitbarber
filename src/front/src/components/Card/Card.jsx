import 'animate.css';

const Card = ({ title, image, selectService, isSelected, identifier }) => {
    const handleClick = () => {
        selectService(identifier);
    }
    return(
    <div className={isSelected ? "card cardSelected animate__fadeInDown animate__animated " : "card animate__fadeInDown animate__animated "} onClick={handleClick}>
        <img src={image} alt="Corte" className="img-service-selection"/>
        <div className="card-container">
            <h3><b>{title}</b></h3>
        </div>
    </div>
    )
}

export default Card;