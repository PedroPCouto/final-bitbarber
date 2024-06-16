import React, { createContext, useState } from 'react';

export const FeedbackContext = createContext();

const FeedbackContextProvider = ({ children }) => {
  const [servicoAgendaId, setServicoAgendaId] = useState(null); 


  return (
    <FeedbackContext.Provider value={{servicoAgendaId, setServicoAgendaId}}>
      {children}
    </FeedbackContext.Provider>
  );
};

export default FeedbackContextProvider;
