import React, {useEffect, useState} from "react";
import {getAllUsers} from "./Customer";

const GetAllCustomer = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getAllUsers().then( (res) => {setUsers(res.data.data);});
    }, []);

    return (
        <div>
            <div>고객 정보 불러오기</div>
            {console.log(users)}
            {console.log(users[0])}
            {users && users.map((user, index) => {
                return (
                    <div key={index}>
                        <div>===============================================================================</div>
                        {user && Object.entries(user).map(([key, value]) => (
                            <div key={key}>{`${key} : ${value}`}</div>
                        ))}
                    </div>
                );
            })}
        </div>
  );
};
export default GetAllCustomer;
