use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/design-a-todo-list/description/
#[derive(Debug)]
struct TodoList {
    tasks: HashMap<i32, HashMap<i32, Task>>,
    task_id: i32,
}

#[derive(Debug)]
struct Task {
    description: String,
    due_date: i32,
    tags: HashSet<String>,
    completed: bool,
}

impl Task {
    fn new(description: String, due_date: i32, tags: HashSet<String>) -> Task {
        Self {
            description,
            due_date,
            tags,
            completed: false,
        }
    }
}

impl TodoList {
    fn new() -> Self {
        Self {
            tasks: HashMap::new(),
            task_id: 0,
        }
    }

    fn add_task(
        &mut self,
        user_id: i32,
        task_description: String,
        due_date: i32,
        tags: Vec<String>,
    ) -> i32 {
        self.task_id += 1;
        let tasks = self.tasks.entry(user_id).or_insert(HashMap::new());
        tasks.insert(
            self.task_id,
            Task::new(task_description, due_date, tags.into_iter().collect()),
        );
        self.task_id
    }

    fn get_all_tasks(&self, user_id: i32) -> Vec<String> {
        let empty_map: HashMap<i32, Task> = HashMap::new();
        let mut tasks: Vec<&Task> = self
            .tasks
            .get(&user_id)
            .unwrap_or(&empty_map)
            .iter()
            .filter(|(_, task)| !task.completed)
            .map(|(_, task)| task)
            .collect();
        tasks.sort_by(|a, b| a.due_date.cmp(&b.due_date));
        tasks.iter().map(|task| task.description.clone()).collect()
    }

    fn get_tasks_for_tag(&self, user_id: i32, tag: String) -> Vec<String> {
        let empty_map: HashMap<i32, Task> = HashMap::new();
        let mut tasks: Vec<&Task> = self
            .tasks
            .get(&user_id)
            .unwrap_or(&empty_map)
            .iter()
            .filter(|(_, task)| !task.completed)
            .filter(|(_, task)| task.tags.contains(&tag))
            .map(|(_, task)| task)
            .collect();
        tasks.sort_by(|a, b| a.due_date.cmp(&b.due_date));
        tasks.iter().map(|task| task.description.clone()).collect()
    }

    fn complete_task(&mut self, user_id: i32, task_id: i32) {
        if let Some(tasks) = self.tasks.get_mut(&user_id) {
            if let Some(task) = tasks.get_mut(&task_id) {
                task.completed = true;
            }
        }
    }
}

fn main() {
    let mut todo_list = TodoList::new();
    println!("{}", todo_list.add_task(1, "Task1".to_string(), 50, vec![])); // 1
    println!(
        "{}",
        todo_list.add_task(1, "Task2".to_string(), 100, vec!["P1".to_string()])
    ); // 2
    println!("{:?}", todo_list.get_all_tasks(1)); // ["Task1","Task2"]
    println!("{:?}", todo_list.get_all_tasks(5)); // []
    println!(
        "{}",
        todo_list.add_task(1, "Task3".to_string(), 30, vec!["P1".to_string()])
    ); // 3
    println!("{:?}", todo_list.get_tasks_for_tag(1, "P1".to_string())); // ["Task3","Task2"]
    todo_list.complete_task(5, 1);
    todo_list.complete_task(1, 2);
    println!("{:?}", todo_list.get_tasks_for_tag(1, "P1".to_string())); // ["Task3"]
    println!("{:?}", todo_list.get_all_tasks(1)); //["Task3","Task1"]
}
