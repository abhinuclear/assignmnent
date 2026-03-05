package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before()
    public void setUpTest() {
        setup();
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}