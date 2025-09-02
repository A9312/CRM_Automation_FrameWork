package generic_utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverUtility {

	WebDriver driver;
	Actions act;

	public WebdriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	public void Hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void Hover(WebElement element, int x, int y) {
		act.moveToElement(element, x, y).build().perform();
	}

	public void Hover(int x, int y) {
		act.moveByOffset(x, y).build().perform();
	}

	public void Click() {
		act.click().build().perform();
	}

	public void Click(WebElement element) {
		act.click(element).build().perform();
	}

	public void RightClick() {
		act.contextClick().build().perform();
	}

	public void RightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void DoubleClick() {
		act.doubleClick().build().perform();
	}

	public void DoubleClick(WebElement element) {
		act.doubleClick(element).build().perform();
	}

	public void ClickAndHold() {
		act.clickAndHold().build().perform();
	}

	public void ClickAndHold(WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void DragAndDrop(WebElement element1, WebElement element2) {
		act.dragAndDrop(element1, element2).build().perform();
	}

	public void DragAndDrop(WebElement element, int x, int y) {
		act.dragAndDropBy(element, x, y).build().perform();
	}

	public void Release() {
		act.release().build().perform();
	}

	public void Release(WebElement element) {
		act.release(element).build().perform();
	}

	public void KeyboardActions(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void keyDownAction(Keys key) {
		act.keyDown(key).build().perform();
	}

	public void keyUpAction(Keys key) {
		act.keyUp(key).build().perform();
	}

	public void Scrolling(int x, int y) {
		act.scrollByAmount(x, y).build().perform();
	}

	public void Scrolling(WebElement element) {
		act.scrollToElement(element).build().perform();
	}
}