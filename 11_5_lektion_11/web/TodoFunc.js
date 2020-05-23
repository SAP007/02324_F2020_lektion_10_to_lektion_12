$(document).ready(function(){
console.log("running");
    loadList();

    $('#updateKnap').on('click', function(){
        var $input_text = $('#add_item').val();
        var $input_id = $('#id').val();

        if ($input_text != "") {
            var $delete_button = $('<button>slet</button>').click(function(){
                $(this).closest('li').remove();
            });

        }else{
            alert("tekst felt er tomt");
        }

    });

});

function createTodoHTML(todoElem) {
    var id = todoElem.id;
    var name = todoElem.todo;
   return '<li>'+ id + name + '</li>';

}

function loadList() {
    console.log("inside loadList")
    $.get("rest/todo", function(data,textStatus,req){

        $("#modify_list").empty();
        console.log("data" + data);
        $.each(data, function(i, todo){
            console.log(i+"," +  todo);
            $("#modify_list").append(createTodoHTML(todo));
        });
    });

}
