package ru.netology

import org.junit.Assert
import org.junit.Test

class CommissionCalculationVisaTest {

    @Test
    fun commission_calculation_visa() {
        val currentPay = 10_000_00
        val expectedCommission = 75_00

        val actualCommission = commissionVisa (currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_mir() {
        val currentPay = 20_000_00
        val expectedCommission = 150_00

        val actualCommission = commissionVisa (currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }


    @Test
    fun commission_calculation_visa_min() {
        val currentPay = 1000_00
        val expectedCommission = 35_00

        val actualCommission = commissionVisa (currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }
}