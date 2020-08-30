const controller = {}

controller.addNewEmployee = function () {
    let userName = document.getElementById('nameNewEmployee').value;
    let department = document.getElementById('departmentNewEmployee').value
    let email = document.getElementById('EmailNewEmployee').value;
    let fullName = document.getElementById('fullNameNewEmployee').value;
    let joinDate = document.getElementById('joinDateNewEmployee').value;

    let listGroup = model.group
    let groupSelected = model.groupDetail;
    for(let i = 0; i < listGroup.length; i++) {
        let element = listGroup[i]
        if(element.id = groupSelected.id) {
            element.member.push({userName, department, email, fullName, joinDate})
        }
    }
    model.group = listGroup
    $('#modalAddEmployee').modal('toggle');
    window.alert("Add member success!")
    view.showDetailHeader()
    view.showTableMember()
}

controller.updateEmployee = function (id) {
    let data = {
        name: document.getElementById('nameUpdateEmployee').value,
        department: document.getElementById('departmentUpdateEmployee').value,
        phone: document.getElementById('phoneUpdateEmployee').value,
    }

    model.Employees[id] = data
    document.getElementById('nameUpdateEmployee').value = ''
    document.getElementById('departmentUpdateEmployee').value = ''
    document.getElementById('phoneUpdateEmployee').value = ''
    $('#modalUpdateEmployee').modal('hide')
    window.alert("Update success!")
    view.showTBody()
}

controller.delEmployee = function (id) {
    model.Employees.splice(id, 1)
}

controller.addNewGroup = function () {
    let data = {
        groupName: document.getElementById('newGroupName').value,
        creator: model.creator,
        createDate: new Date().toLocaleDateString(),
        member: []
    }

    model.group.push(data)
    console.log(model.group)
    $('#modalAddGroup').modal('hide');
    window.alert("Add group success!")
    view.showTBody()
}

controller.delGroup = function (idGroup) {
    let listGroupNeedDel = model.groupSelected;
    for (let i = 0; i < model.group.length; i++) {
        for (let j = 0; j < listGroupNeedDel.length; j++) {
            if (model.group[i].id == listGroupNeedDel[j])
                model.group.splice(i, 1)
        }
    }
    console.log('vao')
    console.log(model.group)
}

controller.checked = function (id) {
    let check = document.getElementById(`check-${id}`)
    if (check.checked == true) {
        model.groupSelected.push(id)
    } else {
        for (let i = 0; i < model.groupSelected.length; i++) {
            if (model.groupSelected[i] == id)
                model.groupSelected.splice(i, 1)
        }
    }
}

controller.toDetailGroup = function (idGroup) {
    for(let i = 0; i < model.group.length; i++) {
        if(model.group[i].id == idGroup) {
            model.groupDetail = model.group[i];
        }
    }
    console.log(model.groupDetail)
    view.showComponents('detailGroup')
}

controller.UpdateNewNameGroup = function () {
    let newNameGroup = document.getElementById('UpdateNewNameGroup').value;
    console.log(newNameGroup)
    let groupNeedUpdate = model.groupDetail
    let listGroup = model.group
    for (let i = 0; i < listGroup.length; i++) {
        const element = listGroup[i];
        if(element.id = groupNeedUpdate.id) {
            element.groupName = newNameGroup
        }
    }
    model.group = listGroup
    view.showDetailHeader();
    $('#modalUpdateNameGroup').modal('hide');

}