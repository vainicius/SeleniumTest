package BaseTest;

import PO.LoginPO;
import Rota.Rota;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Keys;

public class LoginTest extends Rota {

    public static LoginPO loginPage;

    String mensagem01 = "Informe usuário e senha, os campos não podem ser brancos.";
    String mensagem02 = "E-mail ou senha inválidos";


    @BeforeClass
    public static void paginaInit(){
        loginPage = new LoginPO(chrome);
    }

    @Test
    public void TesteCT01(){

        loginPage.inputMail.sendKeys("admin@admin.com");
        loginPage.inputSenha.clear();
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem01));
    }
    @Test
    public void TesteCT02(){
        loginPage.inputMail.clear();
        loginPage.inputSenha.clear();
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem01));
    }
    @Test
    public void TesteCT03(){
        loginPage.inputMail.clear();
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem01));
    }
    @Test
    public void TesteCT04(){
        loginPage.inputMail.sendKeys("admin@admin.com");
        loginPage.inputSenha.sendKeys("senhaerrada");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem02));
    }
    @Test
    public void TesteCT05(){
        loginPage.inputMail.sendKeys("emailerrado@admin.com");
        loginPage.inputSenha.sendKeys("senhaerrada");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem02));
    }
    @Test
    public void TesteCT06(){
        loginPage.inputMail.sendKeys("emailerrado@admin.com");
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem02));
    }
    @Test
    public void TesteCT07(){
        loginPage.inputMail.sendKeys("admin@admin.com");
        loginPage.inputSenha.sendKeys("senhaerrada");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem02));
    }
    @Test
    public void TesteCT08(){
        loginPage.inputMail.clear();
        loginPage.inputSenha.sendKeys("senhaerrada");
        loginPage.enter.click();
        String dado = loginPage.mensagemRetorno.getText();
        Assert.assertTrue(dado.contains(mensagem01));
    }
    @Test
    public void TesteCT09(){
        loginPage.inputMail.clear();
        loginPage.inputSenha.clear();
        loginPage.inputMail.sendKeys("admin@admin.com");
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.enter.click();
        String dado = loginPage.chrome.getTitle();
        Assert.assertTrue(dado.contains("Controle de Produtos"));
    }

}
