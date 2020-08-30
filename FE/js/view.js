const view = {}

view.showComponents = function (name) {
    let app = document.getElementById('app')
    switch (name) {
        case 'main': {
            app.innerHTML = component.navBar + component.navSite + '<div class="container"><p>Not yet support</p></div>'

            break;
        }
        case 'home': {
            app.innerHTML = component.navBar + component.navSite + component.home + component.footer + component.modalUpdateEmployee
            view.showTBody()

            break;
        }
        case 'detailGroup': {
            app.innerHTML = component.navBar + component.navSite + component.detailGroup + component.footer + component.modalUpdateEmployee + component.modalUpdateNameGroup + component.modalAddEmployee
            view.showDetailHeader()
            view.showTableMember()

            break;
        }
    }
}

view.showTBody = function () {
    let tBody = document.getElementById('tBody')
    let Employees = model.group
    let s = ``
    Employees.forEach((employee, index) => {
        s += `
            <tr>
                <td><input type="checkbox" id="check-${employee.id}" style="cursor: pointer" aria-label="Checkbox for following text input" onclick="controller.checked(${employee.id})"></td>
                <td >${index + 1}</td>
                <td style="cursor: pointer" onclick="controller.toDetailGroup(${employee.id})">${employee.groupName}</td>
                <td>${employee.member.length}</td>
                <td>${employee.creator}</td>
                <td>${employee.createDate}</td>
            </tr>`
    });
    tBody.innerHTML = s
}

view.showModalAddGroup = function () {
    $('#modalAddGroup').modal('show');
}

view.showModalUpdateEmployee = function (id) {
    $('#modalUpdateEmployee').modal('show');
    let employeeSelected = model.group[id]
    let { name, department, phone } = employeeSelected

    document.getElementById('buttonUpdateEmployee').innerHTML = `
        <button type="button" class="btn btn-primary" onclick="controller.updateEmployee(${id})">Update</button>`

    document.getElementById('nameUpdateEmployee').value = name
    document.getElementById('departmentUpdateEmployee').value = department
    document.getElementById('phoneUpdateEmployee').value = phone
}

view.showAlertDel = function (id) {
    var result = confirm("Are you sure delete this employee!");
    if (result == true) {
        controller.delEmployee(id)
        view.showTBody()
    }
}

view.showAlertDelGroup = function () {
    var result = confirm("Are you sure delete this groups?");
    if (result == true) {
        controller.delGroup()
        view.showTBody()
    }
}

view.showDetailHeader = function () {
    console.log('group')
    let group = model.groupDetail
    let s = `
            <div class="title-header">
                <h2>${group.groupName}</h2>
                <i class="fas fa-pen fa-2x" onclick="view.showModalUpdateGroupname()" style="cursor: pointer"></i>
            </div>
            <ul >
                <li>Creator: ${group.creator}</li>
                <li>Create Date: ${group.createDate}</li>
                <li>Member: ${group.member.length}</li>
            </ul>`
    document.getElementById('detail-header').innerHTML = s
}

view.showTableMember = function () {
    let group = model.groupDetail
    let areaShow =  document.getElementById('tBody')
    let s = ``
    for (let i = 0; i < group.member.length; i++) {
        const element = group.member[i];
        s += `
        <tr>
            <td>${element.userName}</td>
            <td>${element.fullName}</td>
            <td>${element.email}</td>
            <td>${element.department}</td>
            <td>${element.joinDate}</td>
        </tr>`
    }
    areaShow.innerHTML = s
}

view.showModalUpdateGroupname = function () {
    $('#modalUpdateNameGroup').modal('show');
    document.getElementById('UpdateNewNameGroup').value = model.groupDetail.groupName
}

view.showModalAddEmployee = function () {
    $('#modalAddEmployee').modal('show');
}