import { createBrowserRouter } from 'react-router-dom';

import UsersList from '../UsersList';
import UserDetails from '../UserDetails';

export const router = createBrowserRouter([
  { path: '/', element: <UsersList /> },
  { path: '/user-details/:userName', element: <UserDetails /> },
]);
