package Interface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class TodoList {
    String title;
    public List<String> tasks = new ArrayList<>();

    public TodoList(String title){
        this.title=title;
    }

    public TodoList() {

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
        TodoList todoList = new TodoList();



        int st;
        do {
            System.out.println("Enter below numbers to do following tasks");
            System.out.println("1. Add Task");
            System.out.println("2 Display Task");
            System.out.println("3 Privies Data");
            try {
                FileOutputStream writeData = new FileOutputStream("/home/harshavardhan/testout.txt");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                writeStream.writeObject(todoList.tasks);
                writeStream.flush();
                writeStream.close();
                writeData.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                FileInputStream readData = new FileInputStream("/home/harshavardhan/testout.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);
                ArrayList todolist1 = (ArrayList<TodoList>) readStream.readObject();
                todoList.tasks.addAll(todolist1);
                readStream.close();
                readData.close();
            }

            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            st = input.nextInt();
            switch (st) {
                case 1: {

                    System.out.println("Enter Task title");
                    String title = input1.nextLine();
                    todoList.tasks.add(String.valueOf(new TodoList(title)));

                    break;
                }
                case 2: {
                    System.out.println(todoList.tasks);
                    break;
                }
                case 3: {
                    System.out.println();
                }
            }
        }
            while (st != 0) ;

        }

    }
