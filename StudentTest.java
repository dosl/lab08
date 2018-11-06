

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest { // TDD: Test-Driven Development ออกแบบการทดสอบก่อน แล้วจึงพัฒนาโค้ดหรือแก้ไขโค้ด

    private Student student;
    private static double aScore;

    @BeforeAll // ทำครั้งเดียว และต้องเป็น static method
    static void setup() {
        aScore = 45.6;
    }

    @BeforeEach // ทำทุกครั้งก่อนทุก test method
    void init() {
        student = new Student("Mickey", "6010459999");
    }

    @Test
    @Tag("getName")
    @DisplayName("เรียกชื่อจาก Super")
    void getName_ShouldReturnNameFromSuperClassPerson_WhenCall() {
        assertEquals("Mickey", student.getName());
    }

    @Test
    @Tag("setName")
    @DisplayName("เปลี่ยนชื่อได้")
    void setName_ShouldChangeName_WhenReceiveNewString() {
        student.setName("Martin");
        assertEquals("Martin", student.getName());
    }

    @Test
    @Tag("addScore")
    @DisplayName("เพิ่มคะแนนบวก")
    void addScore_ShouldIncreaseScore_WhenReceivePositiveNumber() {
        student.addScore(aScore);
        assertEquals(aScore, student.getScore());
        student.addScore(30.5);
        assertEquals(aScore + 30.5, student.getScore());
    }

    @Test
    @Tag("addScore")
    @DisplayName("เพิ่มคะแนนลบแล้วเกิด exception")
    void addScore_ShouldThrowIllegalArgumentException_WhenReceiveNegativeNumber() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> student.addScore(-45.39));
        assertEquals("Score must be positive", exception.getMessage());
    }

    @Test
    @Tag("addScore")
    @DisplayName("เพิ่มคะแนนลบไม่ได้")
    void addScore_ShouldNotIncreaseScore_WhenReceiveNegativeNumber() {
        try {
            aScore += 10;
            student.addScore(-35.9);
        } catch (IllegalArgumentException ignored) {

        }
        assertEquals(0, student.getScore());
        student.addScore(aScore);
        try {
            student.addScore(-32.1);
        } catch (IllegalArgumentException ignored) {

        }
        assertEquals(aScore, student.getScore());
    }
}