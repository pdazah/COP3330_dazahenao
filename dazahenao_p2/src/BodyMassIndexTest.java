import org.junit.jupiter.api.Assertions;

class BodyMassIndexTest {
    private final BodyMassIndex A_TEST = new BodyMassIndex(67,178);
    @org.junit.jupiter.api.Test
    void bmiScoreCalc() {
        Assertions.assertEquals(A_TEST.bmiScoreCalc(),27.9);
    }


    @org.junit.jupiter.api.Test
    void bmiCategory() {

    }
}