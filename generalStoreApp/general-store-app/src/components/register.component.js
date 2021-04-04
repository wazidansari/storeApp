import React, {useState} from 'react';

const RegisterForm = () => {

    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    return(
       <React.Fragment>
          <h2>New User</h2>
          <h4>Create Account</h4>
          <br />
          <form novalidate>
            <div className="form-group">
               <label htmlFor="firstname">First Name</label>
               <input novalidate id="firstname"
                   type="text"
                   name="firstname"
                   placeholder="First Name"
                   value={firstname}
                   onChange={(e)=>setFirstName(e.target.value)}
                   className="form-control" />
            </div>
            <div className="form-group">
               <label htmlFor="lastname">Last Name</label>
               <input novalidate id="lastname"
                   type="text"
                   name="lastname"
                   placeholder="Last Name"
                   value={lastname}
                   onChange={(e)=>setLastName(e.target.value)}
                   className="form-control" />
            </div>
            <div className="form-group">
             <label htmlFor="email">Email Address</label>
             <input novalidate id="email"
                 type="email"
                 name="email"
                 placeholder="Email"
                 value={email}
                 onChange={(e)=>setEmail(e.target.value)}
                 className="form-control" />
            </div>
          <div className="form-group">
             <label htmlFor="password">Password</label>
             <input novalidate id="password"
                 type="password"
                 name="password"
                 placeholder="Password"
                 value={password}
                 onChange={(e)=>setPassword(e.target.value)}
                 className="form-control" />
          </div>
            <button type="submit" className="btn btn-primary mr-2">
               Register | <i className="fas fa-user-plus"></i>
            </button>
             <button className="btn btn-outline-secondary">
                Cancel | <i className="fas fa-times"></i>
             </button>
          </form>
       </React.Fragment>
    );
};

export default RegisterForm;