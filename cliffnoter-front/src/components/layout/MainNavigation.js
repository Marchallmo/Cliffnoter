import { Link } from "react-router-dom";

import classes from "./MainNavigation.module.css";

function MainNavigation() {
  return (
    <header className={classes.header}>
      <div className={classes.logo}>Cliffnoter</div>
      <nav>
        <ul>
          <li>
            <Link to='/'>Text Space</Link>
          </li>
          <li>
            <Link to='/CreateAccount'>Create Account</Link>
          </li>
          <li>
            <Link to='/UserPage'>User Page</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
