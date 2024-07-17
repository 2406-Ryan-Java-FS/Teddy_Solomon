import './App.css';
import UserLogin from './components/user-login';
import UserSignup from './components/user-signup';
import UserLogout from './components/user-logout';
import UpdateUserBalance from './components/update-user-balance';
import UpdateUserInfo from './components/update-info';
import GetAllUsers from './components/get-all-users';
import GetUserById from './components/get-user-by-id';
import DeleteUserById from './components/delete-user';

function App() {
  return (<>
    <UserLogin /><br />
    <UserLogout /><br />
    <UserSignup /><br />
    <UpdateUserBalance /><br />
    <UpdateUserInfo />
    <GetAllUsers /><br/>
    <GetUserById /><br/>
    <DeleteUserById />
  </>);
}

export default App;
