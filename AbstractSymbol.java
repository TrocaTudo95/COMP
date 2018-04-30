import java.io.PrintStream;
import java.util.ArrayList;



 class AbstractSymbol {

    /** The stored string */
    protected String str;
    protected String data_type;
    protected String return_type;
    protected int initial_value;
    protected ArrayList<String> parameters_type;
    protected ArrayList<String> parameters_name;
    protected SymbolTable st;



    public AbstractSymbol(String str,String data_type, String return_type,int initial_value,ArrayList<String> parameters_type,ArrayList<String> parameters_name) {
	     this.str = str;
       this.data_type=data_type;
       this.return_type=return_type;
       this.initial_value=initial_value;
       this.parameters_type=parameters_type;
       this.parameters_name=parameters_name;
       this.st= new SymbolTable(str);
    }

    public boolean containsInParameters(String var){
      for(int i=0; i< parameters_name.size();i++){
        if(parameters_name.get(i).equals(var))
        return true;
      }
      if(this.st.mainTable.containsKey(var))
        return true;
        else
      return false;
    }

    /** Returns the string representation of this symbol. */
    public String getString() {
	return str;
    }

    /** Returns a printable representation of this symbol. */
    public String toString() {
	return str;
    }
    public void addVar(String var,AbstractSymbol info){
      this.st.mainTable.put(var,info);
    }

    public void print(){
      System.out.println("Name:"+this.str);
      System.out.println("Data_Type:"+this.data_type);
      System.out.println("Return_type:"+this.return_type);
      System.out.println("Initial_value:"+this.initial_value);
      System.out.println("Parameters_type:"+this.parameters_type);
      System.out.println("Parameters_name:"+this.parameters_name+ "\n\n");
    }

}
