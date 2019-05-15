(function main() {
        const $elem = $('.container-fluid');
        const $createBtn = $('#createBtn');
        const $updateBtn = $("#updateBtn");
        const $usernameFld = $('#usernameFld');
        const $passwordFld = $('#passwordFld');
        const $firstNameFld = $('#firstNameFld');
        const $lastNameFld = $('#lastNameFld');
        const $roleFld = $('#roleFld')
        const userRowTemplate = $('.wbdv-userRowTemplate');
        const tbody = $('tbody');
        const $deleteBtn = $('.wbdv-deleteBtn');
        const $editBtn = $('.wbdv-editBtn')
        const findAllUsersUrl = '/users'
        const deleteUserUrl = '/users/USER_ID'
        const userService = new UserService()
        findAllUsers()
        $createBtn.click(createUser)
        $deleteBtn.click(deleteUser)
        $editBtn.click(selectUser)
        $updateBtn.click(updateUser);
    
    function renderUsers(users) {
        $("tbody").empty()
        for(i in users) {
            renderUser(users[i])
        }
    }

    function findAllUsers(){
        userService.findAllUsers().then(renderUsers)
    }

    function updateUser(event) {
                $row.find(".wbdv-usernameCol").html($usernameFld.val());
                $row.find(".wbdv-passwordCol").html($passwordFld.val());
                $row.find(".wbdv-firstNameCol").html($firstNameFld.val());
                $row.find(".wbdv-lastNameCol").html($lastNameFld.val());
                $row.find(".wbdv-roleCol").html($roleFld.val());
                $row = null
                $usernameFld.val("")
                $passwordFld.val("")
                $firstNameFld.val("")
                $lastNameFld.val("")
                $roleFld.val("")
            }
        
    
    function findUserById(userID){
        userService.findUserById(userID);
    }
    
    function renderUser(user) {
        const row = userRowTemplate.clone()
        row.removeClass('d-none')
        const usernameCol = row.find('.wbdv-usernameCol')
        const passwordCol = row.find('.wbdv-passwordCol')
        const firstNameCol = row.find('.wbdv-firstNameCol')
        const lastNameCol = row.find('.wbdv-lastNameCol')
        const roleCol = row.find('.wbdv-roleCol')
        const deleteBtn = row.find('.wbdv-deleteBtn')
        const editBtn = row.find('.wbdv-editBtn')
        deleteBtn.click(deleteUser)
        deleteBtn.attr('id', user.id)
        editBtn.click(selectUser)
        editBtn.attr('id', user.id)

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
    
    function selectUser(event) {
        const row = $(event.currentTarget).parents(".wbdv-userRowTemplate");
        $row = row
        $usernameFld.val(row.find(".wbdv-usernameCol").html());
        $passwordFld.val(row.find(".wbdv-passwordCol").html());
        $firstNameFld.val(row.find(".wbdv-firstNameCol").html());
        $lastNameFld.val(row.find(".wbdv-lastNameCol").html());
        $roleFld.val(row.find(".wbdv-roleCol").html());
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

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget)
        const id = deleteBtn.attr('id')
        console.log("id")
        const url = deleteUserUrl.replace('USER_ID', id)
        
        userService.deleteUser(url)
        // $.ajax(url, {
        //     'type': 'DELETE'
        // })
        location.reload()
    }
})()