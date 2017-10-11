/**
 * 
 */
package com.wrkspot.ruleengine.service;

import com.wrkspot.ruleengine.model.PaymentDetail;
import com.wrkspot.ruleengine.model.TimeSheet;

/**
 * @author abhinab
 *
 */
public interface PaymentCalculationService {

	PaymentDetail calculateFare(TimeSheet timeSheet, PaymentDetail paymentDetail);

}
