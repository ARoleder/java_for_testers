package manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        if (file != null) {
            manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
        }
    }

    protected void click(By submit) {
        manager.driver.findElement(submit).click();
    }
}
