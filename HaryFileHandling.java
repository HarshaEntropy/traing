import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


class TODO{
    int userId;
    int id;
    Boolean completed;
    String title;


    public TODO(int id, int userId, Boolean completed, String title) {
        this.id = id;
        this.userId = userId;
        this.completed = completed;
        this.title = title;
    }


    @Override
    public String toString() {
        return "TODO{" +
                "userId=" + userId +
                ", id=" + id +
                ", completed=" + completed +
                ", title='" + title + '\'' +
                '}';
    }

    public TODO() {
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class TodoList {
    ArrayList<TODO> todoList = new ArrayList<>();

    public List addTodo(int id, int userId, Boolean completed, String title) {
        todoList.add(new TODO(id, userId, completed, title));
        return todoList;
    }

    public TODO getTodoById(int id) throws NotFound {
        for (TODO todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        throw new NotFound("Id not Found");
    }

    public TODO getTodoByUserId(int userId) throws NotFound {
        for (TODO todo : todoList) {
            if (todo.getUserId() == userId) {
                return todo;
            }
        }
        throw new NotFound("UserId not Found");
    }

    public TODO getTodoByTitle(String title) throws NotFound {
        for (TODO todo : todoList) {
            if (Objects.equals(todo.getTitle(), title)) {
                return todo;
            }
        }
        throw new NotFound("Title not Found");
    }

    public List<TODO> getTodoByCompleted(boolean value) throws NotFound {
        List<TODO> valueList = new ArrayList<>();
        for (TODO todo : todoList) {
            if (todo.getCompleted() == value) {
                valueList.add(todo);
            }
        }
        return valueList;
    }

    public void changeStatusById(int id, boolean value) {
        for (TODO todo : todoList) {
            if (todo.getId() == id) {
                todo.setCompleted(value);
            }
        }
    }
    public void changeStatusByUserId(int userId, boolean value) {
        for (TODO todo : todoList) {
            if (todo.getUserId() == userId) {
                todo.setCompleted(value);
            }
        }
    }
}
public class Data {

    public static void main(String[] args) {
        try {
            TodoList todo = new TodoList();
            URL url=new URL("https://jsonplaceholder.typicode.com/todos");
            URLConnection urlCon = url.openConnection();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(br);

            JSONArray todos =  (JSONArray) obj;

            Iterator<JSONObject> iterator = todos.iterator();
            while (iterator.hasNext()) {
                JSONObject todoObject = iterator.next();
                todo.addTodo (
                        Integer.parseInt(todoObject.get("id").toString()),
                        Integer.parseInt(todoObject.get("userId").toString()),
                        (Boolean) todoObject.get("completed"),
                        (String) todoObject.get("title")
                );
            }
            System.out.println(todo.getTodoById(7));
            todo.changeStatusById(7,true);

            System.out.println(todo.getTodoById(7));

        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NotFound e) {
        }

    }
    }
class NotFound extends Exception {
    public NotFound(String str) {
        super(str);
    }
}
