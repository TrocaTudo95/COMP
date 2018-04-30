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
       if( ! this.mainTable.containsKey(name)){
        this.mainTable.put(name,info);
    }
  }

    public boolean existVar(String name, String var){
       if( ! this.mainTable.containsKey(var) ){
         AbstractSymbol as= this.mainTable.get(name);
         if(as==null)
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

public String getTypeVariable(String func_name,String var){
  AbstractSymbol as = this.mainTable.get(var);
  if(as != null){
    return as.getDataType();
  }
  else{
    as = this.mainTable.get(func_name);
    if(as.returnsInParameters(var) != null){
      return as.returnsInParameters(var);
    }else{
      AbstractSymbol at = as.getSymbolTable().mainTable.get(var);
      if(at != null){
        return at.getDataType();
      }
      return null;
    }
  }
}

public String getVarType(String func_name, String var){
   AbstractSymbol as= mainTable.get(var);
   if(as!=null){
     return "GLOBAL";
   }
   else{
     as=mainTable.get(func_name);
     ()
   }
 }

}
