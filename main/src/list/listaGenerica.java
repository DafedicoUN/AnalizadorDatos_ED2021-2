package list;

import java.io.*;

public class listaGenerica<T> implements Serializable {
    public class NodoGenerico<T> {
        T data;
        private NodoGenerico<T> next;
        public NodoGenerico(){
            this(null);            
        }
        public NodoGenerico(T data){
            this.data = data;
            this.next = null;
        }
        public T getdata(){
            return data;
        }
        public void setData(T data){
            this.data = data;
        }
        public NodoGenerico<T> getNext(){
            return next;
        }
        public void setNext(NodoGenerico<T> next){
            this.next = next;
        }
    }

    private NodoGenerico cabeza;
    private NodoGenerico cola;

    byte[] previous;

    byte[] serialize() throws IOException {
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream (bs);
        listaGenerica list = this;
        os.writeObject(list);
        os.close();
        return bs.toByteArray();
    }

    static listaGenerica read(byte[] a) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs= new ByteArrayInputStream(a);
        ObjectInputStream is = new ObjectInputStream(bs);
        listaGenerica list = (listaGenerica) is.readObject();
        is.close();
        return list;
    }

    // Operaciones con cabeza y cola
    public listaGenerica(){
        cabeza=null;
        cola=null;
    }
    public NodoGenerico getCabeza(){
        return cabeza;
    }
    public NodoGenerico getCola(){
        return cola;
    }

    // Añadir elemento al final
    public void PushFront(T item) throws IOException {
        previous =  serialize();
        NodoGenerico NuevoNodo = new NodoGenerico();
        NuevoNodo.data = item;
        NuevoNodo.next = cabeza;
        cabeza = NuevoNodo;
        if (cola == null)
                cola = cabeza;
    }

    // Añadir elemento al inicio
    public void PushBack(T item) throws IOException {
        previous =  serialize();
        NodoGenerico NodoNuevo = new NodoGenerico();
        NodoNuevo.data = item;
        NodoNuevo.next = null;
        if (cola == null){
            cabeza = NodoNuevo;
            cola = NodoNuevo;
        }else {
            cola.next = NodoNuevo;
            cola = NodoNuevo;
        }
    } 

    // Extraer dato del final (cabeza)
    public T PopFront() throws IOException {
        previous =  serialize();
        NodoGenerico Apuntador = new NodoGenerico();
        Apuntador = cabeza;
        if (cabeza == null){
            cola = null;
            System.out.println("La Lista Esta Vacia");
        }
        cabeza = cabeza.next;
        return (T) Apuntador.data;
    }

    // Extraer dato del inicio (cola)
    public T PopBack() throws IOException {
        previous =  serialize();
        NodoGenerico Apuntador = new NodoGenerico();
        Apuntador = cabeza;
        T s;
        s = null;
        if (cabeza == null)
            System.out.println("La Lista Esta vacia");
        else if(cabeza == cola){
            cabeza = null;
            cola = null;
        }else{
            while(Apuntador.next.next != null){
                Apuntador = Apuntador.next;
            }
            s = (T) Apuntador.next.data;
            Apuntador.next = cola;
            cola = Apuntador;   
        }
        return s ;
    }

    // Metodo de insertar, añade un item en la ubicacion "node"
    public void AddAfter(NodoGenerico node , T item) throws IOException {
        previous =  serialize();
        NodoGenerico NuevoNodo = new NodoGenerico();
        NuevoNodo.data = item; 
        NuevoNodo.next = node.next;
        node.next = NuevoNodo;
        if (cola == node)
            cola = NuevoNodo;
    }

    // Metodo de Buscar - Retorna la primera ubicacion del item encontrado
    public T Buscar(int item){
        NodoGenerico Apuntador;
        Apuntador = cabeza;
        for(int i = 0 ; i< item-1;i++){
            Apuntador = Apuntador.next;
        }
        if(Apuntador != null){
            return (T) Apuntador.data;
        }

        return null;
    }

    // Este es bastante util cuando hay items repetidos

    public int[] Find(T item){
        int count = 0;
        NodoGenerico indice; 
        for(indice = cabeza ; indice != null ; indice = indice.next){
            count ++;
            if(item == indice.data){
            return new int[] {count,(Integer) indice.data};
            }
        }
        return null;
    }

}