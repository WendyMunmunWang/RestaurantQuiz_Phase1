package ca.ubc.cs.cpsc210.quiz.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {



    @Test
    //the equality of two Category objects
    // must be based on the category name and alias
    public void testEquals() throws Exception {
        Category cg1 = new Category("India", "indie");
        Category cg2 = new Category("Chinese","ching");
        Category cg3 = new Category("India", "indie");
        assertFalse(cg1.equals(cg2));
        assertTrue(cg1.equals(cg3));


    }
}