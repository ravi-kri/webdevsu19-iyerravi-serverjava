
function UserService() {

    this.deleteUserUrl = '/users/USER_ID'
    this.findAllUsersUrl = '/users'
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById
    this.deleteUser = deleteUser;
    this.createUser = createUser;
    this.updateUser = updateUser;

    async function createUser(user) {
        user.id = (new Date()).getTime()
        console.log(user)
        const response = await fetch("/users", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
        return response.json();
    }

    async function findUserById(userID){
        const response = await fetch("/users", {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        });
        return response.json();
    }

    async function updateUser(userID,user){
        const response = await fetch("/users", {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        });
        return response.json();
    }

   
    function deleteUser(deleteUserUrl){
        $.ajax(deleteUserUrl, {
            'type': 'DELETE'
        })
    }

    async function findAllUsers(){
        const response = await fetch(this.findAllUsersUrl);
        return response.json();
    }
   
}