$(document).ready(function(){
    loadList();
});

//onclick funktion til individuelle to do elementer
function deleteTodo(id){
    event.preventDefault();
    $.ajax({
        url: 'rest/todo/' + id,
        method: 'DELETE',
        contentType: 'application/json',
        complete: function (data) {
            loadList();
        }
    });
}

//Sletter element givet id
function deleteWithId(){
    event.preventDefault();
    var id = $('#remove_item').val();
    $.ajax({
        url: 'rest/todo/' + id,
        method: 'DELETE',
        contentType: 'application/json',
        complete: function (data) {
            loadList();
        }
    });
}

//Opretter nyt to do element
function createTodoElement(){
    event.preventDefault();
    var id = $('#id').val();
    //Simpelt eksempel på front-end fejlhåndtering
    if (!(id == parseInt(id, 10))) {
        alert("id skal være heltal");
        return;
    }

    var data = JSON.stringify( {id : $('#id').val(), todo : $('#add_item').val()});
    $.ajax({
        url: 'rest/todo/form',
        method: 'POST',
        contentType: "application/json",
        dataType : "text",
        data : data,
        success: function (data) {
            alert((data));
            loadList();

         $('form[name="createTodoFrom"]')[0].reset();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText + ", " + textStatus + ", " + errorThrown);
        }
    });
}

//Opdaterer eksisterende elementer
function  updateTodoElement() {
    var id = $('#update_id').val();
    var name = $('#update_name').val();
    $.ajax({
        url: 'rest/todo/' + id + '/' + name,
        method: 'PUT',
        complete: function (data) {
            loadList();
        }
    });
}

// Opretter HTML elementer til nye to do objekter
function createTodoHTML(todoElem) {
    var id = todoElem.id;
    var name = todoElem.todo;
   return  ' <li>' + '<div id="todoCon">'+ id +"  "+  name  + '<button class="btn" id="deleteBtn" onclick="deleteTodo(' + id + ');"> slet </button>' +
       '<input type="checkbox" value="completed">' + '</li>' + '</div>' ;
}

//Henter to do listen fra server, og displayer hvert element
function loadList() {
    $.get("rest/todo", function(data,textStatus,req){
        $("#modify_list").empty();
        $.each(data, function(i, todo){
            $("#modify_list").append(createTodoHTML(todo));
        });
    });
}

