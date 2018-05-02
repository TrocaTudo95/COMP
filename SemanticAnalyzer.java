import java.util.ArrayList;

public class SemanticAnalyzer {

static int  i_err=-798;
    public static boolean checkVarArray(SymbolTable t, String name, String func_name){
        if( ! t.getTypeVariable(func_name, name).equals("ARRAY")){
            System.out.println("Semantic error - The variable "+name+ " is not an array");
            return false;
        }
        return true;
    }


    public static boolean checkVarInitialized(SymbolTable t, String name, String func_name){

        int init = t.getInitializationOfSymbol(func_name, name);
        if(init == -3){
            System.out.println("Semantic error - The variable "+name+ " is not initialized");
            return false;
        }
        return true;
    }


    public static boolean checkVarExists(SymbolTable t, String name, String func_name,int line)throws ParseException{
      int result;
      String err;
         result=t.checkVarExists( name,func_name,line);
         if(result==0){
          err="Semantic error - The variable "+name+ "used on line "+line+" was not declared;";
          yal2jvm.error_skipto(i_err,err);
            return false;
        }
        if(result==2){
           err="Semantic error - The variable "+name+ " was not declared before being used on line "+line;
           yal2jvm.error_skipto(i_err,err);
           return false;
       }
        return true;
    }



    public static boolean checkVarScalar(SymbolTable t, String name, String func_name){
        if(!t.getTypeVariable(func_name,name).equals("INT")){
            System.out.println("Semantic error - The variable "+name+ " is not a scalar");
            return false;
        }
        return true;
    }

    public static boolean checkIfInt(SymbolTable t, String name, String func_name,SimpleNode nd){
      if(t.getTypeVariable(func_name,name).equals("INT")){
        return true;
      }
      else{
        if(nd.jjtGetChild(0).getClass().getName()=="ASTArrayAccess"){
            if(nd.jjtGetChild(0).jjtGetChild(0).getClass().getName()=="ASTIndex")
            return true;

        }

      }
      return false;
    }



    /*
     * Validates a function call
     */
    public static boolean validateFunction(SymbolTable t, SimpleNode nd)throws ParseException{

        String call_name = nd.getName();
        ASTArgumentList call;
        //TODO funcoes nao feitas por mim
        //if(nd.jjtGetNumChildren()==0)

         call = (ASTArgumentList)nd.jjtGetChild(0);
         String err;


         if(t.mainTable.get(call_name)==null){
            return true;
          }

        ArrayList<String> names = t.mainTable.get(call_name).getParameters();
        ArrayList<String> types=  t.mainTable.get(call_name).getTypes();

        if(names==null){
          err="Semantic error - The function "+call_name+" does not exist";
          yal2jvm.error_skipto(i_err,err);
            //System.out.println("Semantic error - The function "+call_name+" does not exist");
            return false;
        }
        else{
            /* check the number of parameters */
            int nArgs=0;
            if( call.jjtGetNumChildren()!=0 ){

                nArgs = call.jjtGetNumChildren();
            }
            if(nArgs != names.size()){
              err="Semantic error - number of arguments in function "+call_name;
                yal2jvm.error_skipto(i_err,err);
                return false;
            }
            else if(call.jjtGetNumChildren()!=0) {


                for(int i = 0; i < nArgs; i++){

                    boolean res=false;

                    SimpleNode test = (SimpleNode)call.jjtGetChild(i);

                    if( test instanceof ASTArgument ){
                        //check if variable exists
                        if(test.getName()!=null){
                        if(! checkVarExists(t, test.getName(), test.getFuncName(),test.getToken().beginLine )) {
                            return false;
                        }

                        //check the type of each variable
                          String type = t.getTypeVariable(test.getFuncName(),test.getName());


                        //err="the type is: "+ type+" and it should be: "+types.get(i);
                          //yal2jvm.error_skipto(i_err,err);
                        res =  types.get(i).equals(type);
                      }
                      else{
                        if(((ASTArgument)test).getInt()!=-2){
                          types.get(i).equals("INT");
                          res=true;
                        }
                      }
                    }



                    if(!res){
                      int h=i+1;
                      err="Semantic Error - Argument "+test.getName()+" do not match with the "+h +"º argument of the function " +call_name;
                         yal2jvm.error_skipto(i_err,err);
                        return false;
                    }
                }
            }
            return true;
        }
    }




    /*
     * Checks if a comparison is valid
     */
    public static boolean comparison(SymbolTable t, SimpleNode nd)throws ParseException{
        if(nd.jjtGetNumChildren()==1 )
          return false;
        ASTAccessElement var = (ASTAccessElement) nd.jjtGetChild(0).jjtGetChild(0);
        ASTRhs rhs = (ASTRhs) nd.jjtGetChild(1);
        //check var
        if(var!=null){
          if(checkVarExists(t, var.getName(), var.getFuncName(),var.getToken().beginLine )){
            if(!checkIfInt(t,var.getName(), var.getFuncName(),var)){
              System.out.println("PUTAA");
        }
      }
}
    return false;
}



    /*
     *  Checks the assignment of a scalar
     */
    public String nonIntegerAssignment(Node node, SymbolTable t)throws ParseException{

        SimpleNode nn = (SimpleNode)node;
        String name = nn.getName();
        String func_name = nn.getFuncName();
        int line = nn.getToken().beginLine;

        if(nn.children==null && checkVarExists(t, name, func_name, line) && checkVarInitialized(t,name, func_name)){   //a=N

            if(t.getTypeVariable(func_name, name).equals("ARRAY")){
                return "Array";
            }
            else if( checkVarScalar(t, name, func_name) && checkVarInitialized(t,name, func_name)){
                return "Scalar";
            }
        }

        else if(nn.children!=null){

            SimpleNode nd = (SimpleNode)nn.children[0];
            name = nd.getName();
            func_name = nd.getFuncName();
            line = nd.getToken().beginLine;

            if(nd instanceof ASTArrayAccess ){  //a=N[x]

                if(! ( checkVarExists(t, name, func_name, line) && checkVarInitialized(t, name, func_name) &&checkVarArray(t, name, func_name))) return null;

                nd = (SimpleNode)nd.children[0];
                name = nd.getName();
                func_name = nd.getFuncName();
                line = nd.getToken().beginLine;

                if(nd instanceof ASTIndex ){  //a=N[b]

                    if( checkVarExists(t, name, func_name, line) && checkVarScalar(t, name, func_name)&& checkVarInitialized(t,name, func_name)){
                        return "Scalar";
                    }
                    else {
                        return null;
                    }
                }

                else if(nd instanceof ASTArraySize){   //a=N[0]
                    return "Scalar";
                }
            }

            else if(nd instanceof ASTScalarAccess ){ //a=N.size

                if(! ( checkVarExists(t, name, func_name, line) && checkVarArray(t, name, func_name))) return null;
                return "Scalar";
            }

            else if(nd instanceof ASTFunction){   //a=N.b()
                return "Scalar";
            }

            else if(nd instanceof ASTCall){  //a=N()

                try{
                  if(validateFunction(t, nd)){
                      String type = t.getRetType(nd.getName());
                      if(type.equals("void")){
                          System.out.println("Semantic error - Assigning a variable to a void function");
                          return null;
                      }
                      return type;
                  }
                }
                catch(Exception e){
                  return null;
                }
            }
        }
        return null;
    }
}
