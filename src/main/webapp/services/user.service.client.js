
function UserService() {

    this.deleteUserUrl = 'http://localhost:8080/users/USER_ID'
    this.findAllUsersUrl = 'http://localhost:8080/users'
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById
    this.deleteUser = deleteUser;
    this.createUser = createUser;
    this.updateUser = updateUser;

    function createUser(user) {
        user.id = (new Date()).getTime()
        console.log(user)
        return fetch("http://localhost:8080/users", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json()
        })
    }

    function findUserById(){
        return fetch("http://localhost:8080/users/USER_ID", {
            method: 'GET',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json()
        })
    }

    function updateUser(userID,user){
        return fetch("http://localhost:8080/users/"+userID, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
           
            return response.json()
        })
    }

   
    function deleteUser(deleteUserUrl){
        $.ajax(deleteUserUrl, {
            'type': 'DELETE'
        })
    }

    function findAllUsers(){
        return fetch(this.findAllUsersUrl)
        .then(function(response) {
            return response.json();
        });
    }
   
}