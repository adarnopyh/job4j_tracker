package ru.job4j.tracker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputOneInt() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenValidInputMultiCount() {
        Output output = new StubOutput();
        String[] arr = new String[]{"2", "3", "-4"};
        Input in = new MockInput(arr);
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(Integer.parseInt("2"));
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(Integer.parseInt("3"));
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(Integer.parseInt("-4"));
    }

    @Test
    void whenValidInputOneNegativeInt() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }
}