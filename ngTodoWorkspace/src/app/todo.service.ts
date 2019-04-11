import { Injectable } from '@angular/core';
import { Todo } from './models/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private todos: Todo[] = [
    new Todo(1, 'Go round mums', '', false),
    new Todo(2, 'Get Liz back', '', false),
    new Todo(3, 'Sort life out', '', false),
    new Todo(4, 'Kill Phil', '', false),
    new Todo(5, 'Run from zombies', '', false)
  ];

  create(newTodo: Todo) {
    newTodo.id = this.generateId();
    newTodo.completed = false;
    console.log('within todo service: ' + newTodo.task);

    this.todos.push(newTodo);
  }

  destroy(goodbyeId: number) {
    // array.splice(index, howMany, item1 ... itemx);
    this.todos.forEach(todo => {
      if (todo.id === goodbyeId) {
        this.todos.splice((goodbyeId - 1), 1);
        console.log('in service: todo removed');
      }
    });
  }

  generateId() {
    return this.todos[this.todos.length - 1].id + 1;
  }

  index() {
    // defensive copy of private array
    return [...this.todos];
  }

  update(editTodo: Todo) {
    this.todos[editTodo.id - 1] = editTodo;
  }

  constructor() { }
}
