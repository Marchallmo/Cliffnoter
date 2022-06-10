import { Route, Routes } from "react-router-dom";
import TextSpace from "./pages/TextSpace";
import CreateAccount from "./pages/CreateAccount";
import UserPage from "./pages/UserPage";
import MainNavigation from "./components/layout/MainNavigation";

function App() {
  return (
    <div>
      <div>
        <MainNavigation />
        <Routes>
          <Route path='/' element={<TextSpace />}></Route>
          <Route path='/UserPage' element={<UserPage />}></Route>
          <Route path='/CreateAccount' element={<CreateAccount />}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
