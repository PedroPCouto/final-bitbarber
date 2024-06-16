import NavbarTab from '../NavBarTab/NavBarTab';
import './navbar.css';
import { AuthContext } from '../../AuthProvider/AuthProvider';
import { useContext } from 'react'; 

const Navbar = () => {
    const {isLoggedIn, user, logout} = useContext(AuthContext);

    return(
    <nav className='navigator-container'>
        <ul>
            <NavbarTab title='Home' path='/' classes='navbar-list-item' visible={true}/>
            <NavbarTab title='Sobre' path='/about' classes='navbar-list-item' visible={true}/>
            <NavbarTab title='Contratar Serviço' path='/contract' classes='navbar-list-item' visible={isLoggedIn && user?.email.indexOf('@bitbarberadmin') < 0}/>
            <NavbarTab title='Criar Cupons' path='/cupom' classes='navbar-list-item' visible={isLoggedIn && user?.email.indexOf('@bitbarberadmin') >= 0 }/>
            <NavbarTab title='Indicadores' path='/indicadores' classes='navbar-list-item' visible={isLoggedIn && user?.email.indexOf('@bitbarberadmin') >= 0}/>
        </ul>
        <span>
            <NavbarTab title='Login' path='/login' classes='navbar-list-item login-button' visible={!isLoggedIn}/>
            <NavbarTab title='Register' path='/register' classes='navbar-list-item login-button' visible={!isLoggedIn}/>     
            {isLoggedIn && <span className='navbar-list-item login-button' onClick={logout}>
                sair
            </span>}     
        </span>
    </nav>
    );
}

export default Navbar;  