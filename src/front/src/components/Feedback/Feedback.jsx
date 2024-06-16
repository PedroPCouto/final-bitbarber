import './Feedback.css'

import React, { useContext } from 'react';
import { FeedbackContext } from '../../FeedbackContextProvider/FeedbackContextProvider';

const Feedback = () => {

    const {servicoAgendaId} = useContext(FeedbackContext);

    const sendFeedback = (e) => {
        e.preventDefault();
        const avaliacao = parseInt(document.querySelector('input[name="rate"]:checked').value);
        fetch('http://localhost:8080/feedback/createNewFeedback', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                servicoAgenda: servicoAgendaId,
                avaliacao: avaliacao,
                comentario: document.querySelector('.feedback-textarea').value

            })
        }).then(response => {
            response.json().then(data => {
            });
        }).catch(err => {
            alert('Erro ao enviar feedback')
        });
    }

    return (
        <div className='feedback-container'>
            <h2>Dê seu Feedback</h2>
            <form>
            <div className="rate">
                <input type="radio" id="star5" name="rate" value="5" />
                <label htmlFor="star5" title="text">5 stars</label>
                <input type="radio" id="star4" name="rate" value="4" />
                <label htmlFor="star4" title="text">4 stars</label>
                <input type="radio" id="star3" name="rate" value="3" />
                <label htmlFor="star3" title="text">3 stars</label>
                <input type="radio" id="star2" name="rate" value="2" />
                <label htmlFor="star2" title="text">2 stars</label>
                <input type="radio" id="star1" name="rate" value="1" />
                <label htmlFor="star1" title="text">1 star</label>
            </div>
            <div><textarea className='feedback-textarea'></textarea></div>
            <button className='feedback-button' onClick={sendFeedback}>Enviar</button>
            </form>
        </div>
    );
}

export default Feedback;