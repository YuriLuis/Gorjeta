package com.yuri.luis.garcia.pereira.model

class CalculaGorjeta(val valorAmount : Double, val percentualGorjeta : Double ) {

    fun calculaGorjeta() = valorAmount * (percentualGorjeta / 100)

    fun calculaGorjeta15Porcento() = valorAmount * 0.15

    fun calculaTotalComGorjeta() = valorAmount + this.calculaGorjeta()

    fun calculaTotalComGorjeta15Porcento() = valorAmount + this.calculaGorjeta15Porcento()
}