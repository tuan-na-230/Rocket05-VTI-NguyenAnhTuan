$(function() {
   	var usernameCookie = getCookie("username");
	
	if(!usernameCookie){
		$("a#listgroup").hide();
		$("span#username").hide();
		$("span#role").hide();
		$("a.logout").hide();
		$("a.login").show();
	}else{
		$("a#listgroup").show();
		$("span#username").show();
		$("span#role").show();
		$("a.logout").show();
		$("a.login").hide();
	}
});

function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function openNav() {
    if(document.getElementById("mySidenav").style.width != "70px"){
        document.getElementById("mySidenav").style.width = "70px";
        document.getElementById("main").style.marginLeft = "70px";
    }
    else{
        closeNav();
    }
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}

function openHome(){
    $(".main-content").load("jsp/home.jsp");
}

function openListGroup(){
    $(".main-content").load("jsp/listgroup.jsp");
	builtTable();
}

function login(){
	location.replace("./login");
}

function logout(){
	location.replace("./logout")
}

//List Group
var groups = [];

function Group(id, name, createDate){
    this.id = id;
    this.name = name;
    this.createDate = createDate;
}

function initGroups(){
    //init data
    $.get("https://5f47b2a695646700168d9bdb.mockapi.io/api/v1/Group", function(data, status){
        
        // reset list groups
        groups = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillGroupToTable();
    });
}

function parseData(data) {
    data.forEach(function(item) {
        groups.push(new Group(item.id, item.name, item.createDate));
    });
}

function fillGroupToTable(){
    var stt = 1;
    $('tbody').empty();
    groups.forEach(function(item){
        if(stt%2==0){
            $('tbody').append(
            '<tr>'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + stt + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+
                '<td>' + convertExpandedDateToDate(item.createDate) + '</td>'+
            '</tr>')
        }
        else{
            $('tbody').append(
            '<tr style="background-color: lightgray;">'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + stt + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+
                '<td>' + convertExpandedDateToDate(item.createDate) + '</td>'+
            '</tr>')
        }
        stt++;
    });
}

function builtTable() {
    // $('tbody').empty();
    initGroups();
}

function builtTableNull(){
    setTimeout(function name(params){
        $('tbody').empty();
        $('tbody').append(
        '<tr style="background-color: lightgray;">'+
            '<td><input type="checkbox" name="idGroup"></td>'+
            '<td></td>'+
            '<td></td>'+
            '<td></td>'+
        '</tr>');
    }, 300)
}

function openAddModal(){
    resetForm();
    showModal();
}

function resetForm(){
    document.getElementById("name").value = "";
    document.getElementById("member").value = "";
    document.getElementById("creator").value = "";
}

function showModal(){
    $('#myModal').modal('show');
}

function hideModal(){
    $('#myModal').modal('hide');
}

function convertExpandedDateToDate(exDate){
    var date = new Date(exDate);
    var dd = exDate.slice(8,10);
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();

    if(mm<10) mm='0'+mm;
    return dd+'/'+mm+'/'+yyyy;
}

function convertDateToExpandedDate(date){
    var dd = date.getDate();
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();
    var HH = date.getHours();
    var MM = date.getMinutes();
    var SS = date.getSeconds();
    var MLS = date.getMilliseconds();

    if(dd<10) dd='0'+dd;
    if(mm<10) mm='0'+mm;
    if(HH<10) HH='0'+HH;
    if(MM<10) MM='0'+MM;
    if(SS<10) SS='0'+SS;
    if(MLS<10) MLS='00'+MLS
    else if(MLS<100) MLS='0'+MLS;

    return yyyy+'-'+mm+'-'+dd+'T'+HH+':'+MM+':'+SS+'.'+MLS+'Z';
}

function checkNameGroup(name){
    var index = 0;
    var check = false;
    // index = groups.findIndex(x => x.name.localeCompare(name));

    groups.forEach(function(item){
        if(item.name.localeCompare(name) == 0){
            index += 1;
        }
    })
    if (index == 0){
        check = true;
    }
    return check;
}

function showSuccessAlert(){
    $("#alert-success").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-success").slideUp(500);
    });
}

function showDeleteAlert(){
    $("#alert-danger").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-danger").slideUp(500);
    });
}