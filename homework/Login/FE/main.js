const userNameEl = document.getElementById("username");
const passwordEl = document.getElementById("password");
const inputEles = document.querySelectorAll('.input-row');

const btnLogin = document.getElementById("btn-login");
const btnLogOut = document.getElementById("btn-logOut");
const infoEl = document.querySelector("#info")



const getUser = async () => {
    try {
        let res = await axios.post("http://localhost:8080/login",{
            "userName" : userNameEl.value,
            "password" : passwordEl.value,
        })
        // console.log(res.data)
        // console.log(res.data.message)
        if(res.data.httpStatus=='BAD_REQUEST'){
            window.alert("Incorrect username or password!");
        }else{
            showInfo(res.data)
            btnLogOut.style.zIndex = 3;
            infoEl.style.zIndex = 3;

        }
        
    } catch (error) {
        console.log(error)
    }
}


function setSuccess(ele) {
    ele.parentNode.classList.add('success');
}
function setError(ele, message) {
    let parentEle = ele.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}


function checkValidate() {
    let isCheck = true;
    if (userNameEl.value == ''){
        setError(userNameEl, 'Tên không được để trống');
        isCheck =false;
    }else{
        setSuccess(userNameEl);
    }

    if (passwordEl.value == '') {
        setError(passwordEl, 'Password không được để trống');
        isCheck = false;
    } else {
        setSuccess(passwordEl);
    }
    return isCheck;
}



// const userFormEl = document.querySelector('.user-form')
// const renderUser = arr => {
//    userFormEl.innerHTML = "";
// }
function showInfo(user){
    let html = "";
    let title = `<h1>Hello ${user.userName}</h1>`;
    let email = `<p>Email: ${user.email}</p>`;
    let avatar = `<img src="../image/${user.avatar}.png" alt="${user.userName}" width="150">`
    html = title + email + avatar;

    infoEl.innerHTML = html;
}




btnLogin.addEventListener("click", () =>{
    Array.from(inputEles).map((ele) =>
        ele.classList.remove('success', 'error')
    );
    let isValid = checkValidate();
    
    if (isValid) {
        getUser();
    }
    
    
});
btnLogOut.addEventListener("click", () =>{
    btnLogOut.style.zIndex = 1;
    infoEl.style.zIndex = 1;
    userNameEl.value ="";
    passwordEl.value ="";
})
