package br.com.bruno;

import org.junit.jupiter.api.*;

@Order(2)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FooIntegrationTest {

    StringBuilder sb = new StringBuilder();

    @AfterEach
    void afterEach() {
        System.out.println(sb);
    }

    @Test
    @Order(3)
    void testC() {
        sb.append("3");
    }

    @Test
    @Order(1)
    void testA() {
        sb.append("1");
    }

    @Test
    @Order(4)
    void testD() {
        sb.append("4");
    }

    @Test
    @Order(2)
    void testB() {
        sb.append("2");
    }

}
