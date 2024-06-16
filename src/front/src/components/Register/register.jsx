import './register.css';
import { useNavigate } from "react-router-dom";
import { useState, useEffect, useContext } from "react";
import {AuthContext} from "../../AuthProvider/AuthProvider";




const Register = () => {
    const {login} = useContext(AuthContext);

    let [isValid, setIsValid] = useState(false);
    let [isEmailValid, setIsEmailValid] = useState(false);
    let [isPasswordValid, setIsPasswordValid] = useState(false);
    let [isRepeatedPasswordValid, setIsRepeatedPasswordValid] = useState(false);
    let [isBirthDateValid, setIsBirthDateValid] = useState(false);


    let navigate = useNavigate(); 
    const backHome = () =>{ 
      let path = `/`; 
      navigate(path);
    }

    useEffect(() => {
        setIsValid(isEmailValid && isPasswordValid && isRepeatedPasswordValid && isBirthDateValid);

    }, [isEmailValid, isPasswordValid, isRepeatedPasswordValid, isBirthDateValid]);

    
    const handleEmail = (e) => {
        const email = e.target.value;
        const emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const emailRegex2 = /^[a-zA-Z0-9]+\.[A-Za-z]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const emailRegex3 = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+\.[A-Za-z]$/;
        const emailRegex4 = /^[a-zA-Z0-9]+\.[A-Za-z]+@[a-zA-Z0-9]+\.[A-Za-z]+\.[A-Za-z]+$/;
        if(emailRegex.test(email) || emailRegex2.test(email) || emailRegex3.test(email) || emailRegex4.test(email)){
            document.getElementById("emailError").innerText = "";
            setIsEmailValid(true);
        

            return;
        }
        setIsEmailValid(false);

    }

    const handlePassword = (e) => {

        const password = e.target.value;
        
        if(password.length >= 6 && /\d/.test(password)){
            document.getElementById("passwordError").innerText = "";
            setIsPasswordValid(true);
        

            return;
        }
        setIsPasswordValid(false);


    }

    const throwEmailMessage = (e) => { 
        if(!isEmailValid){
            document.getElementById("emailError").innerText = "Por favor, insira seu usuário corretamente, deve conter '@' e '.com' ou '.com.br'";
        }
    }

    const throwPasswordMessage = (e) => {
        if(!isPasswordValid){
            document.getElementById("passwordError").innerText = "Sua senha deve conter no mínimo 6 caracteres e ao menos um número";
        }
    }

    const throwRepeatPasswordMessage = (e) => {
        if(!isRepeatedPasswordValid){
            document.getElementById("repeatedPasswordError").innerText = "As senhas não coincidem";
        }
    }

    const handleRepeatedPassword = (e) => {
        const password = e.target.value;
        const passwordValue = document.getElementById("password").value;
        if(password === passwordValue){
            document.getElementById("repeatedPasswordError").innerText = "";
            setIsRepeatedPasswordValid(true);
        

            return;
        }
        setIsRepeatedPasswordValid(false);

    }

    const handleBirthDate = (e) => {
        const birthDate = e.target.value;
        const date = new Date(birthDate);
        const dataAtual = new Date();
        const anoAtual = dataAtual.getFullYear();
        const mesAtual = dataAtual.getMonth() + 1;
        const diaAtual = dataAtual.getDate();
    
        const anoDeNascimento = date.getFullYear();
        const mesDeNascimento = date.getMonth() + 1;
        const diaDeNascimento = date.getDate();
    
        let idade = anoAtual - anoDeNascimento;
    
        if (mesAtual < mesDeNascimento || (mesAtual === mesDeNascimento && diaAtual < diaDeNascimento)) {
            idade--;
        }

        if(date > dataAtual){
            document.getElementById("birthDateError").innerText = "A data de nascimento não pode ser maior que a data atual";
            setIsBirthDateValid(false);
            return;
        }else if(idade < 12){
            document.getElementById("birthDateError").innerText = "Você deve ter mais de 12 anos para se cadastrar";
            setIsBirthDateValid(false);
            return;
        }
        document.getElementById("birthDateError").innerText = "";
        setIsBirthDateValid(true);
        
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        const nome = document.getElementById("nome").value;
        const username = document.getElementById("username").value;
        if(username.indexOf('@bitbarberadmin') >= 0){
            alert("O domínio desse email não pertence a você, por favor insira um email válido");
            return;
        }
        const birthDate = document.getElementById("birthDate").value;
        const password = document.getElementById("password").value;
        const user = {
            nome: nome,
            email: username,
            dataAniversario: birthDate,
            senha: password,
        }

        fetch('http://localhost:8080/cliente/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        }).then(response => {
            response.json().then(data => {
                login(user);
                alert(data.message);
                backHome();
            })
        }).catch(error => {
            console.error('Error:', error);
            alert("Erro ao se conectar com o servidor, tente novamente mais tarde.");
        })
    }


    return (
<>
<div className="container">
        <div className="header-form">
        <div id="seta" onClick={backHome}></div>
        </div>
        <h2>Bem vindo a BitBarber!</h2>
        <p>Por favor se registre</p>
        <form className="form-register">
            <div className="input-group">
                <label htmlFor="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required/>
            </div>
            <div className="input-group">
                <label htmlFor="username">Email:</label>
                <input type="text" id="username" name="username" onChange={handleEmail} onBlur={throwEmailMessage} required/>
            </div>
            <span id="emailError" className="error-message"></span>
            <div className="input-group">
                <label htmlFor="birthDate">Data de nascimento:</label>
                <input type="date" id="birthDate" name="birthDate" className='date__input' onChange={handleBirthDate}  required/>
            </div>
            <span id="birthDateError" className="error-message"></span>
            <div className="input-group">
                <label htmlFor="password">Senha:</label>
                <input type="password" id="password" name="password" onChange={handlePassword} onBlur={throwPasswordMessage} required/>
            </div>
            <span id="passwordError" className="error-message"></span>
            <div className="input-group">
                <label htmlFor="repeatPassword">Repita a senha:</label>
                <input type="password" id="repeatPassword" name="repeatPassword" onChange={handleRepeatedPassword} onBlur={throwRepeatPasswordMessage} required/>
            </div>
            <div id="repeatedPasswordError" className="error-message"></div>
            <button type="submit" className='btn-default' onClick={handleSubmit} disabled={!isValid}>Registrar</button>
        </form>
        <p>Já está cadastrado? <a href="/login">Entre aqui</a></p>
    </div>
    </>
    );
}

export default Register;