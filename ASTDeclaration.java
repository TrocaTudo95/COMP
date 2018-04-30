/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.io.*;
import java.util.*;

public
class ASTDeclaration extends SimpleNode {

  private int element_id;
  private int element_value;
  private String signal;
  private String type;


  public ASTDeclaration(int id) {
    super(id);
  }

  public ASTDeclaration(yal2jvm p, int id) {
    super(p, id);
  }

  public String getType(){
    return this.type;
  }

  public void process(BufferedWriter s,SymbolTable st){
    try{
      s.write(".field static ");

      if (children != null) {
        for (int i = 0; i < children.length; ++i) {
          SimpleNode n = (SimpleNode)children[i];
          if(n != null){
            n.process(s,st);
          }
        }
      }
      s.write("\n");
    }
    catch (IOException e)
    {
      System.out.println("Exception ");
    }

  }

  public void setElementId(int id){
    this.element_id =id;
  }

  public void setType(String type){
    this.type = type;
  }

  public void setSignal(String signal){
    this.signal=signal;
  }

  public void setElementValue(String value){
    String finalValue;
    if(this.signal!=null)
    finalValue= this.signal +value;
    else
    finalValue=value;


    this.element_value=Integer.parseInt(finalValue);
  }

  @Override
  public String toString() {
    return yal2jvmTreeConstants.jjtNodeName[id] + " " + this.name  + "element id:" + this.element_id +" "+ "element value:"+ this.element_value;
  }

    public AbstractSymbol getSymbol(){
      String name="";
      String data_type="";
      for(int i=0; i<children.length;i++){
        SimpleNode n = (SimpleNode)children[i];
        if(n instanceof ASTArraySize){
          data_type="ARRAY";
        }
        if(n instanceof ASTElement){
          name=n.getName();
        }
    }
      return new AbstractSymbol(name,data_type,null,this.element_value,null,null);
}
}
/* JavaCC - OriginalChecksum=5d869d09fafa3370307ad4a40f0167bb (do not edit this line) */
