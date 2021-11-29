package com.jumia.validator;

import com.google.common.primitives.Chars;
import com.jumia.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void validatePhoneNumber(String phoneNumber, Customer customerWithMoreDetails) {
        validatePhoneLength(phoneNumber, customerWithMoreDetails);
        validateFirstNumberAfterCountryCode(customerWithMoreDetails, phoneNumber);
        validateNumeric(phoneNumber, customerWithMoreDetails);
    }

    private void validatePhoneLength(String phoneNumber, Customer customerWithMoreDetails) {
        if ((phoneNumber.startsWith("(237)") || phoneNumber.startsWith("(258)"))
                && phoneNumber.toCharArray().length != 14 && phoneNumber.toCharArray().length != 15) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("The length for phone number is not valid '" + phoneNumber + "'.");
        } else if (phoneNumber.toCharArray().length != 15) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("The length for phone number is not valid '" + phoneNumber + "'.");
        } else {
            customerWithMoreDetails.setStatus("Valid");
        }
    }

    private void validateNumeric(String phoneNumber, Customer customerWithMoreDetails) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("Phone number is empty.");
        } else {
            char[] phone = phoneNumber.toCharArray();
            char[] phoneAfterFormat = new char[phone.length + 1];
            phoneAfterFormat[0] = '+';
            int j = 1;
            for (int i = 0; i < phone.length; i++) {
                if (phone[i] == '(' || phone[i] == ')' || phone[i] == ' ') {
                    continue;
                }
                if (!Character.isDigit(phone[i])) {
                    customerWithMoreDetails.setStatus("Not Valid");
                    logger.warn("Phone number is not number '" + phoneNumber + "'.");
                }
                if (j == 4 || j == 8 || j == 12) {
                    phoneAfterFormat[j] = '-';
                    phoneAfterFormat[j + 1] = phone[i];
                    j = j + 2;
                } else {
                    phoneAfterFormat[j] = phone[i];
                    j++;
                }
                continue;
            }
            customerWithMoreDetails.setPhone(String.valueOf(phoneAfterFormat));
        }
    }

    private void validateFirstNumberAfterCountryCode(Customer customerWithMoreDetails, String phoneNumber) {
        char[] cameroonNumber = {'2', '3', '6', '8'};
        char[] ethiopiaNumber = {'2', '3', '4', '5', '9'};
        char[] moroccoNumber = {'5', '6', '7', '8', '9'};
        char[] mozambiqueNumber = {'2', '8'};
        char[] phone = phoneNumber.toCharArray();
        if (phoneNumber.startsWith("(237)") && !Chars.contains(cameroonNumber, phone[6])) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("Phone number is not number '" + phoneNumber + "'.");
        } else if (phoneNumber.startsWith("(251)") && !Chars.contains(ethiopiaNumber, phone[6])) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("Phone number is not number '" + phoneNumber + "'.");
        } else if (phoneNumber.startsWith("(212)") && !Chars.contains(moroccoNumber, phone[6])) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("Phone number is not number '" + phoneNumber + "'.");
        } else if (phoneNumber.startsWith("(258)") && !Chars.contains(mozambiqueNumber, phone[6])) {
            customerWithMoreDetails.setStatus("Not Valid");
            logger.warn("Phone number is not number '" + phoneNumber + "'.");
        }
    }
}