package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    @FindBy(id = "email")
    public WebElement inputMail;
    @FindBy(id = "senha")
    public WebElement inputSenha;
    @FindBy(id = "mensagem")
    public WebElement mensagemRetorno;
    @FindBy(id="btn-entrar")
    public WebElement enter;

    public LoginPO(WebDriver chrome){
        super(chrome);
    }
}
