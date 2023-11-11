import { useState, useEffect} from "react";
import { createUser } from "./Customer";

  const Register = () => {
  const [data, setData] = useState({});
  const [info, setinfo] = useState({});

  const onHandleChangeinfo = (e) => {
          setinfo(prevInfo => ({...prevInfo, [e.target.name]: e.target.value}));
  };
  
  const onHandleChangeData = (e) => {
         setData(prevData => ({ ...prevData, [e.target.name]: e.target.value }));
  };
  const onSubmitHandle = () => {
      if (data.id && data.pw) {
          createUser(data).then((res) => alert(res.data.message));
      }else{
          alert("값을 입력해주세요");
      }

  };
  useEffect(() => {
    setData(prevData => ({ ...prevData, id: prevData.id,pw: prevData.pw, customerDto: info }));
  }, [info]);

  return (
    <><div>회원가입</div>
      <div>아이디 / 비밀번호</div>
      <input type="text" name="id" placeholder="ID" onChange={(e) => onHandleChangeData(e)} />
      <input type="password" name="pw" placeholder="PW" onChange={(e) => onHandleChangeData(e)} />
      <div>고객 정보 등록</div>
      <input type="text" name="address" placeholder="address" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="age" placeholder="age" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="sex" placeholder="sex" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="job" placeholder="job" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="name" placeholder="name" onChange={(e) => onHandleChangeinfo(e)} />
      <div></div>
      <input type="text" name="phoneNumber" placeholder="phoneNumber" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="registrationNumber" placeholder="registrationNumber" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="incomeLevel" placeholder="incomeLevel" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="accountNumber" placeholder="accountNumber" onChange={(e) => onHandleChangeinfo(e)} />
      <input type="text" name="accountPassword" placeholder="accountPassword" onChange={(e) => onHandleChangeinfo(e)} />
      <button onClick={() => {onSubmitHandle();}}>
        등록하기
      </button>
      <div>===============================================================================</div>
    </>
  );
};
export default Register;
