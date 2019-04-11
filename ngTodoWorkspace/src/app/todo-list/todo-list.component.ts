import { TodoService } from './../todo.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../models/todo';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  title = 'ngTodo';

  todos = [];

  selected = null;
  quickSelect = null;
  selectedTodoStatus = false;
  quickSelectedStatus = false;
  completedTodos = 0;
  completedColor = 'red';

  editTodo = null;
  newTodo = new Todo();


  addTodo(newTodoForm: NgForm) {
    // console.log('**** inside addTodo ****');
    // console.log(this.newTodo);
    this.todoService.create(this.newTodo);
    this.newTodo = new Todo();
    newTodoForm.reset();
    this.todos = this.todoService.index();
  }

  changeCompletedStatus() {
    if (this.selected.completed !== true) {
      this.selected.completed = true;
      this.selectedTodoStatus = true;
      this.refreshCompletion();
    } else {
      this.selected.completed = false;
      this.selectedTodoStatus = false;
      this.refreshCompletion();
    }
  }

  countTotalTodos() {
    return this.todos.length;
  }

  countCompletedTodos() {
    let completedCount = 0;
    this.todos.forEach(element => {
      if (element.completed) {
        completedCount++;
      }
    });
    return completedCount;
  }

  completedRatio() {
    const ratio: number = this.completedTodos / this.countTotalTodos();
    if (ratio < 0.5) {
      return 'red';
    } else if (ratio >= 0.5 && ratio < 0.8) {
      return 'yellow';
    } else {
      return 'green';
    }
  }

  deleteTodo(deleteId: number) {
    this.todoService.destroy(deleteId);
    this.refreshCompletion();
  }

  displayTodo(selectedTodo: Todo) {
    this.selected = selectedTodo;
    this.selected.completed = selectedTodo.completed;
  }

  displayTable() {
    this.selected = null;
  }

  everythingIsCompleted() {
    this.todos.forEach(todo => {
      todo.completed = true;
      this.refreshCompletion();
    });
  }

  everythingIsIncomplete() {
    this.todos.forEach(todo => {
      todo.completed = false;
      this.refreshCompletion();
    });
  }

  refreshCompletion() {
    this.completedTodos = this.countCompletedTodos();
    this.todos = this.todoService.index();
    this.completedRatio();
  }

  setEditTodo() {
    this.editTodo = Object.assign({}, this.selected);
    console.log(this.selected);
    console.log(this.editTodo);

  }

  updateTodo(todo: Todo) {
    this.todoService.update(todo);
    // this.todos[this.selected.id - 1] = todo;
    this.editTodo = null;
    this.selected = null;
    this.refreshCompletion();
  }

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.todos = this.todoService.index();
  }
}
