import {useEffect, useState} from "react";
import {getAllUsers} from "./Customer";

const GetAllCustomer = () => {
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
            <div>고객 정보 불러오기</div>
            {users?.map((user, index) => {
                return (
                    <div key={index}>
                        <div>===============================================================================</div>
                        {user.data && Object.entries(user.data).map(([key, value]) => (
                            <div key={key}>{`${key} : ${value}`}</div>
                        ))}
                    </div>
                );
            })}
        </div>
  );
};
export default GetAllCustomer;
