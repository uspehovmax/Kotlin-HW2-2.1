package ru.netology

import org.junit.Assert
import org.junit.Test

class CommissionCalculationTest {

    @Test
    fun commission_calculation_for_maestro() {
        val payMethodType = "Maestro"
        val previousPay = 75_000_00
        val currentPay = 2000_00
        val expectedCommission = 32_00

        val actualCommission = commissionCalculation(payMethodType, previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_for_mastercard() {
        val payMethodType = "Mastercard"
        val previousPay = 50_000_00
        val currentPay = 10_000_00
        val expectedCommission = 0

        val actualCommission = commissionCalculation(payMethodType, previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_for_visa() {
        val payMethodType = "Visa"
        val previousPay = 1000_00
        val currentPay = 10_000_00
        val expectedCommission = 75_00

        val actualCommission = commissionCalculation(payMethodType, previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_for_mir() {
        val payMethodType = "МИР"
        val previousPay = 50_000_00
        val currentPay = 10_000_00
        val expectedCommission = 75_00

        val actualCommission = commissionCalculation(payMethodType, previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_for_vkpay() {
        val payMethodType = "VKPay"
        val previousPay = 0
        val currentPay = 10_000_00
        val expectedCommission = 0

        val actualCommission = commissionCalculation(payMethodType, previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_for_default() {
        val currentPay = 10_000_00
        val expectedCommission = 0

        val actualCommission = commissionCalculation(currentPay=currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }
}