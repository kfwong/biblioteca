package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemTest {

    Item item = new Item("item1") {
        @Override
        public String displayFormat() {
            return null;
        }
    };

    @Test
    public void should_instantiate_valid_item_instance(){

        assertNotNull(item);

    }

    @Test
    public void should_be_able_to_read_title_field(){

        assertEquals("item1", item.title);
    }
}
