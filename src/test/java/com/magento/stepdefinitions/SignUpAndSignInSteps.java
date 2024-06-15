package com.magento.stepdefinitions;

import com.magento.automation.HomePage;
import com.magento.automation.MyAccountPage;
import com.magento.automation.SignInPage;
import com.magento.automation.SignUpPage;
import com.magento.utils.WebUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpAndSignInSteps {
    private WebUtil webUtil;
    private SignUpPage signUpPage;
    private MyAccountPage myAcPage;
    private HomePage hm;
    private String userName;
    private SignInPage signInPage;
    private static String email=null;

    public SignUpAndSignInSteps(WebUtil webUtil) {
        this.webUtil = webUtil;
    }

    @Given("^the user is on the sign-up page$")
    public void the_user_is_on_the_sign_up_page() {
        System.out.println("User is on the sign-up page");
        hm = new HomePage(webUtil);
        if (hm == null) {
            throw new IllegalStateException("HomePage instance is not initialized.");
        }
        hm.openSignUpPage();
    }

    @When("^the user enters valid details$")
    public void the_user_enters_valid_details() {
        signUpPage = new SignUpPage(webUtil);
       String name= webUtil.getRandomName(3);
       email = "patel"+name+"@gmail.com";
       String  userName = email;
        signUpPage.enterDetails("virendra", "man", userName, "Password@123");
    }

    @And("^submits the sign-up form$")
    public void submits_the_sign_up_form() {
        signUpPage = new SignUpPage(webUtil);
        signUpPage.scrollToSubmitButton();
        webUtil.onHold(5);
        signUpPage.createAccountButton();
    } 

    @Then("^the user should be signed up successfully$")
    public void the_user_should_be_signed_up_successfully() {
        myAcPage = new MyAccountPage(webUtil);
        myAcPage.verifyAccountCreated();
        webUtil.onHold(3);
        myAcPage.signOut();
        webUtil.onHold(3);
    }

    @And("^the user is on the sign-in page$")
    public void the_user_is_on_the_sign_in_page() {
        System.out.println("User is on the sign-in page");
        hm = new HomePage(webUtil);
        if (hm == null) {
            throw new IllegalStateException("HomePage instance is not initialized.");
        }
        webUtil.onHold(5);
        hm.openSignInPage();
       
    }

    @When("^the user enters valid credentials$")
    public void the_user_enters_valid_credentials() {
        webUtil.onHold(5);
        String userName = email;
        signInPage = new SignInPage(webUtil);
        signInPage.signIn(userName);
 
    }

    @And("^submits the sign-in form$")
    public void submits_the_sign_in_form() {
        signInPage = new SignInPage(webUtil);
        webUtil.onHold(3);
        signInPage.submitSignBtn();
       

    }

    @Then("^the user should be signed in successfully$")
    public void the_user_should_be_signed_in_successfully() {
        signInPage = new SignInPage(webUtil);
        signInPage.verifyRegisteredCustomers();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
