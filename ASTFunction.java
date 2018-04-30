/* Generated By:JJTree: Do not edit this line. ASTFunction.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTFunction extends SimpleNode {
  protected String return_type;
  protected String return_name;

  public ASTFunction(int id) {
    super(id);
  }

  public ASTFunction(yal2jvm p, int id) {
    super(p, id);
  }
    public String toString() { return yal2jvmTreeConstants.jjtNodeName[id] +" "+ this.name + " " + this.return_type; }

    public void setReturn(String retorno){
      this.return_name =retorno;
    }

    public void setReturnType(String retorno){
      this.return_type =retorno;
    }
    public String getReturnType(){
      return  this.return_type;
    }

  public AbstractSymbol getSymbol(){
    ArrayList<String> args_type=new ArrayList();
    ArrayList<String> args_name=new ArrayList();
    String rt="";
    for(int i=0; i<children.length;i++){
      SimpleNode n = (SimpleNode)children[i];
      if(n instanceof ASTVarlist){

        for(int j=0; j<n.jjtGetNumChildren();j++){
          SimpleNode m = (SimpleNode)n.jjtGetChild(j);
          if(m instanceof ASTElement){
            args_name.add(m.getName());
            if(((ASTElement)m).getDataType().equals("I"))
              args_type.add("INT");
            else
            args_type.add("ARRAY");

          }
        }

      }
    }

    if(this.return_type.equals("V"))
    rt="VOID";
    else if(this.return_type.equals("I"))
      rt="INT";
      else if(this.return_type.equals("[I"))
      rt="ARRAY";
   AbstractSymbol as= new AbstractSymbol(this.name,null,rt,0,args_type,args_name);
  return as;
  }



  public SymbolTable getFunctionTable(SymbolTable st){
    return null;
  }



  public void process(BufferedWriter s, SymbolTable st){
    try{
    s.write(".method public static " + this.name + "(");

    if(this.name.equals("main")){
      s.write("[Ljava/lang/String;");
    }

    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTVarlist"){
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.process(s,st,this.name);
        }
      }
    }
  }
    s.write(")"+ this.return_type +"\n");
    s.write(".limit locals " + "\n");
    s.write(".limit stack " + "\n");

    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() != "ASTVarlist"){
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
            n.process(s,st,this.name);
        }
      }
    }
  }

    s.write("return\n");
    s.write(".end method\n");
  }
    catch (IOException e)
    {
      System.out.println("Exception ");

    }
  }


  public void functionTable(SymbolTable st){
    if(children != null) {
      for (int i = 0; i < children.length; ++i) {
        if(children[i].getClass().getName() == "ASTStmtlst"){
        ASTStmtlst n = (ASTStmtlst)children[i];
        if (n != null) {
          n.lookForLocals(this.name,st);
        }
      }
    }
  }

  }

}
/* JavaCC - OriginalChecksum=a2652e971e8086c1460c0bacb6e77b08 (do not edit this line) */
