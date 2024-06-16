import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Paper,
    Checkbox
} from '@mui/material';


const UserTable = ({userData, selectedUsers, setSelectedUsers}) => {

    const handleSelectUser = (email) => {
        const newSelectedUsers = selectedUsers.includes(email)
            ? selectedUsers.filter(user => user !== email)
            : [...selectedUsers, email];
        setSelectedUsers(newSelectedUsers);
    };

    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell></TableCell>
                        <TableCell>Email</TableCell>
                        <TableCell>Nome</TableCell>
                        <TableCell>Data de Aniversário</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {userData.map((user) => (
                        <TableRow key={user.email}>
                            <TableCell padding="checkbox">
                                <Checkbox
                                    checked={selectedUsers.includes(user.email)}
                                    onChange={() => handleSelectUser(user.email)}
                                />
                            </TableCell>
                            <TableCell>{user.email}</TableCell>
                            <TableCell>{user.nome}</TableCell>
                            <TableCell>{user.dataAniversario}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
        
    );
};

export default UserTable;
