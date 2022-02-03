package list;

public class listaGenerica<T>
{
    public class NodoGenerico<T>
    {
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
    public void PushFront(T item)
    {
        NodoGenerico NuevoNodo = new NodoGenerico();
        NuevoNodo.data = item;
        NuevoNodo.next = cabeza;
        cabeza = NuevoNodo;
        if (cola == null)
                cola = cabeza;
    }

    // Añadir elemento al inicio
    public void PushBack(T item){
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
    public T PopFront(){
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
    public T PopBack(){
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
    public void AddAfter(NodoGenerico node , T item){
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
        return (T) Apuntador.data;
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
    
    ////// METODOS DE PRUEBA

    // MAIN - Prueba del metodo

    public static void main(String[] args)
    {
        // Insertar en n posicion, exportar, Buscar y Promedio
        
        int tamañoPrueba =50000000;

        listaGenerica<Integer> test = new listaGenerica<>();
        System.out.println("Lista generica creada");

        long t_inicio=System.nanoTime();

        for(int i=0;i<tamañoPrueba;i++)
        {
            test.PushFront(i);
        }
        System.out.println("Lista generica llenada con " + tamañoPrueba + " datos");
        
        long t_final=System.nanoTime();

        System.out.println("Tiempo de llenado con " + tamañoPrueba + " datos, fue: " + (t_final-t_inicio) + " ns");

        // Insercion en 2da Posicion

        t_inicio=System.nanoTime();
        test.PushBack(2);
        t_final=System.nanoTime();

        System.out.println("Tiempo de insercion con " + tamañoPrueba + " datos, fue: " + (t_final-t_inicio) + " ns");

        // Buscar el n-1 esimo elemento
        
        Integer a = tamañoPrueba - 1;

        t_inicio = System.nanoTime();
        int resultado = test.Buscar(a);
        t_final = System.nanoTime();

        System.out.println("Tiempo de busqueda del n-1 elemento con " + tamañoPrueba + " datos, fue: " + (t_final-t_inicio) + " ns");

        
        
        
        // hallar promedio matemático
        t_inicio=System.nanoTime();
        int acomulado=0;
        for(int i=0;i<tamañoPrueba;i++)
        {
            acomulado = acomulado + test.PopFront();
        }
        float promedio=acomulado/tamañoPrueba;
        t_final=System.nanoTime();

        System.out.println("Tiempo de Promedio con " + tamañoPrueba + " datos, fue: " + (t_final-t_inicio) + " ns");
    }

}