(function () {

    const $elem = $('.container-fluid');
    const $createBtn = $('#createBtn');
    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const $roleFld = $('#roleFld')
    const userRowTemplate = $('.userRowTemplate');
    const tbody = $('tbody');
    const $deleteBtn = $('.deleteBtn');
    const $editBtn = $('.editBtn');
    const findAllUsersUrl = '/users'
    const deleteUserUrl = '/users/USER_ID'
    const userService = new UserService()
    
    function findAllUsers(){
        userService.findAllUsers().then(renderUsers)
    }
   
    findAllUsers()

    function renderUsers(users) {
        $("tbody").empty()
        for(i in users) {
            renderUser(users[i])
        }
    }


    $createBtn.click(createUser)
    $deleteBtn.click(deleteUser)

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget)
        const id = deleteBtn.attr('id')
        console.log(id)
        const url = deleteUserUrl.replace('USER_ID', id)
        
        userService.deleteUser(url)
        // $.ajax(url, {
        //     'type': 'DELETE'
        // })
        location.reload()
    }

    function renderUser(user) {
        const row = userRowTemplate.clone()
        row.removeClass('d-none')
        const usernameCol = row.find('.usernameCol')
        const passwordCol = row.find('.passwordCol')
        const firstNameCol = row.find('.firstNameCol')
        const lastNameCol = row.find('.lastNameCol')
        const roleCol = row.find('.roleCol')
        const deleteBtn = row.find('.deleteBtn')
        deleteBtn.click(deleteUser)
        deleteBtn.attr('id', user.id)

        usernameCol.html(user.username)
        passwordCol.html(user.password)
        firstNameCol.html(user.firstName)
        lastNameCol.html(user.lastName)
        roleCol.html(user.role)

        $usernameFld.val("")
        $passwordFld.val("")
        $firstNameFld.val("")
        $lastNameFld.val("")
        $roleFld.val("")

        tbody.append(row)
    }

    function createUser() {
        console.log('createUser')
        const username = $usernameFld.val()
        const password = $passwordFld.val()
        const firstName = $firstNameFld.val()
        const lastName = $lastNameFld.val()
        const role = $roleFld.val()
        console.log(username, password, firstName)

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName:lastName,
            role:role
        }

        userService
            .createUser(user)
            .then(renderUsers)
    }
    
})()