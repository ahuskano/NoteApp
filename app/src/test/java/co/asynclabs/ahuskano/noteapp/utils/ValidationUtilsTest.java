package co.asynclabs.ahuskano.noteapp.utils;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidationUtilsTest {

    @Mock
    private EditText editText;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isNullOrEmpty() {
        assertThat(ValidationUtils.isNullOrEmpty(""), is(true));
        assertThat(ValidationUtils.isNullOrEmpty("a"), is(false));
    }

    @Test
    public void isNullOrEmpty1() {

    }
}