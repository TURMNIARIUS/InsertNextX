#include <iostream>
#include <iomanip> // Para usar setw y ajustar la alineación
//F8 para ejecutar

using namespace std;

struct Node {
    int info;
    Node* next;
    
    Node(int value) : info(value), next(NULL) {}
};

class LinkedList {
public:
    Node* head;

    LinkedList() : head(NULL) {}

    void insert(int value) {
        Node* newNode = new Node(value);
        if (head == NULL) {
            head = newNode;
        } else {
            Node* temp = head;
            while (temp->next != NULL) {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }

    void insertAfterX(int data, int x) {    //F8 para ejecutar
        Node* temp = head;
        while (temp != NULL && temp->info != x) {
            temp = temp->next;
        }
        if (temp != NULL) {
            Node* newNode = new Node(data);
            newNode->next = temp->next;
            temp->next = newNode;
            cout << "El valor (" << data << ") será insertado en (dirección de memoria: " << newNode
             << ") que apunta a (dirección del siguiente: " << newNode->next << ")" << endl;
        } else {
            cout << "El nodo dado como referencia no se encuentra en la lista." << endl;
        }
    }

    void display() {
        // Encabezado de la tabla
        cout << "╔═════╦═══════════════════════╦════════════════╦══════════════════════════════╗" << endl;
        cout << "║ No. ║ Dirección de memoria  ║ Valor          ║ Dirección del siguiente      ║" << endl;
        cout << "╠═════╬═══════════════════════╬════════════════╬══════════════════════════════╣" << endl;

        Node* temp = head;
        int count = 1;

        while (temp != NULL) {
            // Imprimir fila de la tabla con los datos del nodo actual
            cout << "║ " << setw(3) << count << " ║ " << setw(21) << temp << " ║ " 
                 << setw(14) << temp->info << " ║ " << setw(28);

            // Verificar si el siguiente nodo es NULL
            if (temp->next == NULL) {
                cout << "NULL" << " ║" << endl;
            } else {
                cout << temp->next << " ║" << endl;
            }

            // Línea divisoria entre filas (excepto la última)
            if (temp->next != NULL) {
                cout << "╠═════╬═══════════════════════╬════════════════╬══════════════════════════════╣" << endl;
            }

            temp = temp->next;
            count++;
        }

        // Línea final de la tabla
        cout << "╚═════╩═══════════════════════╩════════════════╩══════════════════════════════╝" << endl;
    }
};

void waitForKeyPress() {
    cout << "Presione cualquier tecla para continuar..." << endl;
    // cin.ignore();
    cin.get(); // Esperar entrada por teclado
}

int main() {
    system("chcp 65001 > nul");

    LinkedList list;

    // Crear la lista con 5 elementos
    list.insert(10);
    list.insert(20);
    list.insert(30);
    list.insert(40);
    list.insert(50);

    // Imprimir la lista original
    cout << "Lista original:" << endl;
    list.display();

    waitForKeyPress();

    // Insertar después del nodo que tiene valor 30
    list.insertAfterX(25, 30);

    waitForKeyPress();

    cout << "\nLista después de la inserción:" << endl;
    list.display();

    return 0;
}
