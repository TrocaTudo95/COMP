/* Generated By:JJTree: Do not edit this line. ASTAccessElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTAccessElement extends SimpleNode {
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
             AbstractSymbol as=new AbstractSymbol(this.name,"INT",null,0,null,null);
            st.addLocalVar(func_name,this.name,as);
          }
        }
      }
      else if(children[i].getClass().getName() == "ASTArrayAccess"){
      ASTArrayAccess n = (ASTArrayAccess)children[i];
      if (n != null) {
        if(!st.existVar(func_name,this.name)){
           AbstractSymbol as=new AbstractSymbol(this.name,"ARRAY",null,0,null,null);
          st.addLocalVar(func_name,this.name,as);
        }
      }
    }
    }
  }
  }


}
/* JavaCC - OriginalChecksum=5cb57520f1b7d6f77670f63c633c5392 (do not edit this line) */
