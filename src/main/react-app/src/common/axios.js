import axios from "axios";
const request = axios.create({ baseURL: "http://localhost:8080/" });
// const request = axios.create({ baseURL: "http://3.35.203.41:8080/" });

export default request;
