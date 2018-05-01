/* Generated By:JJTree: Do not edit this line. ASTAccessElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTAccessElement extends SimpleNode {
  protected static ArrayList<String> store_i = new ArrayList<String>();
  protected static ArrayList<String> store_a = new ArrayList<String>();
  public ASTAccessElement(int id) {
    super(id);
  }

  public ASTAccessElement(yal2jvm p, int id) {
    super(p, id);
  }
  public String toString() { return yal2jvmTreeConstants.jjtNodeName[id] +" "+ this.name; }

  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTScalarAccess"){
        ASTScalarAccess n = (ASTScalarAccess)children[i];
        if (n != null) {
          if(!st.existVar(func_name,this.name)){
             AbstractSymbol as=new AbstractSymbol(this.name,"INT",null,0,null,null,firstToken.beginLine);
            st.addLocalVar(func_name,this.name,as);
            //as.print();
          }
        }
      }
      else if(children[i].getClass().getName() == "ASTArrayAccess"){
      ASTArrayAccess n = (ASTArrayAccess)children[i];
      if (n != null) {
        if(!st.existVar(func_name,this.name)){
           AbstractSymbol as=new AbstractSymbol(this.name,"ARRAY",null,0,null,null,firstToken.beginLine);
          st.addLocalVar(func_name,this.name,as);
          //as.print();
        }
      }
    }
    }
  }
  }

  public void process(BufferedWriter s,SymbolTable st,String funcName){
    try{
    if(this.parent.getClass().getName() == "ASTLhs"){
      if(st.getVarType(funcName, this.name) == "GLOBAL" || st.getVarType(funcName, this.name) == "PARAMETER"){
        if(st.getTypeVariable(funcName, this.name) == "INT"){
          s.write("putstatic " + this.Module + "/" + this.name + " I \n");
        }
        if(st.getTypeVariable(funcName, this.name) == "ARRAY"){
          s.write("putstatic " + this.Module + "/" + this.name + " [I \n");
        }
      }
      if(st.getVarType(funcName, this.name) == "LOCAL"){

        if(st.getTypeVariable(funcName, this.name) == "INT"){

          if(this.store_i.size() <= 3)
            s.write("istore_");
          else
            s.write("istore ");

            if(this.store_i.contains(this.name)){
              s.write(this.store_i.indexOf(this.name)+1 + "\n");
            }else{
              this.store_i.add(this.name);
              s.write(this.store_i.size() + "\n");
            }
          }
        if(st.getTypeVariable(funcName, this.name) == "ARRAY"){

            if(this.store_a.size() <= 3)
              s.write("astore_");
            else
              s.write("astore ");

              if(this.store_a.contains(this.name)){
                s.write(this.store_a.indexOf(this.name)+1 + "\n");
              }else{
                this.store_a.add(this.name);
                s.write(this.store_a.size() + "\n");
              }
            }
          }
        }

        //rhs
        if(this.parent.getClass().getName() == "ASTTerm"){
          //ola
        }

      }catch (IOException e)
        {
          System.out.println("Exception ");
        }
  }


}
/* JavaCC - OriginalChecksum=5cb57520f1b7d6f77670f63c633c5392 (do not edit this line) */
