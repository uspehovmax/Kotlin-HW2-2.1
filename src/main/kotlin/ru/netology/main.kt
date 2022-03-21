package ru.netology

const val maestro = "Maestro"
const val mastercard = "Mastercard"
const val visa = "Visa"
const val mir = "МИР"
const val vkPay = "VKPay"

const val previousPayMaestro = 75_000_00
const val previousPayVisa = 100_000_00
const val previousPayVKPay = 5_000_00
const val previousPayMir = 30_000_00

const val currentPayMaestro = 2000_00
const val currentPayVisa = 5_000_00
const val currentPayVKPay = 10_000_00
const val currentPayMir = 10_000_00

const val maxTotalPayMaestro = 75000_00
const val commissionMaestro = 0.006
const val minCommissionMaestro = 20_00

const val minCommissionVisa = 35_00
const val commissionVisa = 0.0075
private var commission = 0

fun main() {
    commissionCalculation(maestro, previousPayMaestro, currentPayMaestro)  // Maestro
    commissionCalculation(visa, previousPayVisa, currentPayVisa)     // Visa
    commissionCalculation(vkPay, previousPayVKPay, currentPayVKPay)    // VKPay
    commissionCalculation(mastercard, previousPayMaestro, currentPayMaestro)  // Mastercard
    commissionCalculation(currentPay=currentPayMaestro)  // default
    commissionCalculation(mir, previousPayMir, currentPayMir)      // МИР

}

fun commissionCalculation(payMethodType: String = "VKPay", previousPay: Int = 0, currentPay: Int): Int {
    commission = 0
    commission = when (payMethodType) {
        maestro -> commissionMaestro(previousPay, currentPay)
        mastercard -> commissionMaestro(previousPay, currentPay)
        visa -> commissionVisa(currentPay)
        mir -> commissionVisa(currentPay)
        else -> {
            0
        }
    }
    printResult(currentPay, commission, payMethodType)
    return commission
}

fun commissionMaestro(previousPay: Int, currentPay: Int): Int {
    commission = if ((previousPay + currentPay) > maxTotalPayMaestro)
        (currentPay * commissionMaestro).toInt() + minCommissionMaestro
    else 0
    return commission
}

fun commissionVisa(currentPay: Int): Int {
    commission = if ((currentPay * commissionVisa).toInt() > minCommissionVisa)
        (currentPay * commissionVisa).toInt()
    else minCommissionVisa
    return commission
}

fun printResult(currentPay: Int, commission: Int, payMethodType: String) {
    println("Тип оплаты: $payMethodType")
    println("Сумма покупки: ${currentPay / 100} руб. ${currentPay % 100} коп. ")
    println("Комиссия: ${commission / 100} руб. ${commission % 100} коп. ")
    println("К ОПЛАТЕ: ${(currentPay + commission) / 100} руб. ${(currentPay + commission) % 100} коп.")
    println("---------------------------------------------------")
}