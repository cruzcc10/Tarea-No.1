package cuentas;

import java.util.Scanner;

public class Transacciones {

    public static int buscarNumeroDeCuenta(Cuenta cuentas[],int numeroDeCuentaAbucar){
        int indice = 0;
        int iterador = 0;
        boolean numeroDeCuentaEncontrada = false;

        while((iterador < cuentas.length) && (numeroDeCuentaEncontrada == false)){
            if(cuentas[iterador].getNumeroCuenta() == numeroDeCuentaAbucar){
                numeroDeCuentaEncontrada = true;
                indice = iterador;
            }
            iterador ++;
        }
        if(numeroDeCuentaEncontrada == false){
            indice = -1;
        }
        return indice;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre, id, fechaNacimiento, edad, direccionCasa;
        Cuenta cuentas[];
        Cliente cliente;
        int numeroCuenta,cantidadCuentas,opcion,indiceNumeroCuenta;
        double saldo,cantidadDinero;

        System.out.print("Digite el nombre del cliente : ");
        nombre = teclado.next();

        System.out.print("Digite el id del cliente : ");
        id = teclado.next();

        System.out.print("Digite la fecha de nacimiento del cliente : ");
        fechaNacimiento = teclado.next();

        System.out.print("Digite la edad del cliente : ");
        edad = teclado.next();

        System.out.print("Digite la dirección de la casa del cliente : ");
        direccionCasa = teclado.next();

        System.out.print("\nDigite la cantidad de cuentas que tiene el cliente : ");
        cantidadCuentas = teclado.nextInt();

        System.out.println("");

        cuentas = new Cuenta[cantidadCuentas];

        for(int i = 0;i < cuentas.length; i++){
            System.out.println("\nDigite la " +(i+1)+"º cuenta : ");

            System.out.print("Digite el número de cuenta : ");
            numeroCuenta = teclado.nextInt();

            System.out.print("Digite el saldo de la cuenta : ");
            saldo = teclado.nextDouble();
            System.out.println("");
            cuentas[i] = new Cuenta(numeroCuenta, saldo);
        }

        cliente = new Cliente(nombre, id, fechaNacimiento, edad, direccionCasa, cuentas);

        do{
            System.out.println("\n\tMENU");
            System.out.println("1 . Ingresar saldo a la cuenta");
            System.out.println("2 . Retirar saldo de la cuenta");
            System.out.println("3 . Consultar saldo de la cuenta");
            System.out.println("4 . Salir");
            System.out.print("Digite una opción : ");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:
                    System.out.print("\nDigite el número de cuenta : ");
                    numeroCuenta = teclado.nextInt();
                    indiceNumeroCuenta = buscarNumeroDeCuenta(cuentas, numeroCuenta);

                    if(indiceNumeroCuenta == -1){
                        System.out.println("\nCuenta no encontrada, verifique su número de cuenta.");
                        System.out.println("");
                    }else{
                        System.out.print("Digite la cantidad de dinero a depositar : ");
                        cantidadDinero = teclado.nextDouble();

                        cliente.ingresarDinero(indiceNumeroCuenta, cantidadDinero);
                        System.out.println("\nDepósito con éxito.");
                        System.out.print("Saldo disponible : " + cliente.consultarSaldo(indiceNumeroCuenta));
                        System.out.println("");
                    }

                    break;

                case 2:
                    System.out.print("\nDigite el número de cuenta : ");
                    numeroCuenta = teclado.nextInt();
                    indiceNumeroCuenta = buscarNumeroDeCuenta(cuentas, numeroCuenta);

                    if(indiceNumeroCuenta == -1){
                        System.out.println("\nCuenta no encontrada, verifique su número de cuenta.");
                        System.out.println("");
                    }
                    else{
                        System.out.print("\nDigite la cantidad de dinero a retirar : ");
                        cantidadDinero = teclado.nextDouble();

                        if(cliente.consultarSaldo(indiceNumeroCuenta) < cantidadDinero){
                            System.out.print("Saldo insuficiente.");
                            System.out.println("");
                        }else{
                            cliente.retirarDinero(indiceNumeroCuenta, cantidadDinero);
                            System.out.println("");
                            System.out.println("Retiro con éxito.");
                            System.out.println("Saldo disponible de la cuenta : " + cliente.consultarSaldo(indiceNumeroCuenta));
                            System.out.println("");
                        }
                    }

                    break;

                case 3:
                    System.out.print("\nDigite el número de cuenta : ");
                    numeroCuenta = teclado.nextInt();
                    indiceNumeroCuenta = buscarNumeroDeCuenta(cuentas, numeroCuenta);

                    if(indiceNumeroCuenta == -1){
                        System.out.println("\nCuenta no encontrada, verifique su número de cuenta.");
                        System.out.println("");
                    }else{
                        System.out.println("Saldo disponible : " + cliente.consultarSaldo(indiceNumeroCuenta));
                        System.out.println("");
                    }
                    break;

                case 4:
                    System.out.println("\nGracias.");
                    opcion = 4;
                    break;

                default:
                    System.out.println("\nOpción no disponible, digite un número válido.");
                    break;
            }
        }while(opcion != 4);
    }
}