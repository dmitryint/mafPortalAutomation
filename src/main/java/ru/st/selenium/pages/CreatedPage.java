package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.News;
import ru.st.selenium.model.PageItem;

import static org.testng.Assert.assertEquals;

public class CreatedPage extends InternalPage{
    public CreatedPage(PageManager pages) {
        super(pages);
    }

    private final String PAGE_TITLE_LOCATOR = "//h1[@class = 'title_name']";
    private final String PAGE_TEXT_LOCATOR = "//div[@class = 'contWr']/p";

    public void checkDataOnNewPage(PageItem newPage, String language) {
        if (language.equalsIgnoreCase("rus")) {
            assertEquals(driver.findElement(By.xpath(PAGE_TITLE_LOCATOR)).getText(), newPage.getRusPageTitle());
            //assertEquals(driver.findElement(By.xpath(PAGE_TEXT_LOCATOR)).getText(), newPage.getRusContent());

        } else if (language.equalsIgnoreCase("eng")) {
            assertEquals(driver.findElement(By.xpath(PAGE_TITLE_LOCATOR)).getText(), newPage.getPageTitle());
            //assertEquals(driver.findElement(By.xpath(PAGE_TEXT_LOCATOR)).getText(), newPage.getContent());
        }
    }
}
