import { useEffect, useState } from "react";
import { getAllUsers } from "./user/User";
import UserItem from "./user/UserItem";
import UserForm from "./user/UserForm";
import UserLogin from "./user/UserLogin";
const App = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getUser();
  }, []);

  const getUser = () => {
    getAllUsers().then((res) => {
      const prevData = res.data;
      setUsers(prevData);
    });
  };
  
  return (
    <div>
      <UserLogin/>
      <UserForm/>
      <div>모든 고객 정보 확인</div>
      {users?.map((user) => {
        return (
          <UserItem
          customerID={user.customerID}
          address={user.address}
          age={user.age}
          sex ={user.sex}
          job={user.job}
          name={user.name}
          phoneNumber={user.phoneNumber}
          registrationNumber={user.registrationNumber}
          incomeLevel={user.incomeLevel}
          accountNumber={user.accountNumber}
          accountPassword={user.accountPassword}
          />
        );
      })}
    </div>
  );
};

export default App;
