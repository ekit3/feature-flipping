import axios from 'axios';

const AxiosInstance = axios.create({ baseURL: 'http://localhost:3000/api' });

AxiosInstance.interceptors.response.use(function (response) {
  // Any status code that lie within the range of 2xx cause this function to trigger
  // Do something with response data
  return response.data;
});

export default AxiosInstance;
