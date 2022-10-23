import React, { useCallback, useEffect, useState } from 'react';
import { getUsers } from './services/UserService';
import { Chip, Divider } from '@mui/material';
import { Link } from 'react-router-dom';

const UsersList = () => {
  const fetchUsers = useCallback(async () => {
    return await getUsers();
  }, []);

  const [users, setUsers] = useState<any[]>([]);

  useEffect(() => {
    fetchUsers().then((r) => setUsers(r));
  }, [fetchUsers]);

  return (
    <>
      <Divider>
        <Chip label="Users List" />
      </Divider>

      <br />
      {users.map((user, index) => (
        <Link key={index} to={`user-details/${user.name}`}>
          {user.name} is {user.role} <br />
        </Link>
      ))}
    </>
  );
};

export default UsersList;
