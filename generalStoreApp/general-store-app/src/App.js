import React from 'react';
import { Switch, Route, Redirect} from 'react-router-dom';
import AuthPage from './pages/authpage.component';
import StorePage from './pages/storepage.component';
import EditStorePage from './pages/editstorepage.component';
import Header from './components/header.component';

const App = () => {
  return(
  <React.Fragment>
     <Header />
     <div className="container my-5">
       <Switch>
        <Route exact path='/auth' component={AuthPage} />
        <Route exact path='/store' component={StorePage} />
        <Route exact path='/edit-store' component={EditStorePage} />
        <Route exact path='/edit-store/:storeId' component={AuthPage} />
        <Redirect to='/auth' />
       </Switch>
     </div>
    </React.Fragment>
  );
};

export default App;

