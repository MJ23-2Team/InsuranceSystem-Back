import request from "../../common/axios";

export const loginUser = (data) => {
  return request.post(`login`, data);
};
export const createUser = (data) => {
  return request.post(`register`, data);
};
export const getAllUsers = async () => {
  return request.get(`customer/getAll`);
};
export const getUser = (data) => {
  return request.get(`customer`, data);
};
