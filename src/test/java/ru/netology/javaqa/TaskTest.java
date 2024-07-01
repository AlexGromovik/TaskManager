package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldReturnFalseWithWrongInTitle(){
        SimpleTask task = new SimpleTask(3, "Дед Федот");
        String query = "Тетя Сима";
        boolean expected = false;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTrueIfItMatchesTheRequest(){
        SimpleTask task = new SimpleTask(44, "Running milk");
        String query = "milk";
        boolean expected = true;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnFalseWithWrongSubtask() {
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(7, subtasks);
        String query = "Task 7";
        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueWithCorrectSubtask() {
        String[] subtasks = {"Task A", "Task B", "Task C"};
        Epic epic = new Epic(555, subtasks);
        String query = "Task B";
        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfRequestDontMatchTopicOrProjectOrStart(){
        Meeting meeting = new Meeting(375, "Переговоры", "Проект Альфа", "25.05.2024 в 14:44");
        String query = "Hello, Kitty";
        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTrueIfRequestMatchInTopic(){
        Meeting meeting = new Meeting(2, "Contract", "With JSC Topaz", "11:50 22/07/2024");
        String query = "Contract";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTrueIfRequestMatchInProject(){
        Meeting meeting = new Meeting(2, "Contract", "With JSC Topaz", "11:50 22/07/2024");
        String query = "Topaz";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected,actual);
    }
}
