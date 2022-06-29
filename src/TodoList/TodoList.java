package TodoList;

import java.io.*;
import java.util.*;

public class TodoList {
    String title;
    Set<String> tasks = new HashSet<>();

    public TodoList(String title) {
        this.title = title;
    }

    public TodoList() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoList todoList = (TodoList) o;
        return title.equals(todoList.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "title='" + title + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Interface.TodoList todoList = new Interface.TodoList();
        int start;
        do {
            System.out.println("Enter below numbers to do following tasks");
            System.out.println("1. Add Task");
            System.out.println("2 Display Task");
            System.out.println("3 Save Data");
            System.out.println("4 Show Saved Data");
            System.out.println("5 Add Data to previous list");


            start = input.nextInt();
            switch (start) {
                case 1: {

                    System.out.println("Enter Task title");
                    String title = input1.nextLine();
                    todoList.tasks.add(title);
                    break;
                }
                case 2: {
                    System.out.println(todoList.tasks);
                    break;
                }
                case 3:{
                    try {
                    FileOutputStream writeData = new FileOutputStream("/home/harshavardhan/Documents/IOTask.doc");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                    writeStream.writeObject(todoList.tasks);
                    writeStream.flush();
                    writeStream.close();
                    System.out.println("Successfully saved");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    break;
                }
                case 4:{
                    try {
                    FileInputStream readData = new FileInputStream("/home/harshavardhan/Documents/IOTask.doc");
                    ObjectInputStream readStream = new ObjectInputStream(readData);
                    List todolist1 = (ArrayList<String>) readStream.readObject();
                    System.out.println(todolist1);
                    readStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                    break;
                }
                case 5:{
                    try {
                        FileInputStream readData = new FileInputStream("/home/harshavardhan/Documents/IOTask.doc");
                        ObjectInputStream readStream = new ObjectInputStream(readData);
                        List todolist1 = (ArrayList<String>) readStream.readObject();
                        todolist1.addAll(todoList.tasks);
                        System.out.println(todolist1);
                        readStream.close();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }
        }
        while (start != 0);
    }
}