
function UserService() {

    this.deleteUserUrl = 'http://localhost:8080/users/USER_ID'
    this.findAllUsersUrl = 'http://localhost:8080/users'
    this.createUser = function (user) {
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

    this.findAllUsers = function (handleUsers) {
        $.ajax(this.findAllUsersUrl, {
            'success': handleUsers
        })
    }

    this.deleteUser = function() {
        $.ajax(this.url, {
            'type': 'DELETE',
            'success': handleUsers
        })
    }
}