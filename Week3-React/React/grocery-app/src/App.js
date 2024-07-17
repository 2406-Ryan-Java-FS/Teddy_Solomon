import './App.css';
import BudgetManager from './components/budget-manager';
import GroceryForm from './components/grocery-form';
import GroceryList from './components/grocery-list';
import { Routes, Route } from 'react-router-dom';
import HomeComponent from './components/home';
import NavBar from './components/navbar';

function App() {

  return (<>
    <NavBar />
    
    <Routes>
      <Route path='' element = {<HomeComponent />} />
      <Route path='budget' element={<BudgetManager />} />
      <Route path='groceries' element={<>
        <GroceryList />
        <GroceryForm />
      </>} />

    </Routes>

  </>)

}

export default App;
