import org.junit.jupiter.api.*;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {
    private Student student;
    private Classroom classroom;
    private static double aScore;


    @BeforeAll
    static void setup() {
        aScore = 45.6;
    }
    @BeforeEach
    void init() {
        student = new Student("Mickey", "6010459999");
        classroom = new Classroom();
        classroom.addStudent(student);

    }

    @Test
    @Tag("addStudent")
    void addStudent_ShouldIncreaseSizeArray(){
        assertEquals(1,classroom.size());
    }

    @Test
    @Tag("addScoreById")
    void addScoreById_ShouldIncreaseScoreByID(){
        classroom.addScoreById("6010459999",aScore);
        assertEquals(aScore,classroom.getScoreById("6010459999"));
    }

    @Test
    @Tag("addScoreById")
    void addScoreById_ShouldThrowException_WhenNotFoundID(){
        try {
            classroom.addScoreById("55",aScore);
        } catch (NoSuchElementException ignored){

        }
    }

    @Test
    @Tag("addScoreById")
    void addScoreById_ShouldThrowException_WhenScoreIsNegative(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> classroom.addScoreById("55",-5));
        assertEquals("Score must be positive", exception.getMessage());
    }
    @Test
    @Tag("getScoreById")
    void getScoreById_ShouldReturnScore(){
        classroom.addScoreById("6010459999",aScore);
        assertEquals(aScore,classroom.getScoreById("6010459999"));
    }

    @Test
    @Tag("getScoreById")
    void getScoreById_ShouldThrowException_WhenNotFoundID(){
        Throwable exception = assertThrows(NoSuchElementException.class, () -> classroom.getScoreById("55"));
        assertEquals("Not found ID", exception.getMessage());
    }
    @Test
    @Tag("averageScore")
    void averageScore_ShouldReturnAverageScore(){

        Student s2 = new Student("John","6010451111");
        classroom.addStudent(s2);
        classroom.addScoreById("6010459999",1);
        classroom.addScoreById("6010451111",3);
        assertEquals(2,classroom.averageScore());
    }
    @Test
    @Tag("totalScore")
    void totalScore_ShouldReturnTotal(){
        Student s2 = new Student("John","6010451111");
        classroom.addStudent(s2);
        classroom.addScoreById("6010459999",1);
        classroom.addScoreById("6010451111",3);
        assertEquals(4,classroom.totalScore());
    }

}