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
}
