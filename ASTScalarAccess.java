/* Generated By:JJTree: Do not edit this line. ASTScalarAccess.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTScalarAccess extends SimpleNode {
  protected String t = "F";
  public ASTScalarAccess(int id) {
    super(id);
  }

  public ASTScalarAccess(yal2jvm p, int id) {
    super(p, id);
  }

  public void setSize(String t){
    this.t=t;
  }
  public String getSize(){
    return this.t;
  }
  public void process(BufferedWriter s,SymbolTable st,String funcName){
    this.func_name=funcName;
    try{
      if(this.t == "T"){
      s.write("arraylength\n");
    }

    }catch (IOException e)
        {
          System.out.println("Exception ");

        }
  }

}
/* JavaCC - OriginalChecksum=4bd0a6f4f8a76e0c680b63da6f7540c7 (do not edit this line) */
