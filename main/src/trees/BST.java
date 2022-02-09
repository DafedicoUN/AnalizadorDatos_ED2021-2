// Implementacion Arbol BST
// A diferencia del arbol trees.AVL este no se autobalancea, por lo que su altura puede ser desproporcionada

// esto se puede quitar en las pruebas
package trees;

// Se recicla el nodo del arbol trees.AVL para facilitar la implementacion del BST
class NodoAVL
{
    // se usa el valor "repetido" en caso de existir datos repetidos
    float data;
    int altura, repetido;

    NodoAVL left=null;
    NodoAVL right=null;

    // Constructor
    public NodoAVL(float data)
    {
        this.data=data;
        altura=1;
        repetido=1;
    }


    // Fundiones de obtener datos - Aplica tambien el repetido
    public float getData()
    {
        return data;
    }
    public int getAltura()
    {
        return altura;
    }
    public int getRepetido()
    {
        return repetido;
    }
}

// Clase Principal 
public class BST
{
    // Raiz Permanente
    NodoAVL Raiz;
    NodoAVL Aux;
    
    public NodoAVL getAux()
    {
        return Aux;
    }
    public void setAux(NodoAVL Aux)
    {
        this.Aux = Aux;
    }
    
    // Se define el nodo raiz
    public void setRaiz(NodoAVL Raiz)
    {
        this.Raiz = Raiz;
    }

    public NodoAVL getRaiz()
    {
        return Raiz;
    }

    // Funciones Básicas
    public boolean empty()
    {
        return Raiz==null;
    }

    public static int altura(NodoAVL N)
    {
        if(N== null)
            return 0;

        return N.altura;
    }

    // Mismo metodo del trees.AVL
    public NodoAVL FindMin(NodoAVL Raiz)
    {
        if(Raiz == null)
            return null;
        while(Raiz.left != null){
            Raiz = Raiz.left;
        }
        return Raiz;
    }
    // Mismo metodo del trees.AVL
    public NodoAVL FindMax(NodoAVL Raiz){
        if(Raiz == null)
            return null;
        while(Raiz.right != null){
            Raiz = Raiz.right;
            }
        return Raiz;
    }
    
    // Busqueda Especifica, se realiza un singleton debido a la cantidad de busquedas acomuladas que pueden realizarse

    public NodoAVL Find(float numero, NodoAVL Raiz)
    {
        return encontrar(numero, Raiz);
    }
    private NodoAVL encontrar(float numero, NodoAVL nodo)
    {
        while(nodo!= null)
        {
            float cabeza = nodo.data;
            if(numero<cabeza)
                nodo=nodo.left;
            else if(numero>cabeza)
                nodo=nodo.right;
            else
                return nodo; // retorna el nodo donde encontro el nodo
        }    
    throw new RuntimeException("Usuario no existente");   // No lo encontro.
    } 

    // Altura especifica de un Nodo
    public int height(float dato, NodoAVL Raiz)
    {
        NodoAVL Aux = Find(dato, Raiz);
        if(Aux == null)
            return -1;
        else
            return (Aux.altura-1); 
    }
    
    public void updateAltura(NodoAVL node)
    {
        node.altura = (int) (1 + Math.max(altura(node.left),altura(node.right)));
    }

    public static int Balanceado(NodoAVL R){
        if(R == null)
            return 0;
        return altura(R.left)-altura(R.right);
    }
    
    // ***  Metodo de Insertar ***
    
    public void insertElement(float numero)
    {
        Raiz=Insert(numero,Raiz);
    }

    public NodoAVL Insert(float num, NodoAVL node)
    {
        if(node == null)
            return(new NodoAVL(num));
        // inserta un nuevo elemento si no existe

        if(num<node.data)
            node.left = Insert(num,node.left);         
        else if(num>node.data)
            node.right = Insert(num,node.right);
        else if(num==node.data)
        {
            // Este caso es bastante importante, debido a que se puede contar cuantas veces esta repetido el elemento en un nodo
            node.repetido=node.repetido+1;
            throw new RuntimeException("Usuario en uso");
        }
        updateAltura(node);
        return node;
    }

    // **** Metodo de ELIMINAR ****

    // el eliminar mas fácil, eliminar todo
    public void removeALL()
    {
        Raiz=null;
    }
    // el eliminar mas dificil, eliminar un nodo (semirecursivo)
    public NodoAVL borrar(NodoAVL node, float datos)
    {
        if(node == null)
            return node; // nodo no existente
        else if(node.data>datos)
            node.left = borrar(node.left, datos);
        else if(node.data<datos)
            node.right = borrar(node.right, datos);
        else 
        {
            if(node.left==null||node.right==null)
                node = (node.left == null) ? node.right : node.left;
            else
            {
                NodoAVL mostLeft = node.right;
                node.data = mostLeft.data;
                node.right = borrar(node.right, node.data);
                // aca va la recursividad
            }
        }
      
        return node;
    }
}
