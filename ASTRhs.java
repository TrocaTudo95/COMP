/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTRhs extends SimpleNode {
  private String operation;
  protected String type;
  public ASTRhs(int id) {
    super(id);
  }

  public ASTRhs(yal2jvm p, int id) {
    super(p, id);
  }

  public void setOperation(String operation){
  this.operation=operation;
  }

  public String getOperation(){
    return this.operation;
  }

  public void setType(String type){
    this.type = type;
  }

  public String getType(){
    return this.type;
  }

public void process(BufferedWriter s,SymbolTable st,String funcName){
this.func_name=funcName;
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
          SimpleNode n = (SimpleNode)children[i];
          if (n != null) {
            n.process(s,st,funcName);
        }
      }
  }

  try{
    if(this.operation != null){
        if(this.operation.equals("*")){
            s.write("imul\n");
          }
          else if(this.operation.equals("/")){
            s.write("idiv\n");
          }
          else if(this.operation.equals("<<")){
            s.write("ishl\n");
          }
          else if(this.operation.equals(">>")){
            s.write("ishr\n");
          }
          else if(this.operation.equals(">>>")){
            s.write("iushr\n");
          }
          else if(this.operation.equals("+")){
            s.write("iadd\n");
          }
          else if(this.operation.equals("-")){
            s.write("isub\n");
          }
        }
    }catch (IOException e)
      {
        System.out.println("Exception ");

      }

}

@Override
public String toString() {
  if(this.operation!=null)
  return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name + "  operator:" + this.operation;
  else
  return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name ;
}

}
/* JavaCC - OriginalChecksum=382452feeb0e2b1ea4adcce00e40f8b4 (do not edit this line) */
