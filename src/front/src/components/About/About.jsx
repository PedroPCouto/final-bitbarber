import Navbar from "../Navbar/navbar";
import './About.css';

const About = () => {
    return (
        <>
        <Navbar/>
        <div className="about-container">
            <h1>Sobre</h1>
            <div>Este é um projeto para a Matéria de Trabalho Interdisciplinar II</div>
            <div>Professores orientadores: Danilo Boechat Seufitelli e Cristiano de Macêdo Neto</div>
            <p>Desenvolvido por: </p>
                <p>Pedro Henrique de Paiva Couto <b>blink blink</b></p>
        </div>
        </>
    )
}

export default About;