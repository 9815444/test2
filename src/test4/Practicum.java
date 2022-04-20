package test4;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class Post {
    private int id;
    private String text;
    private List<Comment> commentaries = new ArrayList<>();

    private Post() {}

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void addComment(Comment comment) {
        commentaries.add(comment);
    }

    public int getId() {
        return id;
    }
}

class Comment {
    private String user;
    private String text;

    private Comment() {}

    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
    }
}

public class Practicum {
    private static final int PORT = 8080;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static Gson gson = new Gson();
    private static List<Post> posts = new ArrayList<>();

    static {
        Post post1 = new Post(1, "Это первый пост, который я здесь написал.");
        post1.addComment(new Comment("Пётр Первый", "Я успел откомментировать первым!"));
        posts.add(post1);

        Post post2 = new Post(22, "Это будет второй пост. Тоже короткий.");
        posts.add(post2);

        Post post3 = new Post(333, "Это пока последний пост.");
        posts.add(post3);
    }

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();
        // тут конфигурирование и запуск сервера
        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/posts", new PostsHandler());
        httpServer.start();

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        httpServer.stop(1);
    }

    static class PostsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            // ваш код
            System.out.println("Началась обработка /posts запроса от клиента.");
            String method = httpExchange.getRequestMethod();
            String path = httpExchange.getRequestURI().getPath();
            switch (method) {
                case "GET":

                default:
                    System.out.printf("Неверный запрос.");
            }
        }
    }
}