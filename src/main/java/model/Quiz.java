package model;

public class Quiz {


    private long id;
    private String name;
    private String topic;
    private int time;
    private int question;
    private int difficult;

    public Quiz() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", time=" + time +
                ", question=" + question +
                ", difficult=" + difficult +
                '}';
    }
}
