/* Generated By:JJTree: Do not edit this line. ASTAssign.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTAssign extends SimpleNode {
  public ASTAssign(int id) {
    super(id);
  }

  public ASTAssign(yal2jvm p, int id) {
    super(p, id);
  }

  public boolean isArray(){
    if(this.children != null) {
      for (int i = 0; i < this.children.length; i++) {
      if(this.children[i].getClass().getName() == "ASTRhs"){
        ASTRhs n = (ASTRhs)children[i];
        for(int j=0;j<n.jjtGetNumChildren();j++){
          if(n.jjtGetChild(j).getClass().getName()=="ASTArraySize")
          return true;
        }
        return false;
      }
  }
}
return false;
}


  public void lookForLocals(String func_name, SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTLhs"){
        ASTLhs n = (ASTLhs)children[i];
        if (n != null) {
          n.lookForLocals(func_name,st);

        }
      }
    }
  }
  }

  public void process(BufferedWriter s,SymbolTable st,String funcName){
    this.func_name=funcName;
    //Rhs
      if (children != null) {
        for (int i = 0; i < children.length; ++i) {
          if(children[i].getClass().getName() == "ASTRhs"){
          ASTRhs n = (ASTRhs)children[i];
          if (n != null) {
            n.process(s,st,funcName);
          }
        }
      }
    }

    //Lhs
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTLhs"){
        ASTLhs n = (ASTLhs)children[i];
        if (n != null) {
          n.process(s,st,funcName);
          }
        }
      }
    }


  }

  public void semanticAnalysis(SymbolTable st)throws ParseException{
    SemanticAnalyzer.assignment(st,this);
  }

}
/* JavaCC - OriginalChecksum=b822ef442d50fb2875ef08544f450a7d (do not edit this line) */
