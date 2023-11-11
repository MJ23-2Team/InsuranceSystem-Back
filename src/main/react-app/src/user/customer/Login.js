import { useState } from "react";
import { loginUser } from "./Customer";

const Login = () => {
  const [data, setData] = useState({});
  const onHandleChangeData = (e) => {
        setData(prevData => ({ ...prevData, [e.target.name]: e.target.value }));
  };
  const onSubmitHandle = () => {
      if (data.id && data.pw) {
          loginUser(data).then((res) =>
              alert(res.data.message));
      }else{
          alert("값을 입력해주세요");
      }
  };

  return (
    <>
      <div>로그인</div>
      <div>아이디 / 비밀번호</div>
      <input type="text" name="id" placeholder="ID" onChange={(e) => onHandleChangeData(e)} />
      <input type="password" name="pw" placeholder="PW" onChange={(e) => onHandleChangeData(e)} />
      <button onClick={() => {onSubmitHandle();}}>
        로그인
      </button>
      <div>===============================================================================</div>
    </>
  );
};
export default Login;
