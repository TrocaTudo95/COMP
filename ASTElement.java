/* Generated By:JJTree: Do not edit this line. ASTElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTElement extends SimpleNode {
    private int element_value;
    private String data_type;
  public ASTElement(int id) {
    super(id);
  }

  public ASTElement(yal2jvm p, int id) {
    super(p, id);
  }

  public void process(BufferedWriter s, SymbolTable st,String funcName){

    ASTModule.addToStack(this.name);
    
    try{
      if(this.parent.getClass().getName() == "ASTDeclaration"){
        s.write(this.name);
        if(((ASTDeclaration)this.parent).getType() == "[I"){
          s.write(" [I");
        }
        else{
          s.write(" I");
        }

      }
      else if(this.parent.getClass().getName() == "ASTVarlist"){
        s.write(this.data_type);
      }
    }
    catch (IOException e)
    {
      System.out.println("Exception ");
    }
  }


  public String toString() { return yal2jvmTreeConstants.jjtNodeName[id] +" "+ this.name+ " "+this.data_type; }

  public void setType(String type){
    this.data_type=type;
  }
  public String getDataType(){
    return this.data_type;
  }

}
/* JavaCC - OriginalChecksum=7f1cfe67082e41c8828d6fe7adf06671 (do not edit this line) */
