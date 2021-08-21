package db;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.Config;
import model.ID;
import model.Tweet;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class TweetDB implements DBSet<Tweet>{
    private static Config config = Config.getConfig("db");
    public static final String lastIDPath = config.getProperty("tweet")+config.getProperty("lastID");
    public static final String dbPath = config.getProperty("tweet")+config.getProperty("db");

    @Override
    public ID getLastID() {
        File file = new File(lastIDPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                PrintStream printStream = new PrintStream(file);
                printStream.println("0");
                printStream.flush();
                printStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            Scanner scanner = new Scanner(file);
            String lastID =scanner.nextLine();
            scanner.close();

            return new ID(Integer.parseInt(lastID));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void increaseLastID() {
        int lastIDNum = 0;
        File file = new File(lastIDPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                PrintStream printStream = new PrintStream(file);
                printStream.println(lastIDNum);
                printStream.flush();
                printStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(file);
            String lastID =scanner.nextLine();
            scanner.close();

            lastIDNum = Integer.parseInt(lastID);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        lastIDNum++;

        try {
            PrintStream printStream = new PrintStream(file);
            printStream.println(lastIDNum);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tweet get(ID id) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                Tweet tweet = gson.fromJson(scanner.nextLine(),Tweet.class);
                if (tweet.getId().equals(id)){
                    return tweet;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public LinkedList<Tweet> getAll() {
        LinkedList<Tweet> tweets = new LinkedList<>();
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                Tweet tweet = gson.fromJson(scanner.nextLine(),Tweet.class);
                tweets.add(tweet);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tweets;
    }

    @Override
    public void add(Tweet tweet) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            FileOutputStream stream = new FileOutputStream(file,true);
            PrintStream printStream = new PrintStream(stream);
            String userStr = gson.toJson(tweet);
            printStream.println(userStr);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Tweet tweet) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LinkedList<Tweet> tweets = getAll();
        tweets.removeIf(iteratedTweet -> iteratedTweet.getId().equals(tweet.getId()));

        writeList(tweets,file);
    }

    @Override
    public void update(Tweet tweet) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LinkedList<Tweet> tweets = getAll();

        tweets.removeIf(iteratedTweet -> iteratedTweet.getId().equals(tweet.getId()));
        tweets.add(tweet);

        writeList(tweets,file);

    }

    @Override
    public void writeList(LinkedList<Tweet> tweets, File file) {
        try {
            Gson gson = new GsonBuilder().create();
            PrintStream printStream = new PrintStream(file);
            for (Tweet iteratedTweet : tweets){
                String userStr = gson.toJson(iteratedTweet);
                printStream.println(userStr);
            }
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
