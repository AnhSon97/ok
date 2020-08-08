$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListEmployees() {
    $(".main").load("viewlistemployees.html");
    buildTable();
}

var employees = [];

function Employee(id, name) {
    this.id = id;
    this.name = name;
}

function getListEmployees() {
    // call API from server
    $.get("http://localhost:8080/api/v1/Car", function(data, status) {

        // reset list employees
        employees = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillEmployeeToTable();
    });
}

function parseData(data) {
    employees = data;

    // data.forEach(function(item) {
    //     employees.push(new Employee(item.id, item.name));
    // });
}

function fillEmployeeToTable() {
    employees.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + "repairdate::" + item.repairdate + '</td>' +
            '<td>' +
            '<tr>' +
            '<td>' + "customername::"+item.customername + '</td>' +
            '<td>' +
            '<tr>' +
            '<td>' + "catalogs::" +item.catalogs + '</td>' +
            '<td>' +
            '<tr>' +
            '<td>' + "carmarket::" +item.carmarket + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>' + "--------------------------------------------------------------------------------------------------------------------" + '</td>' +
            '<td>'
            )
    });
}

function buildTable() {
    $('tbody').empty();
    getListEmployees();
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addEmployee() {

    // get data
    var name = document.getElementById("name").value;
    var repairdate = document.getElementById("repairdate").value;
    var customername = document.getElementById("customername").value;
    var catalogs = document.getElementById("catalogs").value;
    var carmarket = document.getElementById("carmarket").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        repairdate: repairdate,
        customername: customername,
        catalogs: catalogs,
        carmarket: carmarket
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/Car',
        type: 'POST',
        data: JSON.stringify(employee), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function(data, textStatus, xhr) {
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openUpdateModal(id) {

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    var customername = document.getElementById("customername").value;
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        repairdate: repairdate,
        catalogs: catalogs,
        carmarket: carmarket
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/Car/' + customername,
        type: 'PUT',
        data: JSON.stringify(employee),
        contentType: "application/json",
        success: function(result) {
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function(result) {
            // success
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}