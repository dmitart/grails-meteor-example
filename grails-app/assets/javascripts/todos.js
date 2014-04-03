var Todo = can.Model({
  findAll: function(id)   {return $.get('/grails-meteor-example/todos.json/')},
  findOne: function(id)   {return $.get('/grails-meteor-example/todos.json/'+id)},
  create:  function(data) {return $.post('/grails-meteor-example/todos.json/', data)},
  update:  function(id)   {return $.ajax({type: 'PUT',    url: '/grails-meteor-example/todos.json/'+id })},
  destroy: function(id)   {return $.ajax({type: 'DELETE', url: '/grails-meteor-example/todos/'+id, contentType: 'application/json' })}
}, {});

can.Component.extend({
  tag: "todos",
  template: can.view("todos.mustache"),
  scope: {
    todos: new Todo.List({}),
    description: can.compute(''),
    add: function() {
      new Todo({'description':this.description(), 'done':false}).save();
      this.description('');
    },
    delete: function(todo) {
      todo.destroy();
    }
  },
  events: {
    "{todo} change": function(){
      this.scope.attr('todos', new Todo.List({}));
    }
  }
});

$(document).ready(function() {
  $("body").html( can.view.mustache("<todos></todos>"));
});
