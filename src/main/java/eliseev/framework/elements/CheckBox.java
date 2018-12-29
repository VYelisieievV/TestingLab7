package eliseev.framework.elements;

import org.openqa.selenium.WebElement;


public class CheckBox extends Element {
    public CheckBox(WebElement element){
        super(element);
    }
    public void Select(){
        if(!super.isSelected())
            super.getElement().click();
    }
    public void deSelect(){
        if(super.isSelected())
            super.getElement().click();

    }
    @Override
    public void sendKeys(CharSequence... charSequences) {return;}
    @Override
    public void submit(){return;}
}