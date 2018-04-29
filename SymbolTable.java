import java.util.ArrayList;
import java.util.HashMap;

class SymbolTable {
    private String name;
    public HashMap<String, AbstractSymbol> mainTable;

    /** Creates an empty symbol table. */
    public SymbolTable(String name) {
      this.mainTable=new HashMap();
    }

    public void addSymbol(String name, AbstractSymbol info){
       if( ! this.mainTable.containsKey( name) ){
        this.mainTable.put(name,info);
    }
  }

    public boolean existVar(String name, String var){
       if( ! this.mainTable.containsKey(var) ){
         AbstractSymbol as= this.mainTable.get(name);
         if(as.containsInParameters(var)){
          return true;
         }
         return false;
    }
    return true;
}

public void addLocalVar(String func_name, String var, AbstractSymbol info){
  AbstractSymbol as= this.mainTable.get(func_name);
  as.addVar(var,info);
}
}
