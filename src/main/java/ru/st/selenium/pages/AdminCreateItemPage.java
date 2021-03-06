package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public abstract class AdminCreateItemPage extends AdminInternalPage {
    public AdminCreateItemPage(PageManager pages) {
        super(pages);
    }



    private ArrayList<String> chosenCheckboxes = new ArrayList<String>();

    private final String ADD_FILE_BUTTON_LOCATOR = "//input[@id = 'uploadImage']";
    private final String SUBMIT_BUTTON_LOCATOR = "//button[@type = 'submit']";
    private final String CANCEL_BUTTON_LOCATOR = "//div[@id = 'saveActions']//a[@class = 'btn btn-default']";
    protected final String TEXT_FRAME_LOCATOR = "//iframe[1]";

    protected final String PAGE_NAME_FIELD_LOCATOR = "//input[@name = 'name']";
    protected final String TITLE_FIELD_LOCATOR = "//input[@name = 'title']";
    protected final String SLUG_FIELD_LOCATOR = "//input[@name = 'slug']";
    protected final String DATE_FIELD_LOCATOR = "//input[@id = 'input_calendar']";
    protected final String DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'description']";
    protected final String META_TITLE_FIELD_LOCATOR = "//input[@name = 'meta_title_en']";
    protected final String SOCIAL_META_TITLE_FIELD_LOCATOR = "//input[@name = 'social_meta_title_en']";
    protected final String META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'meta_description_en']";
    protected final String SOCIAL_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'social_meta_description_en']";
    protected final String META_KEYWORDS_LOCATOR = "//textarea[@name = 'meta_keywords_en']";

    protected final String RUS_TITLE_FIELD_LOCATOR = "//input[@name = 'title_ru']";
    protected final String RUS_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'description_ru']";
    protected final String RUS_META_TITLE_FIELD_LOCATOR = "//input[@name = 'meta_title_ru']";
    protected final String RUS_SOCIAL_META_TITLE_FIELD_LOCATOR = "//input[@name = 'social_meta_title_ru']";
    protected final String RUS_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'meta_description_ru']";
    protected final String RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'social_meta_description_ru']";
    protected final String RUS_META_KEYWORDS_LOCATOR = "//textarea[@name = 'meta_keywords_ru']";
    protected final String RUS_TAB_LOCATOR = "//a[@aria-controls = 'tab_rus']";

    protected String imageDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\test.png";


    @FindBy(xpath = ADD_FILE_BUTTON_LOCATOR)
    WebElement addFileButton;

    @FindBy(xpath = SUBMIT_BUTTON_LOCATOR)
    WebElement submitButton;

    @FindBy(xpath = CANCEL_BUTTON_LOCATOR)
    WebElement cancelButton;

    @FindBy(xpath = TEXT_FRAME_LOCATOR)
    WebElement textFrame;

    public void addFile(String path) {
        wait.until(presenceOfElementLocated(By.xpath(ADD_FILE_BUTTON_LOCATOR)));
        driver.findElement(By.xpath(ADD_FILE_BUTTON_LOCATOR)).sendKeys(path);
        log("File " + path + " was added");
        //addFileButton.click();
        //addFileButton.sendKeys();
    }

    public void ensureFileAdded() {
        wait.until(presenceOfElementLocated(By.xpath("//div[@class = 'cropper-container cropper-bg']")));
        log("File was added succsessfully");
    }

    public void pressSubmitButton() {
        log("Trying to click submit button");
        submitButton.click();
        log("Submit button was clicked");
    }

    public void pressCancelButton() {
        log("Trying to click cancel button");
        cancelButton.click();
        log("Cancel button was clicked");
    }

    public void typeTextToTextField(String text) {
        driver.switchTo().frame(textFrame);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("document.getElementsByTagName('g').innerHTML = 'Sample text'");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }

    public void chooseRandomDateInNextMonth() {
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).click();
        driver.findElement(By.xpath("//span[@title = 'Next Month']")).click();
        Random random = new Random();
        int randomNumber = random.nextInt(30) + 1;
        System.out.println("Random number is " + randomNumber);
        driver.findElement(By.xpath("//table[@class = 'table-condensed']//tbody//td[contains(text(), '"+randomNumber+"')]")).click();
    }

    public void clickRusTab() {
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
    }

    public void fillAllFieldsWithData(Object obj) {

    }

    public void putThreeRandomCheckboxes() {
        List<WebElement> clubs = driver.findElements(By.xpath("//div[@class = 'checkbox']"));
        Random randomGenerator = new Random();
        int index1;
        int index2;
        int index3;
        index1 = randomGenerator.nextInt(clubs.size()-1)+1;
        while (true) {
            index2 = randomGenerator.nextInt(clubs.size()-1)+1;
            if (index2 != index1) break;
        }
        while (true) {
            index3 = randomGenerator.nextInt(clubs.size()-1)+1;
            if (index3 != index1 && index3 != index2) break;
        }

        String club1 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index1+1) +"]//label")).getText();
        chosenCheckboxes.add(club1);
        String club2 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index2+1) +"]//label")).getText();
        chosenCheckboxes.add(club2);
        String club3 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index3+1) +"]//label")).getText();
        chosenCheckboxes.add(club3);
        String checkbox1 = "//div[@class = 'col-sm-4']["+ (index1+1) +"]//label/input";
        String checkbox2 = "//div[@class = 'col-sm-4']["+ (index2+1) +"]//label/input";
        String checkbox3 = "//div[@class = 'col-sm-4']["+ (index3+1) +"]//label/input";
        clubs.get(index1).findElement(By.xpath(checkbox1)).click();
        clubs.get(index2).findElement(By.xpath(checkbox2)).click();
        clubs.get(index3).findElement(By.xpath(checkbox3)).click();
    }

    public ArrayList<String> getChosenCheckboxes() {
        return chosenCheckboxes;
    }

    public boolean isCheckboxInTheList(String checkbox) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(., '"+checkbox+"')]")));
            return true;
        }catch (Exception e) {
            return false;
        }

    }


}

