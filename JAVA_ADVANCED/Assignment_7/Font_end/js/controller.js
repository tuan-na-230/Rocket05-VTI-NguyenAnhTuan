const controller = {}

controller.addNewEmployee = function () {
    let userName = document.getElementById('nameNewEmployee').value;
    let department = document.getElementById('departmentNewEmployee').value
    let email = document.getElementById('EmailNewEmployee').value;
    let fullName = document.getElementById('fullNameNewEmployee').value;
    let joinDate = document.getElementById('joinDateNewEmployee').value;

    let listGroup = model.group
    let groupSelected = model.groupDetail;
    for (let i = 0; i < listGroup.length; i++) {
        let element = listGroup[i]
        if (element.id = groupSelected.id) {
            element.member.push({ userName, department, email, fullName, joinDate })
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

controller.addNewGroup = async function () {
    let data = {
        name: document.getElementById('newGroupName').value
    }
    console.log(JSON.stringify(data))

    // model.group.push(data)
    // console.log(model.group)
    await fetch('http://localhost:8080/departments', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify(data)
    })
        .then(err => {
            console.log(err)
        });
    await fetch('http://localhost:8080/departments')
        .then(response => response.json())
        .then(data => {
            model.group = data
        });
    $('#modalAddGroup').modal('hide');
    window.alert("Add group success!")
    view.showTBody()
}

controller.delGroup = async function () {
    let listGroupNeedDel = model.groupSelected;
    console.log(listGroupNeedDel)
    for (let j = 0; j < listGroupNeedDel.length; j++) {
        let data = { id: listGroupNeedDel[j] }
        await fetch('http://localhost:8080/departments', {
            method: 'DELETE',
            mode: 'cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json;charset=UTF-8'
            },
            body: JSON.stringify(data)
        })
    }

    await fetch('http://localhost:8080/departments')
        .then(response => response.json())
        .then(data => {
            model.group = data
        });
    view.showTBody()
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
    for (let i = 0; i < model.group.length; i++) {
        if (model.group[i].id == idGroup) {
            model.groupDetail = model.group[i];
        }
    }
    console.log(model.groupDetail)
    view.showComponents('detailGroup')
}

controller.UpdateNewNameGroup = async function () {
    let newNameGroup = document.getElementById('UpdateNewNameGroup').value;
    let groupNeedUpdate = model.groupDetail
    let data = { id: groupNeedUpdate.id, name: newNameGroup }
    // await fetch('http://localhost:8080/departments', {
    //     method: 'PUT',
    //     mode: 'cors',
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'application/json;charset=UTF-8'
    //     },
    //     body: JSON.stringify(data)
    // })
    //     .then(res => res.json())
    //     .then(
    //         await fetch('http://localhost:8080/departments')
    //             .then(res => res.json())
    //             .then(data => {
    //                 model.group = data
    //                 for (let i = 0; i < model.group.length; i++) {
    //                     if (model.groupDetail.id == model.group[i].id) {
    //                         model.groupDetail = model.group[i]
    //                     }
    //                 }
    //                 console.log(model.groupDetail)
    //                 $('#modalUpdateNameGroup').modal('hide');
    //                 view.showDetailHeader();
    //             })
    //             .catch(err => {
    //                 console.log(err)
    //             })
    //     )
    //     .catch(err => {
    //         console.log(err)
    //     })
    await axios({
        method: 'put',
        url: 'http://localhost:8080/departments',
        data: data
    })
        .then(
            axios({
                method: 'get',
                url: 'http://localhost:8080/departments',
            })
                .then(res => {
                    console.log(res.data)
                    model.group = res.data
                    for (let i = 0; i < model.group.length; i++) {
                        if (model.groupDetail.id == model.group[i].id) {
                            model.groupDetail = model.group[i]
                        }
                    }
                    console.log(model.groupDetail)
                    $('#modalUpdateNameGroup').modal('hide')
                    view.showDetailHeader()
                })
                .catch(err => console.log(err))
        )
        .catch(err => {
            console.log(err)
        })
}