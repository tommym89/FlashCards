/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcneelat.flashcards;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmcne003
 */
public class FXMLControllerTest {

    public FXMLControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadFlashcards() {
        System.out.println("Testing loadFlashcards method...");
        FXMLController controller = new FXMLController();
        controller.testLoadFlashcards(new File("D:\\tmcne003\\Documents\\NetBeansProjects\\FlashCards\\issep.json"));
        for (String[] card : controller.getCardsList()) {
            System.out.println("Question: " + card[0]);
            System.out.println("Answer: " + card[1]);
            System.out.println();
        }
        assertEquals(2l, (long) controller.getCardsList().size());
    }

    /**
     * Test of initialize method, of class FXMLController.
     */
    /*
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLController instance = new FXMLController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
