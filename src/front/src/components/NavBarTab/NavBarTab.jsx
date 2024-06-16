import { useNavigate } from "react-router-dom";


const NavbarTab = ({ title, path, classes, visible }) => {
    let navigate = useNavigate();
    const goPath = () => {
        navigate(path);
    }

    if(!visible)
        return null;


    return (
        <span className={classes} onClick={goPath}>
            {title}
        </span>
    );
}

export default NavbarTab;