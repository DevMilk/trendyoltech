
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    private static StackClass stack;

    @BeforeEach
    public void setup(){
        //Given
        stack = new StackClass(8);
    }

    @Test
    public void return_5_if_count_is_true(){

        //Given
        int count = 5;

        //Act
        for(int i = 0; i<count;i++){
            stack.push(i);
        }

        //Assert
        assertEquals(stack.count(),count);
    }

    @Test
    public void size_of_stack_should_be_0_at_start(){
        //Assert
        assertEquals(stack.count(),0);
    }

    @Test
    public void counter_should_increment_when_data_pushed(){

        //Act
        int before = stack.count();
        stack.push(1);
        int after = stack.count();

        //Assert
        assertEquals(before+1,after);
    }

    @Test
    public void it_should_return_top_when_peeked(){

        //Act
        stack.push(5);
        stack.push(3);

        //Assert
        assertEquals(3,stack.peek());
    }

    @Test
    public void it_should_return_and_remove_top_when_popped(){

        //Act
        stack.push(5);
        stack.push(3);
        int top = stack.pop();

        //Assert
        assertEquals(top,3);
        assertEquals(1,stack.count());

    }

    @Test
    public void it_should_throw_NullPointerException_when_popped_empty_stack(){
        //Assert
        Exception exception = assertThrows(NullPointerException.class, () -> stack.pop());
        assertEquals("Stack Is Empty",exception.getMessage());
    }

    @Test
    public void it_should_throw_IndexOutOfBoundsException_when_pushed_at_its_limit(){

        //Act
        for(int i=0;i<8;i++){
            stack.push(i);
        }

        //Assert
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.push(8));
        assertEquals("Stack Capacity Reached",exception.getMessage());

    }

}
