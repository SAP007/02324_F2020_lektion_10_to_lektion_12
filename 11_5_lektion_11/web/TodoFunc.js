$(document).ready(function(){
    loadList();
});

function deleteTodo(id){
    event.preventDefault();
    console.log("id is " + id);
    $.ajax({
        url: 'rest/todo/' + id,
        method: 'DELETE',
        contentType: 'application/json',
        complete: function (data) {
            loadList();
        }
    });
}


function createTodoElement(){
    event.preventDefault();
    var data = JSON.stringify( {id : $('#id').val(), todo : $('#add_item').val()});
    $.ajax({
        url: 'rest/todo/form',
        method: 'POST',
        contentType: "application/json",
        data : data,
        success: function (data) {
            alert(JSON.stringify(data));
            loadList();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        }
    });
}

function createTodoHTML(todoElem) {
    var id = todoElem.id;
    var name = todoElem.todo;
   return '<li>'+ id +"     "+  name + '</li>' + '<button onclick="deleteTodo(' + id + ');">slet</button>';

}

function loadList() {
    console.log("inside loadList")
    $.get("rest/todo", function(data,textStatus,req){

        $("#modify_list").empty();
        console.log("data" + data);
        $.each(data, function(i, todo){
            console.log(i + "," +  todo);
            $("#modify_list").append(createTodoHTML(todo));
        });
    });

}
