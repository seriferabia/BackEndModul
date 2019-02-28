//package at.nacs.creditcard.model;
//
//import at.nacs.creditcard.controller.Credit;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CreditTest {
//    private Credit credit = new Credit();
//
//    @Test
//    void testInvalidNumber() {
//        String expected = "INVALIDDD";
//        Long cardNumber = Long.parseLong("5105105105105");
//        String result = credit.checkCard(cardNumber);
//        Assertions.assertEquals(expected,result);
//
//    }
//    @Test
//    void testAmericanExpress() {
//        String expected = "American Express";
//        Long cardNumber = Long.parseLong("371449635398431");
//        String result = credit.checkCard(cardNumber);
//        Assertions.assertEquals(expected,result);
//
//    }
//    @Test
//    void testMasterCard() {
//        String expected = "Master Card";
//        Long cardNumber = Long.parseLong("5555555555554444");
//        String result = credit.checkCard(cardNumber);
//        Assertions.assertEquals(expected,result);
//
//    }
//    @Test
//    void testVisa() {
//        String expected = "Visa";
//        Long cardNumber = Long.parseLong("4012888888881881");
//        String result = credit.checkCard(cardNumber);
//        Assertions.assertEquals(expected,result);
//
//    }
//    @Test
//    void testValidButNotInList() {
//        String expected = "INVALID";
//        Long cardNumber = Long.parseLong("6011000990139424");
//        String result = credit.checkCard(cardNumber);
//        Assertions.assertEquals(expected,result);
//
//    }
//}