$(document).ready(function(){
});

function createTodoHTML(todoElem) {
    var id = todoElem.id;
    var name = todoElem.todo;
   return  ' <li>' + '<div id="todoCon">'+ id +"  "+  name  + '<button class="btn" id="deleteBtn" onclick="deleteTodo(' + id + ');"> slet </button>' +
       '<input type="checkbox" value="completed">' + '</li>' + '</div>' ;
}

