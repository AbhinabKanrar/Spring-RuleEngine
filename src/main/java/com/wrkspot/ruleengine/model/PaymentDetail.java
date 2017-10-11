/**
 * 
 */
package com.wrkspot.ruleengine.model;

/**
 * @author abhinab
 *
 */
public class PaymentDetail {

	private Float totalPay;
	private Float basePay;
	private Float normalTime;
	private Float firstGradeOverTime;
	private Float secondGradeOverTime;

	public PaymentDetail() {

	}

	public PaymentDetail(Float totalPay, Float basePay, Float normalTime, Float firstGradeOverTime,
			Float secondGradeOverTime) {
		this.totalPay = totalPay;
		this.basePay = basePay;
		this.normalTime = normalTime;
		this.firstGradeOverTime = firstGradeOverTime;
		this.secondGradeOverTime = secondGradeOverTime;
	}

	public Float getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}

	public Float getBasePay() {
		return basePay;
	}

	public void setBasePay(Float basePay) {
		this.basePay = basePay;
	}

	public Float getNormalTime() {
		return normalTime;
	}

	public void setNormalTime(Float normalTime) {
		this.normalTime = normalTime;
	}

	public Float getFirstGradeOverTime() {
		return firstGradeOverTime;
	}

	public void setFirstGradeOverTime(Float firstGradeOverTime) {
		this.firstGradeOverTime = firstGradeOverTime;
	}

	public Float getSecondGradeOverTime() {
		return secondGradeOverTime;
	}

	public void setSecondGradeOverTime(Float secondGradeOverTime) {
		this.secondGradeOverTime = secondGradeOverTime;
	}

	@Override
	public String toString() {
		return "PaymentDetail [totalPay=" + totalPay + ", basePay=" + basePay + ", normalTime=" + normalTime
				+ ", firstGradeOverTime=" + firstGradeOverTime + ", secondGradeOverTime=" + secondGradeOverTime + "]";
	}

}
