import { useState } from "react";
import { loginUser } from "./User";

const UserLogin = () => {
  const [data, setData] = useState({});
  const onHandleChangeData = (e) => {
    setData(prevData => ({ ...prevData, [e.target.name]: e.target.value }));
  };
  const onSubmitHandle = () => {
    loginUser(data).then(() => alert("로그인 완료"));
  };

  return (
    <>
      <div>로그인</div>
      <div>아이디 / 비밀번호</div>
      <input type="text" name="id" placeholder="ID" onChange={(e) => onHandleChangeData(e)} />
      <input type="text" name="pw" placeholder="PW" onChange={(e) => onHandleChangeData(e)} />
      <button onClick={() => {onSubmitHandle();}}>
        로그인
      </button>
      <div>===============================================================================</div>
    </>
  );
};
export default UserLogin;
