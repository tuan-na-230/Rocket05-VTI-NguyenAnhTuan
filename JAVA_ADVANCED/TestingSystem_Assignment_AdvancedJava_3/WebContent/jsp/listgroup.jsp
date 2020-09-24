<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>Manage List Group</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn2 btn-info add-new" style="background-color: lightcoral;" onclick="openDeleteConfirm()"><i class='far fa-trash-alt' style="font-size: 14px;"></i>Delete</button>
                        <button type="button" class="btn2 btn-info add-new" data-toggle="modal" onclick="openAddModal()"><i class="fa fa-plus"></i> Add New</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th style="width: 3%;"></th>
                        <th style="width: 10%;">STT</th>
                        <th style="width: 40%;">Group Name</th>
                        <th style="width: 30%;">Create Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    
    <div id="myModal" class="modal fade" tabindex="-1" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add New Group</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="modal-container">
                        <label for="name"><b>Group Name</b></label>
                        <input type="text" placeholder="Enter Group Name" name="name" id="name" autofocus required>
                        <br>
                        <label for="member"><b>Member</b></label>
                        <input type="number" placeholder="Enter Member" name="member" id="member" min="0" required>
                        <br>
                        <label for="creator"><b>Creator</b></label>
                        <input type="text" placeholder="Enter Creator" name="creator" id="creator" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="addGroup()">Save </button>
                </div>
            </div>
        </div>
    </div>

    <!-- success alert -->
    <div class="alert alert-success" id="alert-success" style="display: none;">
        <button type="button" class="close" data-dismiss="alert"></button>
        <strong>One new group is added successfully!</strong>
    </div>

    <div class="alert alert-danger" id="alert-danger" style="display: none;">
        <button type="button" class="close" data-dismiss="alert"></button>
        <strong>Delete is successful!</strong>
    </div>
</div>