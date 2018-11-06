import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class Classroom {
    private Collection<Student> students;
    private double avg = 0;
    double total = 0;
    public Classroom() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addScoreById(String id, double score) throws NoSuchElementException{
        if (score > 0) {
            for (Student s : students) {
                if (s.getId().equals(id)) {
                    s.addScore(score);
                    total += score;
                }
            }
        } else {
            throw new IllegalArgumentException("Score must be positive");
        }
    }

    public double getScoreById(String id) {
        double score = 0;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                score = s.getScore();
            } else {
                throw new NoSuchElementException("Not found ID");
            }
        }
        return score;
    }

    public double averageScore() {
        double sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return sum/students.size();
    }

    public double totalScore() {
        double sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return sum;
    }

    public int size() {
        return students.size();
    }

}
