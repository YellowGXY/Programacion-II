import javax.swing.*;

public class CuentaBancaria {
    private String numeroCuenta;
    private String nombreTitular;
    private double saldoActual;
    private String tipoCuenta;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldoActual, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldoActual = saldoActual;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {

        this.tipoCuenta = tipoCuenta;
    }

    void depositar(String numeroCuenta, String nombreTitular, double saldoActual, String tipoCuenta){
        JOptionPane.showMessageDialog(null, "La cuenta de deposito es: " + numeroCuenta + "\nNombre del Titular: "+nombreTitular+"\nTipo de cuenta: "+ tipoCuenta + "\nSaldo Actual: "+saldoActual);
        int conf = JOptionPane.showConfirmDialog(null, "Dese depositar en esta cuenta?");
        if (conf == 1){
            return;
        }
        JOptionPane.showMessageDialog(null,"Continuando con el deposito...");
        double saldoDepositado = Double.parseDouble((JOptionPane.showInputDialog(null, "Ingrese el saldo a depositar.")));
        if (saldoDepositado <= 0){
            JOptionPane.showMessageDialog(null, "El monto ingresado no es válido. \nProceso terminado.");
            return;
        }

        this.saldoActual = this.saldoActual + saldoDepositado;
        JOptionPane.showMessageDialog(null, "El saldo atualizado es: "+this.saldoActual);
    }

    void obtenerSaldo(double saldoActual){
        JOptionPane.showMessageDialog(null, "El saldo atual es: "+saldoActual);
    }


}
