/* Generated By:JJTree: Do not edit this line. ASTAssign.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTAssign extends SimpleNode {
  protected String array;
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
    String rhsV = "dir";
    String lhsV = "esq";
try{
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTRhs"){
          if(((ASTRhs)children[i]).getType() == "ND"){
            for(int n=0;n < children[i].jjtGetNumChildren();n++){
              if(children[i].jjtGetChild(n).getClass().getName() == "ASTTerm"){
                for(int k=0;k < children[i].jjtGetChild(n).jjtGetNumChildren();k++){
                  if(children[i].jjtGetChild(n).jjtGetChild(k).getClass().getName() == "ASTAccessElement"){
                    rhsV = ((ASTAccessElement)children[i].jjtGetChild(n).jjtGetChild(k)).getName();
                  }
                }
              }
            }
          }
        }
      }
    }

  if (children != null) {
    for (int i = 0; i < children.length; ++i) {
      if(children[i].getClass().getName() == "ASTLhs"){
        for(int n=0;n < children[i].jjtGetNumChildren();n++){
          if(children[i].jjtGetChild(n).getClass().getName() == "ASTAccessElement"){
                lhsV = ((ASTAccessElement)children[i].jjtGetChild(n)).getName();
              }
            }
          }
        }
      }

      if(rhsV.equals(lhsV)){
        for(int j=0; j < ASTModule.getStack().size();j++){
            if(ASTModule.getStack().contains(rhsV)){
                if (children != null) {
                  for (int i = 0; i < children.length; ++i) {
                    if(children[i].getClass().getName() == "ASTRhs"){
                      if(((ASTRhs)children[i]).getType() == "ND"){
                        for(int n=0;n < children[i].jjtGetNumChildren();n++){
                          if(children[i].jjtGetChild(n).getClass().getName() == "ASTTerm"){
                            if(((ASTTerm)children[i].jjtGetChild(n)).getType() == "INT" && ((ASTTerm)children[i].jjtGetChild(n)).getValue() < 1000000 && ((ASTTerm)children[i].jjtGetChild(n)).getValue() > 0){
                              if(((ASTRhs)children[i]).getOperation().equals("-")){
                                  s.write("iinc " + ASTModule.getStack().indexOf(rhsV) + " -" + ((ASTTerm)children[i].jjtGetChild(n)).getValue()+"\n\n");
                                  rhsV="dir";
                                  lhsV="esq";
                              }else{
                              s.write("iinc " + ASTModule.getStack().indexOf(rhsV) + " " + ((ASTTerm)children[i].jjtGetChild(n)).getValue()+"\n\n");
                              rhsV="dir";
                              lhsV="esq";
                            }
                          }
                          }
                        }
                      }
                    }
                  }
                }

            }
        }
      }else{
        //Se o lhs for array é primeiro impresso o lhs
        if (children != null) {
          for (int i = 0; i < children.length; ++i) {
            if(children[i].getClass().getName() == "ASTLhs"){
              for(int j=0; j < children[i].jjtGetNumChildren(); j++){
                if(((ASTAccessElement)children[i].jjtGetChild(j)).getType() == "ARRAY"){
                  this.array="TRUE";
                }
              }
            }
          }
        }
      if(this.array == "TRUE"){
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

        s.write("iastore\n\n");

      }else{
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
              s.write("\n");
              }
            }
          }
        }
      }
      }
    }
  catch (IOException e)
  {
    System.out.println("Exception ");
  }

}

public void semanticAnalysis(SymbolTable st)throws ParseException{
  SemanticAnalyzer.comparison(st,this);
}

}
/* JavaCC - OriginalChecksum=b822ef442d50fb2875ef08544f450a7d (do not edit this line) */
