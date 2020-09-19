const component = {}

component.navBar = `
    <nav class="navbar navbar-expand-lg navbar-light bg-light">     
        <a class="navbar-brand" href="#">
            <img src="https://cdn.itviec.com/employers/vti/logo/social/38t2mwUDZtYnwwJBU4W8iToP/vti-logo.png" width="30" height="30" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">View List Employees</a>
                </li>
            </ul>
        </div>
    </nav>`

component.navSite = `
    <div class="navSite">
        <ul style="list-style-type: none; padding: 5px; text-align: center;">
            <li style="cursor: pointer">
                <i class="fas fa-home fa-2x" onclick = "view.showComponents('main')"></i>
            </li>
            <hr>
            <li style="cursor: pointer">
                <i class="fas fa-users fa-2x" onclick = "view.showComponents('home')"></i>
            </li>
        </ul>
    </div>`

component.modalAddEmployee = `
    <div class="modal fade" id="modalAddEmployee" data-backdrop="static" data-keyboard="false" tabindex="-1"
        aria-labelledby="modelAddEmployeeLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modelAddEmployeeLabel">Add employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" id="nameNewEmployee" placeholder="User Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="fullNameNewEmployee" placeholder="Full Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="EmailNewEmployee" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" id="departmentNewEmployee" placeholder="Department">
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="joinDateNewEmployee" placeholder="Join Date">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="buttonAddEmployee" onclick="controller.addNewEmployee()">Add</button>
                </div>
            </div>
        </div>
    </div>`

component.modalAddGroup = `
    <div class="modal fade" id="modalAddGroup" data-backdrop="static" data-keyboard="false" tabindex="-1"
        aria-labelledby="modelAddEmployeeLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modelAddEmployeeLabel">Add Group</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" id="newGroupName" placeholder="Group Name">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="buttonAddEmployee" onclick="controller.addNewGroup()">Add</button>
                </div>
            </div>
        </div>
    </div>`

component.modalUpdateNameGroup = `
    <div class="modal fade" id="modalUpdateNameGroup" data-backdrop="static" data-keyboard="false" tabindex="-1"
        aria-labelledby="modalUpdateNameGroupLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalUpdateNameGroupLabel">Update Name Group</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" id="UpdateNewNameGroup" placeholder="Group Name">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="buttonAddEmployee" onclick="controller.UpdateNewNameGroup()">Update</button>
                </div>
            </div>
        </div>
    </div>`

component.modalUpdateEmployee = `
    <div class="modal fade" id="modalUpdateEmployee" data-backdrop="static" data-keyboard="false" tabindex="-1"
        aria-labelledby="modelAddEmployeeLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modelAddEmployeeLabel">Update employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" id="nameUpdateEmployee" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="departmentUpdateEmployee" placeholder="Derpartment">
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" id="phoneUpdateEmployee" placeholder="Phone">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <div id="buttonUpdateEmployee">
                        
                    </div>
                </div>
            </div>
        </div>
    </div>`

component.tableFunction = `
    <div class="table-function">
        <div class="input-group mb-3" style="width: 300px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><i class="fas fa-search"></i></span>
            </div>
            <input type="text" class="form-control" placeholder="Search group" aria-label="Username"
                aria-describedby="basic-addon1">
        </div>
        <ul class="list-function">
            <i class="fas fa-cloud-download-alt item-function"></i>
            <i class="fas fa-filter item-function"></i>
            <i class="fas fa-plus item-function" onclick="view.showModalAddGroup()"></i>
            <i class="fas fa-sync item-function"></i>
            <i class="fas fa-trash-alt item-function" onclick="view.showAlertDelGroup()"></i>
        </ul>
    </div>`

component.home = `
    <div id="homePage" class="container">
        ${component.modalAddEmployee}
        ${component.tableFunction}
        ${component.modalAddGroup}
        <div id="table">
                <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Selected</th>
                    <th scope="col">STT</th>
                    <th scope="col">Group Name</th>
                </tr>
                </thead>
                <tbody id="tBody">
                
                </tbody>
            </table>
        </div>
    </div>`


component.detailGroup = `
    <div class="container">
        <div id="detail-header">
            <div class="title-header">
                <h2>Java Core</h2>
                <i class="fas fa-pen fa-2x"></i>
            </div>
            <ul>
                <li>Creator: Nguyen Anh Tuan</li>
                <li>Create Date: 10/02/1999</li>
                <li>Member: 1</li>
            </ul>
        </div>
        <div class="table-function">
            <div class="input-group mb-3" style="width: 300px">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1"><i class="fas fa-search"></i></span>
                </div>
                <input type="text" class="form-control" placeholder="Search member" aria-label="Username"
                    aria-describedby="basic-addon1">
            </div>
            <ul class="list-function">
                <i class="fas fa-edit item-function" onclick="view.showModalAddEmployee()"></i>
                <i class="fas fa-filter item-function"></i>
                <i class="fas fa-sync item-function"></i>
                <i class="fas fa-trash-alt item-function"></i>
            </ul>
        </div>
        <div id="table">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">User Name</th>
                        <th scope="col">Full Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Department</th>
                        <th scope="col">Join Date</th>
                    </tr>
                </thead>
                <tbody id="tBody">

                </tbody>
            </table>
        </div>
    </div>`

component.footer = `
    <footer class="footer">
        <hr>
        <p>footer</p>
    </footer>
`