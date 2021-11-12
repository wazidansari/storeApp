import React, {useState} from 'react';
import {connect} from 'react-redux';
import {registerUser} from './../redux/actions/authActionCreators'
const RegisterForm = ({dispatchRegisterAction}) => {

    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleOnSubmit = (event) => {
         alert("You account got successfully registered");
         event.preventDefault();
         dispatchRegisterAction(firstname,lastname,email,password,
         ()=> console.log("Account created successfully"),
         (message)=> console.log("Error: ",message)
         )
    };

    return(
       <React.Fragment>
          <h2>New User</h2>
          <h4>Create Account</h4>
          <br />
          <form noValidate onSubmit={handleOnSubmit}>
            <div className="form-group">
               <label htmlFor="firstname">First Name</label>
               <input noValidate id="firstname"
                   type="text"
                   name="firstname"
                   placeholder="First Name"
                   value={firstname}
                   onChange={(e)=>setFirstName(e.target.value)}
                   className="form-control" />
            </div>
            <div className="form-group">
               <label htmlFor="lastname">Last Name</label>
               <input noValidate id="lastname"
                   type="text"
                   name="lastname"
                   placeholder="Last Name"
                   value={lastname}
                   onChange={(e)=>setLastName(e.target.value)}
                   className="form-control" />
            </div>
            <div className="form-group">
             <label htmlFor="email1">Email Address</label>
             <input noValidate id="email1"
                 type="email"
                 name="email"
                 placeholder="Email"
                 value={email}
                 onChange={(e)=>setEmail(e.target.value)}
                 className="form-control" />
            </div>
          <div className="form-group">
             <label htmlFor="password1">Password</label>
             <input noValidate id="password1"
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

const mapDispatchToProps = dispatch => ({
    dispatchRegisterAction: (firstname, lastname, email, password, onSuccess, onError) =>
    dispatch(registerUser({firstname,lastname,email,password}, onSuccess, onError))
})
export default connect(null, mapDispatchToProps)(RegisterForm);