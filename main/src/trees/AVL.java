package trees;// Implementacion Arbol trees.AVL

// Se define un nodo aparte para el trees.AVL debido a la implementacion del prototipo

// Clase Principal 
public class AVL
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

    public NodoAVL findMin(NodoAVL Raiz)
    {
        if(Raiz == null)
            return null;
        while(Raiz.left != null){
            Raiz = Raiz.left;
        }
        return Raiz;
    }

    public NodoAVL findMax(NodoAVL Raiz){
        if(Raiz == null)
            return null;
        while(Raiz.right != null){
            Raiz = Raiz.right;
            }
        return Raiz;
    }

    private int getHeight(NodoAVL node)
    {  
        return node == null ? -1 : node.altura;  
    }
    // Busqueda Especifica, se realiza un singleton debido a la cantidad de busquedas que pueden realizarse

    public NodoAVL find(float numero, NodoAVL Raiz)
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
    public int Height(float dato, NodoAVL Raiz)
    {
        NodoAVL Aux = find(dato, Raiz);
        if(Aux == null)
            return -1;
        else
            return (Aux.altura-1); 
    }
    
    // Funciones requeridas para el balanceo - Caracteristica principal del trees.AVL
    public static NodoAVL RotacionDer(NodoAVL R){
        NodoAVL x = R.left;
        NodoAVL T2 = x.right;

        x.right = R;
        R.left = T2;

        R.altura = (int) (Math.max(altura(R.left),altura(R.right))+1);
        x.altura = (int) (Math.max(altura(x.left),altura(x.right))+1);

        return x;
    } 

    public static NodoAVL RotacionIzq(NodoAVL x){
        NodoAVL R = x.right;
        NodoAVL T2 = R.left;

        R.left = x;
        x.right = T2;

        x.altura = (int) (Math.max(altura(x.left),altura(x.right))+1);
        R.altura = (int) (Math.max(altura(R.left),altura(R.right))+1);

        return R ;
    }

    private NodoAVL DobleIzquierda(NodoAVL nodo3)
    {
        nodo3.left=RotacionDer(nodo3.left);
        return RotacionIzq(nodo3);
    }

    private NodoAVL DobleDerecha(NodoAVL nodo1)
    {
        nodo1.right=RotacionIzq(nodo1.right);
        return RotacionDer(nodo1);
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
        Raiz = insert(numero,Raiz);
    }

    public NodoAVL insert(float num, NodoAVL node)
    {
        if(node == null)
            return(new NodoAVL(num));
        // inserta un nuevo elemento si no existe

        // LA ROTACION ES INSTANTANEA DESDE QUE SE LLAMA INSERTAR
        if(num<node.data)
        {
            node.left = insert(num,node.left);
            if((getHeight(node.left)-getHeight(node.right))==2)
            {
                if(num<node.left.data)
                    node = RotacionIzq(node);
                else
                    node = DobleIzquierda(node);
            }
        }
         
        else if(num>node.data)
        {
            node.right = insert(num,node.right);
            if(getHeight(node.right)-getHeight(node.left)==2)
            {
                if(num>node.right.data)
                    node = RotacionDer(node);
                else
                    node = DobleDerecha(node);
            }
        }
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
        if(node!= null)
            node = rebalanceo(node);
        
        return node;
    }

    public NodoAVL rebalanceo(NodoAVL z)
    {
        updateAltura(z);
        int balance=Balanceado(z);
        if(balance >1)
        {
            if(altura(z.right.right)>altura(z.right.left))
                z=RotacionIzq(z);
            else
            {
                z.right=RotacionDer(z);
                z=RotacionIzq(z);
            }
        }
        else if(balance<-1)
        {
            if(altura(z.left.left)>altura(z.left.right))
                z=RotacionDer(z);
            else
            {
                z.left=RotacionIzq(z);
                z=RotacionDer(z);
            }
        }
        return z;
    }
}
