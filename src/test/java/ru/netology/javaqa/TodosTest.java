package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyRequestWhenSearchWithNoMatches(){
        Todos todos = new Todos();

        todos.add(new SimpleTask(2, "Каша"));
        todos.add(new Epic(3, new String[]{"Умыться", "Позавтракать", "Собраться на работу"}));
        todos.add(new Meeting(1, "Встреча", "Кафе Обухов", "10.00"));

        Task[] expected = {};
        Task[] actual = todos.search("Отпуск");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldReturnRequestWhenSearchWithOneMatches(){
        Todos todos = new Todos();

        todos.add(new SimpleTask(2, "Каша"));
        todos.add(new Epic(3, new String[]{"Умыться", "Позавтракать", "Собраться на работу"}));
        todos.add(new Meeting(1, "Встреча", "Кафе Обухов", "10.00"));

        Task[] expected = {new Epic(3, new String[]{"Позавтракать"})};
        Task[] actual = todos.search("Позавтракать");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldShowAllRecordsWhenSearchEmptyQuery(){
        Todos todos = new Todos();

        todos.add(new SimpleTask(2, "Каша"));
        todos.add(new Epic(3, new String[]{"Умыться", "Позавтракать", "Собраться на работу"}));
        todos.add(new Meeting(1, "Встреча", "Кафе Обухов", "10.00"));

        Task[] expected = {new SimpleTask(2, "Каша"), new Epic(3, new String[]{"Умыться", "Позавтракать", "Собраться на работу"}), new Meeting(1, "Встреча", "Кафе Обухов", "10.00")};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected,actual);
    }

}
