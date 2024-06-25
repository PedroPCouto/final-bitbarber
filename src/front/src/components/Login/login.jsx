import './login.css';
import { useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import {AuthContext} from "../../AuthProvider/AuthProvider";

const Login = () => {
    
    const {login} = useContext(AuthContext);
    const [isValid, setIsValid] = useState(false);

    let navigate = useNavigate(); 
    const backHome = () =>{ 
      let path = `/`; 
      navigate(path);
    }  


    const handleSubmit = (e) => {
        e.preventDefault();
        const email = document.getElementById("username").value;
        let dominio = "http://3.144.215.154:8080/";
        if(email.indexOf('@bitbarberadmin')>=0){
            dominio = dominio + "gerente/";
        } else {
            dominio = dominio + "cliente/";
        }
        const senha = document.getElementById("password").value;
        const endpoint = `${dominio}login?email=${email}&senha=${senha}`;
        fetch(endpoint, {
            method: 'GET'
        }).then(response => {
            if(!response.ok){
                alert("Email ou senha incorretos");
                return;
            }
            response.json().then(data => {
                login(data.infos);
                backHome();
            })
        })
    }

    const handleEmail = (e) => {
        const email = e.target.value;
        const emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const emailRegex2 = /^[a-zA-Z0-9]+\.[A-Za-z]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const emailRegex3 = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+\.[A-Za-z]$/;
        const emailRegex4 = /^[a-zA-Z0-9]+\.[A-Za-z]+@[a-zA-Z0-9]+\.[A-Za-z]+\.[A-Za-z]+$/;
        const emailRegex5 = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+\.[A-Za-z]+$/;
        if(emailRegex.test(email) || emailRegex2.test(email) || emailRegex3.test(email) || emailRegex4.test(email) || emailRegex5.test(email)){
            document.getElementById("emailError").innerText = "";
            setIsValid(true);
            return;
        }
        setIsValid(false);

    }
    

    return(
<>
<div className="container">
        <div className="header-form">
            <div id="seta" onClick={backHome}></div>
        </div>
        <h2>Bem vindo a BitBarber!</h2>
        <p>Por favor entre com seu email e senha</p>
        <form className='form-login'>
            <div className="input-group-login">
                <label htmlFor="username">Email:</label>
                <input type="text" onBlur={handleEmail} id="username" name="username" required/>
            </div>
            <span id="emailError" className="error-message"></span>
            <div className="input-group-login" >
                <label htmlFor="password">Senha:</label>
                <input type="password" id="password" name="password" required/>
            </div>
            <button type="submit" onClick={handleSubmit} className='btn-default' disabled={!isValid}>Entrar</button>
        </form>
        <p>Não está cadastrado ainda? <a href="/register">Entre aqui</a></p>
    </div>
    </>
    );
}

export default Login;