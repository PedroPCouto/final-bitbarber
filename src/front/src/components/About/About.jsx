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
        </div>
        </>
    )
}

export default About;