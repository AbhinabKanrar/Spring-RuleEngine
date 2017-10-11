package com.wrkspot.ruleengine;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wrkspot.ruleengine.model.PaymentDetail;
import com.wrkspot.ruleengine.model.TimeSheet;
import com.wrkspot.ruleengine.service.PaymentCalculationService;

/**
 * @author abhinab
 *
 */
@SpringBootApplication
public class SpringRuleEngineApplication implements CommandLineRunner {

	public static final String drlFile = "time-cal-rule.drl";

	@Autowired
	private PaymentCalculationService paymentCalculationService;

	@Bean
	public KieContainer kieContainer() {
		KieServices kieServices = KieServices.Factory.get();

		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();

		return kieServices.newKieContainer(kieModule.getReleaseId());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRuleEngineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TimeSheet timeSheet = new TimeSheet((float) 10);
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setBasePay((float) 14);
		System.out.println("val : " + paymentCalculationService.calculateFare(timeSheet, paymentDetail).toString());
	}

}
