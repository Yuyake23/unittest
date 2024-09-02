package br.com.bruno.math;

import java.util.stream.DoubleStream;

public class SimpleMath {

    public double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public double mean(double firstNumber, double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }

    public double mean(double ... number) {
        return DoubleStream.of(number).average().orElseThrow();
    }

    public double squareRoot(double number) {
        return Math.sqrt(number);
    }

}
