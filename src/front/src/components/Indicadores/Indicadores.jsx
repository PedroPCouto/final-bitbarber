import Navbar from "../Navbar/navbar";
import { BarChart } from '@mui/x-charts/BarChart';
import './Indicadores.css'
import { PieChart } from '@mui/x-charts/PieChart';
import { useEffect, useState, useContext } from "react";
import { AuthContext } from '../../AuthProvider/AuthProvider';


const Indicadores = () => {
    const {isLoggedIn, user} = useContext(AuthContext);


    const [indicador1, setIndicador1] = useState([])
    const [indicador2, setIndicador2] = useState([])
    const [indicador3, setIndicador3] = useState([])
    const [indicador4, setIndicador4] = useState([])


    useEffect(() => {
        fetch('http://localhost:8080/cliente/getQuantidadeClientesPorMes', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            response.json().then((data) => {
                setIndicador1(data)
            })
        })

        fetch('http://localhost:8080/apointment/obterQuantidadeServicosPorFeedback', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            response.json().then((data) => {
                setIndicador2(data)
            })
        })

        fetch('http://localhost:8080/cupom/obterCuponsPorStatus', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            response.json().then((data) => {
                setIndicador3(data)
            })
        })

        fetch('http://localhost:8080/apointment/getQuantidadeServicosPorMes', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            response.json().then((data) => {
                setIndicador4(data)
            })
        })


    }, [])

    if(user?.email.indexOf('@bitbarberadmin') < 0 || !isLoggedIn){
        return;
    }

    return(<>
        <Navbar/>
        <div className="master-container">
            <h2>Quantidade Clientes Cadastrados / Meta: 50 por ano</h2>
            <BarChart
            series={[
                { data: indicador1 },
            ]}
            height={290}
            xAxis={[{ data: ['JAN', 'FEV', 'MAR', 'ABR', 'MAI', 'JUN', 'JUL', 'AGO', 'SET', 'OUT', 'NOV', 'DEZ', 'TOTAL'], scaleType: 'band' }]}
            margin={{ top: 10, bottom: 30, left: 40, right: 40 }}
            /> 
        </div>
        <div className="master-container">
            <h2>Conversão de feedback / Meta: 25%</h2>
            <PieChart
                series={[
                    {
                    data: [
                        { id: 0, value: indicador2?.possui_feedback, label: 'Feedbacks' },
                        { id: 1, value: indicador2?.nao_possui, label: 'Ausentes' },
                    ],
                    },
                ]}
                width={400}
                height={200}
            />
        </div>
        <div className="master-container">
            <h2>Uso de cupons / Meta: 30%</h2>
            <PieChart
                series={[
                    {
                    data: [
                        { id: 0, value: indicador3?.nao_usados_expirados, label: 'Invalidos' },
                        { id: 1, value: indicador3?.usados, label: 'Usados' },
                        { id: 2, value: indicador3?.nao_usados_validos, label: 'Pendentes' },
                    ],
                    },
                ]}
                width={400}
                height={200}
            />
        </div>
        <div className="master-container">
            <h2>Serviços agendados pelo site / meta: 300 por ano</h2>
            <BarChart
            series={[
                { data: indicador4 },
            ]}
            height={290}
            xAxis={[{ data: ['JAN', 'FEV', 'MAR', 'ABR', 'MAI', 'JUN', 'JUL', 'AGO', 'SET', 'OUT', 'NOV', 'DEZ', 'TOTAL'], scaleType: 'band' }]}
            margin={{ top: 10, bottom: 30, left: 40, right: 40 }}
            /> 
        </div>


    </>)
}

export default Indicadores;