/* Generated By:JJTree: Do not edit this line. ASTCall.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTCall extends SimpleNode {
  private String FuncModule;
  public ASTCall(int id) {
    super(id);
  }

  public ASTCall(yal2jvm p, int id) {
    super(p, id);
  }

  public void setModule(String module){
    this.FuncModule = module;
  }


  public void process(BufferedWriter s,SymbolTable st,String funcName){
      this.func_name=funcName;
    try{
        if(children != null) {
          for (int i = 0; i < children.length; ++i) {
            if(children[i].getClass().getName() == "ASTArgumentList"){
            SimpleNode n = (SimpleNode)children[i];
            if (n != null) {
              ((ASTArgumentList)n).process2(s,st,funcName);
            }
          }
        }
      }
      if(this.name.equals("main")){
        s.write("aconst_null\n");
      }

      if(this.FuncModule != null){
        s.write("invokestatic " + this.FuncModule + "/" + this.name + "(");
      }else{
        s.write("invokestatic " + this.Module + "/" + this.name + "(");
      }

      if(this.name.equals("main")){
        s.write("[Ljava/lang/String;");
      }

      AbstractSymbol as = st.mainTable.get(this.name);
      if(children != null) {
        for (int i = 0; i < children.length; ++i) {
          if(children[i].getClass().getName() == "ASTArgumentList"){
          SimpleNode n = (SimpleNode)children[i];
          if (n != null) {
            ((ASTArgumentList)n).process(s,st,funcName);
          }
        }
      }
    }

      s.write(")");
      if(as != null){
        if(as.getReturnType() == "VOID"){
            s.write("V");
          }else if(as.getReturnType() == "ARRAY"){
            s.write("[I");
          }else if(as.getReturnType() == "INT"){
            s.write("I");
          }
    }else{
        s.write("V");
    }
      s.write("\n");
    }
    catch (IOException e)
    {
      System.out.println("Exception ");
    }
  }
  public String toString() { return yal2jvmTreeConstants.jjtNodeName[id] +" "+ this.name ; }


  public void semanticAnalysis(SymbolTable st)throws ParseException{

        SemanticAnalyzer.validateFunction(st,this);


  }


}
/* JavaCC - OriginalChecksum=c32fe0b0d9431b83835ebe20e8e6e067 (do not edit this line) */
