import createView from "../createView.js";

export default function Register(props){
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<form id="register-form">
    <label for="email">Email</label>
    <input id="email" name="email" type="email"/>
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <input id="register-btn" type="submit" value="Register"/>
</form>
</body>
</html>`;


    export function RegisterEvent(){

        $("#register-btn").click(function(){
            let newUser = {
                email: $('#email').val(),
                username: $('#username').val(),
                password: $('#password').val(),
            }
            let request = {
                method: "POST",
                header: {"Content-Type": "application/json"},
                body: JSON.stringify(newUser)
            };
            fetch("http://localhost:8080/api/users", request)
                .then((response) => {
                    console.log(response.status)
                    createView("/");
                });
        })
    }
}