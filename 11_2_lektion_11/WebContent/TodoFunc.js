$(document).ready(function(){
loadList();
});

function createTodoHTML(todoElem) {
    var id = todoElem.id;
    var name = todoElem.todo;
   return  ' <li>' + '<div id="todoCon">'+ id +"  "+  name  + '<button class="btn" id="deleteBtn" onclick="deleteTodo(' + id + ');"> slet </button>' +
       '<input type="checkbox" value="completed">' + '</li>' + '</div>' ;
}

function loadList() {
    $.get("rest/todo", function(data,textStatus,req){
        $("#modify_list").empty();
        $.each(data, function(i, todo){
            $("#modify_list").append(createTodoHTML(todo));
        });
    });

}
