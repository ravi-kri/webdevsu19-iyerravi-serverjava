(function () {

    const $elem = $('.container-fluid');
    const $createBtn = $('#createBtn');
    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const userRowTemplate = $('.userRowTemplate');
    const tbody = $('tbody');
    const $deleteBtn = $('.deleteBtn')
    const findAllUsersUrl = 'http://localhost:8080/users'
    const deleteUserUrl = 'http://localhost:8080/users/USER_ID'
    const userService = new UserService()

    $.ajax(findAllUsersUrl, {
        'success': handleUsers
    })

    function handleUsers(users) {
        $("tbody").empty()
        for(i in users) {
            appendUserToDom(users[i])
        }
    }

    $elem.append('<h1>Welcome to jQuery</h1>')

    $createBtn.click(createUser)
    $deleteBtn.click(deleteUser)
    
    function deleteUser(event) {
        deleteBtn = $(event.currentTarget)
        const id = deleteBtn.attr('id')
        console.log(id)
        const url = deleteUserUrl.replace('USER_ID', id)
        console.log(url)
        $.ajax(url, {
            'type': 'DELETE',
            'success': handleUsers
        })
        // const tr = currentTarget.parent().parent()
        // console.log(tr)
        // tr.remove()
    }

    function appendUserToDom(user) {
        const row = userRowTemplate.clone()
        row.removeClass('d-none')
        const usernameCol = row.find('.usernameCol')
        const passwordCol = row.find('.passwordCol')
        const firstNameCol = row.find('.firstNameCol')
        const deleteBtn = row.find('.deleteBtn')
        deleteBtn.click(deleteUser)
        deleteBtn.attr('id', user.id)

        usernameCol.html(user.username)
        passwordCol.html(user.password)
        firstNameCol.html(user.firstName)

        $usernameFld.val("")
        $passwordFld.val("")
        $firstNameFld.val("")

        tbody.append(row)
    }

    function createUser() {
        console.log('createUser')
        const username = $usernameFld.val()
        const password = $passwordFld.val()
        const firstName = $firstNameFld.val()
        console.log(username, password, firstName)

        const user = {
            username: username,
            password: password,
            firstName: firstName
        }

        userService
            .createUser(user)
            .then(handleUsers)

        // appendUserToDom(user)
    }
})()