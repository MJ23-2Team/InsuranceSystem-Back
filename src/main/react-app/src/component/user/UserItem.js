const UserItem = ({ customerID, address,age,sex,job,name,phoneNumber,registrationNumber,incomeLevel,accountNumber,accountPassword}) => {
  return (
    <div>
      <div>===============================================================================</div>
      <div>customerID : {customerID}</div>
      <div>address : {address}</div>
      <div>age : {age}</div>
      <div>sex : {sex}</div>
      <div>job : {job}</div>
      <div>name : {name}</div>
      <div>phoneNumber : {phoneNumber}</div>
      <div>registrationNumber : {registrationNumber}</div>
      <div>incomeLevel : {incomeLevel}</div>
      <div>accountNumber : {accountNumber}</div>
      <div>accountPassword : {accountPassword}</div>
    </div>
  );
};
export default UserItem;
