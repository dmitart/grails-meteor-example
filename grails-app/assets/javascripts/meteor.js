index.scope.todos = new Todo.List({});
index.scope.description = can.compute('');
index.scope.add = function() {
  new Todo({'description':this.description(), 'done':false}).save();
  this.description('');
};
index.scope.delete = function(todo) {
  todo.destroy();
};
index.events = {
  "{Todo_changes} change": function(){
    this.scope.attr('todos', new Todo.List({}));
  }
};