package ru.netology

import org.junit.Assert
import org.junit.Test

class CommissionCalculationMaestroTest {

    @Test
    fun commission_calculation_maestro() {
        val previousPay = 75_000_00
        val currentPay = 2000_00
        val expectedCommission = 32_00

        val actualCommission = commissionMaestro (previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun commission_calculation_maestro_min() {
        val previousPay = 0
        val currentPay = 5000_00
        val expectedCommission = 0

        val actualCommission = commissionMaestro (previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)

    }

    @Test
    fun commission_calculation_mastercard() {
        val previousPay = 0
        val currentPay = 10_000_00
        val expectedCommission = 0

        val actualCommission = commissionMaestro (previousPay, currentPay)

        Assert.assertEquals(expectedCommission, actualCommission)
    }

}