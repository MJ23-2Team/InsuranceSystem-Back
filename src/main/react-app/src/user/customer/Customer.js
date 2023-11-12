import request from "../../common/axios";

export const loginUser = async (data) => {
  return await request.post(`login`, data);
};
export const createUser = async (data) => {
  return await request.post(`register`, data);
};
export const getAllUsers = async () => {
  return await request.get(`customer/getAll`);
};
export const getUser = async (data) => {
  return await request.get(`customer`, data);
};
