package com.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest {
    @Test
    public void test_val1() {
        assertThat(Example.val1).isEqualTo(342);
    }

    @Test
    public void test_val2() {
        assertThat(Example.val2).isEqualTo(23);
    }

    @Test
    public void test_truthy() {
        assertThat(Example.truthy).isTrue();
    }

    @Test
    public void test_falsy() {
        assertThat(Example.falsy).isFalse();
    }

    @Test
    public void test_char_value() {
        assertThat(Example.c).isEqualTo('\n');
    }

    @Test
    public void test_falsy_again() {
        assertThat(Example.falsyAgain).isFalse();
    }

    @Test
    public void test_falsy_ref() {
        assertThat(Example.falsyRef).isFalse();
    }

    @Test
    public void test_unit_value() {
        assertThat(Example.u).isNull();
    }

    @Test
    public void test_string_value() {
        assertThat(Example.s).isEqualTo("Hello, \nWorld!");
    }

    @Test
    public void test_ternary_operator_precedence() {
        // let b = if 1 + 1 == 2 then if 3 + 3 == 6 then 5 else 2 else true || false

//        boolean b = 1 + 1 == 2 + 2 ? 3 + 3 == 4 + 4 ? 5 + 5 : 6 + 6 : true ? false : false || true;
    }
}
