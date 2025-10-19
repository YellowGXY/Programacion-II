import javax.swing.*;

void main() {
    /** La clase CuentaBancaria
     Cree una clase llamada CuentaBancaria que un banco podría utilizar para gestionar las cuentas de sus clientes.
     Una CuentaBancaria debe incluir cuatro variables de instancia: número de cuenta (tipo String), nombre del titular
     (tipo String), saldo actual (tipo double) y tipo de cuenta (tipo String - puede ser "Ahorro" o "Corriente").
     Su clase debe tener un constructor que inicialice las cuatro variables de instancia. Proporcione un metodo establecer
     y un metodo obtener para cada variable de instancia. Además, proporcione dos métodos:

     depositar(double monto): que añada el monto al saldo. Si el monto no es positivo, no debe realizar ninguna operación.
     retirar(double monto): que reste el monto del saldo. Si el monto es mayor al saldo o no es positivo, no debe realizar
     ninguna operación.
     obtenerSaldo(): que devuelva el saldo actual.

     Escriba una aplicación de prueba llamada PruebaCuentaBancaria que demuestre las capacidades de la clase CuentaBancaria,
     realizando varios depósitos y retiros.
     */
    CuentaBancaria cuenta = new CuentaBancaria();

    cuenta.setNumeroCuenta(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta: "));
    cuenta.setNombreTitular(JOptionPane.showInputDialog(null, "Ingrese el nombre del titular: "));
    cuenta.setSaldoActual(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el saldo actual: ")));
    int seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el tipo de cuenta: \n1. Corriente\n2. Ahorros"));
    if (seleccion == 1){
        cuenta.setTipoCuenta("Corriente");
    } else if (seleccion == 2) {
        cuenta.setTipoCuenta("Ahorros");
    } else {
        JOptionPane.showMessageDialog(null, "Ningúna opcion seleccionada.\nPor defecto: Corriente");
        cuenta.setTipoCuenta("Corriente");
    }

    cuenta.depositar(cuenta.getNumeroCuenta(), cuenta.getNombreTitular(), cuenta.getSaldoActual(), cuenta.getTipoCuenta());
    cuenta.obtenerSaldo(cuenta.getSaldoActual());



}
