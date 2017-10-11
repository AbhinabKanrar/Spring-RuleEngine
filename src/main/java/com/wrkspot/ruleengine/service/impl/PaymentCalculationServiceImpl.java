/**
 * 
 */
package com.wrkspot.ruleengine.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrkspot.ruleengine.model.PaymentDetail;
import com.wrkspot.ruleengine.model.TimeSheet;
import com.wrkspot.ruleengine.service.PaymentCalculationService;

/**
 * @author abhinab
 *
 */
@Service
public class PaymentCalculationServiceImpl implements PaymentCalculationService {

	@Autowired
	private KieContainer kieContainer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrkspot.ruleengine.service.PaymentCalculationService#calculateFare(
	 * com.wrkspot.ruleengine.model.TimeSheet,
	 * com.wrkspot.ruleengine.model.PaymentDetail)
	 */
	@Override
	public PaymentDetail calculateFare(TimeSheet timeSheet, PaymentDetail paymentDetail) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("payment", paymentDetail);
		kieSession.insert(timeSheet);
		kieSession.fireAllRules();
		kieSession.dispose();

		paymentDetail.setTotalPay((float) ((paymentDetail.getNormalTime() * paymentDetail.getBasePay())
				+ (paymentDetail.getFirstGradeOverTime() * (paymentDetail.getBasePay() * 1.1))
				+ (paymentDetail.getSecondGradeOverTime() * (paymentDetail.getBasePay() * 1.2))));
		return paymentDetail;
	}

}
