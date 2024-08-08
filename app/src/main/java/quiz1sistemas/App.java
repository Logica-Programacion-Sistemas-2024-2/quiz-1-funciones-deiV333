
package quiz1sistemas;

import java.util.Scanner;

public class App { 
    public static void main(String[] args) {
        try {
        int cantBoletas = 0, tipoCombo = 0, cantCombos = 0;
        String tipoBoleta = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de boleta que desea comprar. \nVip: ingrese V \nGeneral: ingrese G");
        tipoBoleta = sc.nextLine();
        System.out.println("Ingrese la cantidad de boletas: ");
        cantBoletas = sc.nextInt();
        sc.nextLine();
        System.out.println("Que combo desea comprar: \n1. Hamburguesa y Perro caliente – Valor $ 40.000 \n2. Crispetas con dos Gaseosas – Valor $ 30.000 "
         + "\n3. Dos Perros calientes con Dos Gaseosas – Valor $ 42.000" );
        tipoCombo = sc.nextInt();
        System.out.println("Cuantos combos desea llevar: ");
        cantCombos = sc.nextInt();
        int valorBoleta = calcularValorBoleta(tipoBoleta, cantBoletas);
        int calcularValorNetoCombo = calcularValorNetoCombo(tipoCombo, cantCombos);
        int calcularDescuentoCombo = calcularDescuentoCombo(tipoBoleta, tipoCombo ,calcularValorNetoCombo);
        int valorFactura = calcularValorFactura(calcularValorNetoCombo, valorBoleta, calcularDescuentoCombo);

        System.out.println("Tipo boleta: " + tipoBoleta + "\n" + "Cantidad de boletas: " +  cantBoletas + " Valor boletas: " + valorBoleta + "\nTipo Combo: " + tipoCombo + " Cantidad combos: " + cantCombos + "\nValor neto de combo: " + calcularValorNetoCombo + "\nValor de descuento aplicado en el combo: " + calcularDescuentoCombo + "\nValor de factura: " + valorFactura);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
        }
    }
    
    /*  Implemente una funcion llamada calcularValorBoleta que cumpla con las siguientes caracteristicas
        * Recibe: 
            - Una cadena de caracteres que representa el tipo de silla comprada (V ó G)
            - Un entero que representa la cantidad de boletas compradas
        * Retorna:
            - Un entero representando el valor total de las boletas
    */
    public static int calcularValorBoleta(String tipoSilla, int cantBoletas){
        try {
            int valorBoletaGeneral = 10000, valorBoletaVip = 15000;
            int valorBoleta = 0;
            if(tipoSilla.equals("V")){
                valorBoleta = valorBoletaVip*cantBoletas;
            }else if(tipoSilla.equals("G")){
                valorBoleta = valorBoletaGeneral*cantBoletas;
            }

            return valorBoleta;
        } catch (Exception e) {
            return -1;
        }
    }
    


    //------------------------------------------------------------------

    /*  Implemente una funcion llamada calcularValorNetoCombo que cumpla con las siguientes caracteristicas
        * Recibe:
            - Un entero representando el numero de combo selecciondo
            - Un entero representando la cantidad de combos comprados
        * Retorna:
            - Un entero representando el valor neto del combo
    */
    public static int calcularValorNetoCombo(int tipoCombo, int numCombos){
        try {
            int combo1 = 40000, combo2 = 30000, combo3 = 42000;
            int valorNetoCombo = 0;
            switch (tipoCombo) {
                case 1:
                    valorNetoCombo = combo1*numCombos;
                    break;
                case 2: 
                    valorNetoCombo = combo2*numCombos;
                    break;
                case 3: 
                    valorNetoCombo = combo3*numCombos;
                default:
                    return -1;
            }

            return valorNetoCombo;
        } catch (Exception e) {
            return -1;
        }
    }
    


    //------------------------------------------------------------------

    /*  Implemente una funcion llamada calcularDescuentoCombo que cumpla con las siguientes caracteristicas
        * Recibe:
            - Una cadena de caracteres que representa el tipo de silla comprada (V ó G)
            - Un entero representando el valor neto del combo

        * Retorna:
            - Un entero representando el valor del descuento
    */
    public static int calcularDescuentoCombo(String tipoSillaComprada, int tipoCombo ,int valorNetoCombo){
        try {
            int valDescuentoCombo = 0;
            if(tipoSillaComprada.equals("V")){
                switch (tipoCombo) {
                    case 1:
                        valDescuentoCombo = (int)(valorNetoCombo * 0.05);
                        break;
                    case 2:
                        valDescuentoCombo = (int)(valorNetoCombo * 0.06);
                        break;
                    case 3: 
                        valDescuentoCombo = (int)(valorNetoCombo * 0.03);
                    default:
                        return -1;                
                }

                return valDescuentoCombo;
            }else if(tipoSillaComprada.equals("G")){
                valDescuentoCombo = 0;
                return valDescuentoCombo;
            }else{
                return -1;
            } 
        
        }catch (Exception e) {
            return -1;
    
        }
    }
    


    //------------------------------------------------------------------

    /*  Implemente una funcion llamada calcularValorFactura que cumpla con las siguientes caracteristicas
        * Recibe:
            - Un entero representando el valor neto del combo
            - Un entero representando el valor de las boletas
            - Un entero representando el valor del descuento del combo
        * Retorna:
            - Un entero representando el valor total de la factura
    */
    public static int calcularValorFactura(int valorNetoCombo, int valorBoletas, int valDescuentoCombo){
        try{
            int valorFactura = 0;

            if(valorBoletas >= 0 && valorNetoCombo >= 0){
                valorFactura = valorBoletas + valorNetoCombo - valDescuentoCombo;
            }else{
                return -1;
            }
            return valorFactura;
        }catch(Exception e){
            return -1;
        }


    }
}

