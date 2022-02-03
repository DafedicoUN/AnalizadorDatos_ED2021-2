package stack;

class stack_array implements stack {
    int top, size;
    double[]stack;

    stack_array(int s){
        this.size=s;
        this.top=-1;
        this.stack=new double[s];
    }
    //definición de la pila vacia cuando top es igual a -1.
    boolean Empty(){
        return (top==-1);
    }
    //definicion de la pila llena cuando el top es igual al tamaño-1.
    boolean Full(){
        return (top==size-1);
    }
    //Agregar elemento a la pila.
    public void stacks(double data){
        //Verificar si la pila esta llena.
        if (Full()){
            System.out.println("Stack is full");
        }
        //top aumentara y el dato sera asignado a esta posicion.
        else{
            top++;
            stack[top]=data;
        }
    }
    //Elimar el elemento del top de la pila.
    public void unstack(){
        //Verificar si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack is empty");
        }
        //elimina el dato del top de la pila y reduce el tamaño de este.
        else{
            top--;
        }
    }
    //Buscar un dato dentro de la pila.
    public void stackFind(double find){
        //Verificar si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack is empty");
            return;
        }
        //hacer recorrido de la pila en busca del dato.
        else{
            for (int i=top;i>=0;i--){
                if (find==stack[i]){
                    System.out.println("found at pos:"+""+ i );
                    return ;
                }
            }
            System.out.println("Not found");
        }
    }
    //Imprime los elementos de la pila empezando por el top.
    public void stackDisplay(){
        //Verificar si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack is empty");
        }
        else{
            //imprimir los elementos desde el top hasta la posicion inferior de la pila.
            for (int i=top;i>=0;i--){
                if(i!=0){
                    System.out.print(stack[i]+" ,");
                }
                else {
                    System.out.print(stack[i]+"\n");
                }
            }
        }
    }
    //Vacia la pila.
    public void stackEmpty(){
        int i;
        //Verificar si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack is already empty");
        }
        //Asigna 0 a cada posicion de la pila.
        else{
            for( i=0;i<top+1;i++){
                stack[i]=0;
            }
            //resta la cantidad de posiciones al top, vaciando la lista.
            top-=i;
        }
    }
    //Busca el valor maximo en la pila.
    public void max(){
        //Verifica si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack  empty");
        }
        else{
            //Busca y comapara los valores de la pila con max.
            double max=0;
            for (int i=0;i<top+1;i++ ){
                if (stack[i]>max){
                    max=stack[i];
                }
            }
            System.out.println(max);
        }
    }
    //Busca el valor minimo en la pila.
    public void min(){
        //Verifica si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack  empty");
        }
        //Busca y comapara los valores de la pila con min.
        else{
            double min=Double.MAX_VALUE;
            for (int i=0;i<top+1;i++ ){
                if (stack[i]<min){
                    min=stack[i];
                }
            }
            System.out.println(min);
        }
    }
    //Resuelve el promedio de los valores de la pila.
    public void stackAverage(){
        //Verifica si la pila esta vacia.
        if (Empty()){
            System.out.println("Stack  empty");
        }
        else{
            //suma cada dato de la pila.
            double ad=0;
            for (int i=0; i<top+1;i++){
                ad +=stack[i];
            }
            //Imprime el promedio de los valores.
            System.out.println(ad/(top+1));
        }
    }
}

