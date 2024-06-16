import './TimePicker.css';
const TimePicker = ({agendaBarbeiro, selectHorario, isSelected}) => {
    const horarios = [
            {horario: 9,disponivel: true},
            {horario: 10,disponivel: true},
            {horario: 11,disponivel: true},
            {horario: 12,disponivel: true},
            {horario: 14,disponivel: true},
            {horario: 15,disponivel: true},
            {horario: 16,disponivel: true},
            {horario: 17,disponivel: true},
            {horario: 18,disponivel: true},
            {horario: 19,disponivel: true}];
            
    const handleSelection = (e) => {
        if(!e.target.classList.contains("horario-disponivel")) return;
        const horarioSelecionado = document.querySelector(".horario-selecionado");
        if(horarioSelecionado){
            horarioSelecionado.classList.remove("horario-selecionado");
        }
        e.target.classList.toggle("horario-selecionado");
        const horario = e.target.innerHTML.split(":")[0];
        selectHorario(horario);
    }

    const horariosMarcados = agendaBarbeiro.map((horario, index) => {
        return horario.hora;
    })

    for(let i = 0; i < horarios.length; i++){
        if(horariosMarcados.includes(horarios[i].horario)){
            horarios[i].disponivel = false;
        }
    }

    

    return(
        <>
            {horarios.map((horario, index) => {
                return(
                    <div key={horario.horario} className={horario.disponivel ? "horario-disponivel horarioAgenda" : "horario-indisponivel horarioAgenda"} onClick={handleSelection}>
                        {horario.horario + ":00"}
                    </div>
                    )
            })}
        </>
    )
}

export default TimePicker;