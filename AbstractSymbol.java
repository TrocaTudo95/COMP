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
    protected int symbol_line;


    public AbstractSymbol(String str,String data_type, String return_type,int initial_value,ArrayList<String> parameters_type,ArrayList<String> parameters_name,int symbol_line) {
	     this.str = str;
       this.data_type=data_type;
       this.return_type=return_type;
       this.initial_value=initial_value;
       this.parameters_type=parameters_type;
       this.parameters_name=parameters_name;
       this.st= new SymbolTable(str);
       this.symbol_line=symbol_line;
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
    public SymbolTable getSymbolTable(){
      return this.st;
    }

    /** Returns a printable representation of this symbol. */
    public String toString() {
	return str;
    }

    public String getReturnType(){
      return return_type;
    }

    public ArrayList<String> getTypes(){
      return this.parameters_type;
    }
    public ArrayList<String> getParameters(){
      return this.parameters_name;
    }

    public String getDataType(){
      return this.data_type;
    }

    public int getInitialValue(){
      return this.initial_value;
    }


    public void addVar(String var,AbstractSymbol info){
      this.st.mainTable.put(var,info);
    }

    public int getLine(){
      return this.symbol_line;
    }

    public void print(){
      System.out.println("Name:"+this.str);
      System.out.println("Data_Type:"+this.data_type);
      System.out.println("Return_type:"+this.return_type);
      System.out.println("Initial_value:"+this.initial_value);
      System.out.println("Parameters_type:"+this.parameters_type);
      System.out.println("Parameters_name:"+this.parameters_name);
      System.out.println("line:"+this.symbol_line+ "\n\n");
    }

    public String returnsInParameters(String var){
      for(int i=0; i< parameters_name.size();i++){
        if(parameters_name.get(i).equals(var))
          return parameters_type.get(i);
      }
      return null;
    }

}
