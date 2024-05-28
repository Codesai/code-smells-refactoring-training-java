package birthdaygreetings.core;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static java.util.stream.Collectors.toList;

public class GreetingMessage {

    private final String to;
    private final Greeting greeting;

    private GreetingMessage(String to, Greeting greeting) {
        this.to = to;
        this.greeting = greeting;
    }

    public static List<GreetingMessage> generateForSome(List<Employee> employees) {
        return employees.stream().map(GreetingMessage::generateFor).collect(toList());
    }

    private static GreetingMessage generateFor(Employee employee) {
        Greeting greeting = Greeting.forBirthdayOf(employee);
        String recipient = employee.email();
        return new GreetingMessage(recipient, greeting);
    }

    public String subject() {
        return this.greeting.header();
    }

    public String text() {
        return this.greeting.content();
    }

    public String to() {
        return this.to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GreetingMessage)) return false;
        GreetingMessage that = (GreetingMessage) o;
        return Objects.equals(to, that.to) && Objects.equals(greeting, that.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, greeting);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GreetingMessage.class.getSimpleName() + "[", "]")
                .add("to='" + to + "'")
                .add("greeting=" + greeting)
                .toString();
    }
}
