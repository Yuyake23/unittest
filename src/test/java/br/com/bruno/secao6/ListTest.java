package br.com.bruno.secao6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        // When / Act & Then / Assert
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnCrocodile() {
        // Given / Arrange
        List<String> list = mock(String.valueOf(List.class));
        when(list.get(0)).thenReturn("Crocodile");

        // When / Act & Then / Assert
        assertEquals("Crocodile", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnCrocodile() {
        // Given / Arrange
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Crocodile");

        // When / Act & Then / Assert
        assertEquals("Crocodile", list.get(0));
        assertEquals("Crocodile", list.get(1));
    }

    @Test
    void testMockingList_When_ThrowAnException() {
        // Given / Arrange
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException());

        // When / Act & Then / Assert
        assertThrows(RuntimeException.class, () -> list.get(0));
    }

}
