package crudarray;

import javax.swing.JOptionPane;

public class CrudArray {

    //Instancia de arreglo para los atributos
    static Clientes[] clt = new Clientes[2000];
    static Articulos[] art = new Articulos[3000];
    static ventas[] vt = new ventas[3000];
    static int posClientes = 0;
    static int posArticulos = 0;
    static int posVentas = 0;

    public static void main(String[] args) {

        int opcion = 0;
        while (opcion != 5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "**** MENU PRINCIPAL DEL SISTEMA **** \n"
                    + "[1].- Movimientos del Cliente \n"
                    + "[2].- Movimientos del Articulo \n"
                    + "[3].- Realizar venta \n"
                    + "[4].- Buscar venta por cliente \n"
                    + "[5].- Salir \n"));
            switch (opcion) {
                case 1:
                    agregarDirectoClientes();
                    SubMenuClientes();
                    break;
                case 2:
                    SubMenuArticulos();
                    break;
                case 3:
                    vender();
                    break;
                case 4:
                    BuscarVentaNoCliente();
                    break;
                case 5:
                    break;
                default:
            }
        }

    }

    // Metodos extras
    static void agregarDirectoClientes() {
        clt[posClientes] = new Clientes();
        clt[posClientes].setNumeroCliente(300);
        clt[posClientes].setNombre("Juan Carlos Bodoque");
        clt[posClientes].setStatus("T");
        posClientes++;

        clt[posClientes] = new Clientes();
        clt[posClientes].setNumeroCliente(200);
        clt[posClientes].setNombre("Macaroni");
        clt[posClientes].setStatus("T");
        posClientes++;

        clt[posClientes] = new Clientes();
        clt[posClientes].setNumeroCliente(100);
        clt[posClientes].setNombre("Simon Trujillo");
        clt[posClientes].setStatus("T");
        posClientes++;
    }

    static void BuscarVentaNoCliente() {
        int Ncliente = Integer.parseInt(JOptionPane.showInputDialog(null, "No de Cliente"));
        System.out.println("----------------------------------------------------------");
        System.out.println("-          VENTA REALIZADA POR CLIENTE ESPECIFICO        -");

        for (ventas vt1 : vt) {
            if (vt1 == null) {

            } else {
                if (vt1.getNumcliente() == Ncliente) {
                    System.out.println(vt1.getCodigo()
                            + " " + vt1.getDescripcion()
                            + " " + vt1.getCantidad()
                            + " " + vt1.getPrecio()
                            + " " + vt1.getTotal()
                            + " " + vt1.getNumcliente()
                            + " " + vt1.getFecha());

                }
            }
        }
    }

    static void vender() {
        String Descripcion;
        int cantidad;
        double precio;
        double totVenta = 0;
        double total = 0;
        String cdg = "";

        //BUSCAR AL CLIENTE QUE SE LE REALIZARA LA VENTA
        int Ncliente = Integer.parseInt(JOptionPane.showInputDialog(null, "NO. de Cliente"));
        String fecha = JOptionPane.showInputDialog(null, "Fecha de venta");

        for (Clientes clt1 : clt) {
            if (clt1.getNumeroCliente() == Ncliente && "T".equals(clt1.getStatus())) {
                System.out.println("***** DATOS DEL CLIENTE QUE REALIZA LA COMPRA *****");
                System.out.println(" Fecha de la venta: " + fecha);
                System.out.println(clt1.getNumeroCliente() + " " + clt1.getNombre());
                System.out.println("-----------------------------------------------------------");
                System.out.println("- Codigo    Descripcion    Cantidad    Precio    Total    -");
                System.out.println("-----------------------------------------------------------");
                break;

            }
        }
        // BUSCAR LOS ARTICULOS QUE SE VENDERAN AL CLIENTE SELECCIONADO
        String pregunta = "";
        while (!pregunta.equals("n")) {
            cdg = JOptionPane.showInputDialog(null, "PANTALLA DE VENTAS \n\n Codigo");
            for (Articulos art1 : art) {
                if (cdg.equals(art1.getCodigo()) && "T".equals(art1.getStatus()));
                Descripcion = art1.getDescripcion();
                precio = art1.getPrecioUnitario();
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad que llevara"));
                total = precio * cantidad;
                totVenta = totVenta + total;
                System.out.println(art1.getCodigo() + " "
                        + " " + art1.getDescripcion() + " " + cantidad + " " + art1.getPrecioUnitario() + " " + total);
                // GUARDAR EL ARTICULO EN LA CLASE VENTAS CADA VEZ QUE SE BUSQUE UN ARTICULO DIFERENTE
                vt[posVentas] = new ventas();
                vt[posVentas].setNumcliente(Ncliente);
                vt[posVentas].setFecha(fecha);
                vt[posVentas].setCodigo(cdg);
                vt[posVentas].setDescripcion(Descripcion);
                vt[posVentas].setPrecio(precio);
                vt[posVentas].setCantidad(cantidad);
                vt[posVentas].setTotal(total);
                posVentas++;
                break;

            }
            pregunta = JOptionPane.showInputDialog(null, "Seguir con la compra ¿s/n?");

        }
        System.out.println("El total a pagar de la compra es =====> " + totVenta);

    }

    static void SubMenuArticulos() {
        int op2 = 0;
        while (op2 != 5) {
            op2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "== SUB MENU DE ARTIUCLOS == \n"
                    + "[1].- Agregar \n"
                    + "[2].- Consultar \n"
                    + "[3].- Eliminar \n"
                    + "[4].- Listar \n"
                    + "[5].- Salir \n"));
            switch (op2) {
                case 1: // Agregar
                    String codigo = JOptionPane.showInputDialog(null, "Codigo del Articulo");
                    String descpricion = JOptionPane.showInputDialog(null, "Descripcion");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio Unitario"));
                    art[posArticulos] = new Articulos();
                    art[posArticulos].setCodigo(codigo);
                    art[posArticulos].setDescripcion(descpricion);
                    art[posArticulos].setPrecioUnitario(precio);
                    art[posArticulos].setStatus("T");
                    posArticulos++;

                    break;

                case 2: // Consultar
                    String cdg = JOptionPane.showInputDialog(null, "Codigo a Buscar");
                    for (int i = 0; i < art.length; i++) {
                        if (art[i].getCodigo().equals(cdg) && "T".contains(art[i].getStatus())) {
                            System.out.println("****************************");
                            System.out.println("* SE ENCONTRO LO SIGUIENTE *");
                            System.out.println("****************************");
                            System.out.println("Codigo_ :" + art[i].getCodigo());
                            System.out.println("Descripcion_ :" + art[i].getDescripcion());
                            System.out.println("Precio Unitario_ :" + art[i].getPrecioUnitario());
                            break;
                        }

                    }
                    break;
                case 3: // Eliminar
                    String cdgo = JOptionPane.showInputDialog(null, "Codigo a Eliminar");
                    for (int i = 0; i < art.length; i++) {
                        if (art[i].getCodigo().equals(cdgo)) {
                            art[i].setStatus("F");
                        }
                        break;
                    }
                    break;

                case 4: // Listar
                    System.out.println("****************************");
                    System.out.println("*   LISTADO DE ARTICULOS   *");
                    System.out.println("****************************");
                    for (int i = 0; i < art.length; i++) {
                        if (art[i] == null) {

                        } else {
                            if ("T".contains(art[i].getStatus())) {
                                System.out.println(art[i].getCodigo() + " " + art[i].getDescripcion()
                                        + " " + art[i].getPrecioUnitario());
                            }
                        }
                    }
                    break;
                case 5:
                    break;
                default:
            }

        }
    }

    static void SubMenuClientes() {
        int op1 = 0;
        while (op1 != 5) {
            op1 = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "== SUB MENU DE CLIENTES == \n"
                    + "[1].- Agregar \n"
                    + "[2].- Consultar \n"
                    + "[3].- Eliminar \n"
                    + "[4].- Listar \n"
                    + "[5].- Salir \n"));
            switch (op1) {
                case 1:
                    int NCliente = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                            + "Introduzca el numero cliente"));
                    String nombre = JOptionPane.showInputDialog(null, "Nombre del cliente");
                    String st = "T";
                    // Aquí se rellena nuestro arreglo por medio de Metodos Set
                    clt[posClientes] = new Clientes();
                    clt[posClientes].setNumeroCliente(NCliente);
                    clt[posClientes].setNombre(nombre);
                    clt[posClientes].setStatus(st);
                    posClientes++;
                    break;
                case 2:
                    int ncl = Integer.parseInt(JOptionPane.showInputDialog(null, "NO. de clientes"));
                    for (int i = 0; i < clt.length; i++) {
                        if (clt[i].getNumeroCliente() == ncl && "T".equals(clt[i].getStatus())) {
                            System.out.println("******************************");
                            System.out.println("*  SE ENCONTRO LO SIGUIENTE  *");
                            System.out.println("******************************");
                            System.out.println("Numero clientes " + clt[i].getNumeroCliente());
                            System.out.println("Nombre :" + clt[i].getNombre());
                            break;
                        }
                    }
                    break;
                case 3:
                    int nclE = Integer.parseInt(JOptionPane.showInputDialog(null, "Clientes a borrar"));
                    for (int i = 0; i < clt.length; i++) {
                        if (clt[i].getNumeroCliente() == nclE) {
                            clt[i].setStatus("F");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("***************************");
                    System.out.println("*   LISTADO DE CLIENTES   *");
                    System.out.println("***************************");
                    for (int i = 0; i < clt.length; i++) {
                        if (clt[i] == null) {

                        } else {
                            if ("T".contains(clt[i].getStatus())) {

                                System.out.println(clt[i].getNumeroCliente() + " " + clt[i].getNombre());

                            }
                        }
                    }
                    break;
                case 5:
                    break;
                default:
            }

        }
    }
}
