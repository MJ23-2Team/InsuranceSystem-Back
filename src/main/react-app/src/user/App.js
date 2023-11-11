    import GetAllCustomer from "./customer/GetAllCustomer";
    import Register from "./customer/Register";
    import UserLogin from "./customer/Login";
    const App = () => {
      return (
        <div>
          <UserLogin/>
          <Register/>
          <GetAllCustomer/>
        </div>
      );
    };
    export default App;
