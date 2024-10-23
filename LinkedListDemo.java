import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListDemo {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();

        // Crear la lista con 5 elementos
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Lista original:");
        list.display();

        // Esperar a que el usuario presione una tecla
        waitForKeyPress();

        // Insertar después del nodo que tiene valor 30
        list.insertAfterX(25, 30);

        waitForKeyPress();

        System.out.println("\nLista después de la inserción:");
        list.display();

        // Esperar a que el usuario presione una tecla
        waitForKeyPress();
    }

    static class Node {
        int info; // Valor del nodo
        Node next; // Apuntador al siguiente nodo

        Node(int value) {
            this.info = value;
            this.next = null; // Inicializar el siguiente nodo como nulo
        }

        @Override
        public String toString() {
            // Usamos getClass().getSimpleName() para obtener solo el nombre de la clase
            return "$" + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
        }
    }

    static class LinkedList {
        Node head; // Cabeza de la lista

        LinkedList() {
            this.head = null; // Inicializar la cabeza como nula
        }

        void insert(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next; // Moverse al final de la lista
                }
                temp.next = newNode; // Insertar al final
            }
        }

        void insertAfterX(int data, int x) {
            Node temp = head;
            while (temp != null && temp.info != x) {
                temp = temp.next; // Buscar el nodo con valor X
            }
            if (temp != null) { // Si se encontró el nodo con X
                Node newNode = new Node(data);
                newNode.next = temp.next; // Apuntar el nuevo nodo al siguiente
                temp.next = newNode; // Conectar el nuevo nodo
                System.out.println("El valor (" + data + ") será insertado en (dirección de memoria: " + newNode
                        + ") que apunta a (dirección del siguiente: " + newNode.next + ")");
            } else {
                System.out.println("El nodo dado como referencia no se encuentra en la lista.");
            }
        }

        void display() {
            // Encabezado de la tabla
            System.out.println("╔═════╦══════════════════════╦═════════╦═════════════════════════╗");
            System.out.println("║ No. ║ Dirección de memoria ║ Valor   ║ Dirección del siguiente ║");
            System.out.println("╠═════╬══════════════════════╬═════════╬═════════════════════════╣");

            Node temp = head;
            int count = 1;
            while (temp != null) {
                // Imprimir cada fila de la tabla
                System.out.printf("║ %-3d ║ %-20s ║ %-7d ║ %-23s ║%n", count, temp, temp.info, temp.next);
                temp = temp.next;
                count++;
            }

            // Línea final de la tabla
            System.out.println("╚═════╩══════════════════════╩═════════╩═════════════════════════╝");
        }

    }

    private static void waitForKeyPress() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Ingrese 0 para continuar...");
                String input = reader.readLine(); // Leer una línea completa
                if (input.equals("0")) // Comparar la entrada como cadena
                    break; // Sale del bucle cuando se presiona 0
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
