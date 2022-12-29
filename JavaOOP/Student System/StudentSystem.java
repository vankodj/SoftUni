package studentSystem;


import java.util.HashMap;
import java.util.Map;


public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {
          String command = args[0];

        switch (command) {
            case "Create":
                String name = args[1];
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                if (!repo.containsKey(name)) {
                    Student student = new Student(name, age, grade);
                    repo.put(name, student);
                }
                break;
            case "Show":
                name = args[1];
                if (repo.containsKey(name)) {
                    Student student = repo.get(name);
                    String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                    if (student.getGrade() >= 5.00) {
                        view += " Excellent student.";
                    } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                        view += " Average student.";
                    } else {
                        view += " Very nice person.";
                    }

                    System.out.println(view);
                }
                break;
        }
    }
}
