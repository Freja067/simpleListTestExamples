package ut.ex;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleListSteps {

    private SimpleList<String> list;
    private Exception caughtException;

    @Given("an empty SimpleList")
    public void anEmptySimpleList() {
        list = new SimpleList<>();
        caughtException = null;
    }

    @When("I add null")
    public void iAddNull() {
        list.add(null);
    }

    @When("I add {string}")
    public void iAdd(String element) {
        list.add(element);
    }

    @When("I clear the list")
    public void iClearTheList() {
        list.clear();
    }

    @When("I add the following elements:")
    public void iAddTheFollowingElements(io.cucumber.datatable.DataTable dataTable) {
        for (String value : dataTable.asList()) {
            list.add("null".equals(value) ? null : value);
        }
    }

    @When("I remove element at index {int}")
    public void iRemoveElementAtIndex(int index) {
        list.remove(index);
    }


    @Then("the element at index {int} should be null")
    public void theElementAtIndexShouldBeNull(int index) {
    assertNull(list.get(index));
    }

    @Then("the list size should be {int}")
    public void theListSizeShouldBe(int expectedSize) {
        assertEquals(expectedSize, list.size());
    }

    @Then("the element at index {int} should be {string}")
    public void theElementAtIndexShouldBe(int index, String expected) {
        String actual = list.get(index);
        if ("null".equals(expected)) {
            assertNull(actual);
        } else {
            assertEquals(expected, actual);
        }
    }

    @Then("getting element at index {int} should throw an IndexOutOfBoundsException")
    public void gettingShouldThrow(int index) {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @Then("removing element at index {int} should throw an IndexOutOfBoundsException")
    public void removingShouldThrow(int index) {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(index));
    }
}
