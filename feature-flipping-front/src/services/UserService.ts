import AxiosInstance from './AxiosInstance';

export const getUsers = (): Promise<any> => AxiosInstance.get('/users');

export const getUserFeature = (userName: string): Promise<any> =>
  AxiosInstance.get(`/users/features/${userName}`);

export const getFeatures = (): Promise<any> => AxiosInstance.get('/features');
