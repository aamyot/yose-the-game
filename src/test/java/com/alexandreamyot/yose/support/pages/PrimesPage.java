package com.alexandreamyot.yose.support.pages;

import static com.alexandreamyot.yose.support.Browser.element;
import static com.alexandreamyot.yose.support.Browser.input;
import static com.alexandreamyot.yose.support.Browser.navigateTo;
import static java.util.stream.IntStream.range;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PrimesPage {

    public PrimesPage go() {
        navigateTo("http://localhost:7001/primeFactors/ui");
        return this;
    }


    public PrimesPage number(String number) {
        input(id("number"), number);
        return this;
    }

    public PrimesPage submit() {
        element(id("go")).click();
        return this;
    }

    public String number() {
        return element(id("number")).getAttribute("value");
    }

    public void hasResult(String result) {
        assertThat(element(id("result")).getText(), equalTo(result));
    }

    public void hasResults(String... results) {
        range(0, results.length).forEach(n -> assertThat(result(n + 1), equalTo(results[n])));
    }

    private String result(int n) {
        return element(id("results")).findElement(xpath("li[" + n + "]")).getText();
    }

    public void hasLastResult(String result) {
        assertThat(element(id("last-decomposition")).getText(), equalTo(result));
    }
}
