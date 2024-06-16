import "./CupomPicker.css";

const CupomPicker = ({cupons, setSelectedCupom}) => {

    const selectCupom = (e, selectedCupom) => {
        const cupomCards = document.querySelectorAll('.cupom-card-selected');
        cupomCards.forEach(card => {
            card.classList.remove('cupom-card-selected');
            card.classList.add('cupom-card');
        })
        e.currentTarget.classList.remove('cupom-card');
        e.currentTarget.classList.add('cupom-card-selected');
        setSelectedCupom(selectedCupom.codigoCupom);
    }

    if(cupons === null) return null;
    return (        
    <div className='service-selector animate__fadeInDown animate__animated'>
        <h1>Escolha um cupom</h1>
        <div className='service-cards-container'>
            {cupons && cupons.map((cupom, index) => {
                return(
                    <div key={index} className='cupom-card' onClick={(e) => selectCupom(e, cupom)}>
                        <h2>{cupom.nomeCupom}</h2>
                        <p>{cupom.dataExpiracao}</p>
                        <p>Desconto: {cupom.desconto}%</p>
                    </div>
                )
            })}
        </div>
    </div>)
}

export default CupomPicker;