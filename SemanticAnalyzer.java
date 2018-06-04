import java.util.ArrayList;

public class SemanticAnalyzer {
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
          err="Semantic error - The variable "+name+ " used on line "+line+" was not declared;";
          System.out.println(err);
          yal2jvm.error_counter++;
            return false;
        }
          else if(result==2){
            System.out.println("RESULT: "+result);
           err="Semantic error - The variable "+name+ " was not declared before being used on line "+line;
           System.out.println(err);
           yal2jvm.error_counter++;
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
        if(nd.jjtGetNumChildren()==0){
          return true;
        }

         call = (ASTArgumentList)nd.jjtGetChild(0);
         String err;


         if(t.mainTable.get(call_name)==null){
            return true;
          }

        ArrayList<String> names = t.mainTable.get(call_name).getParameters();
        ArrayList<String> types=  t.mainTable.get(call_name).getTypes();

        if(names==null){
          err="Semantic error - The function "+call_name+" does not exist on line "+call.getToken().beginLine;
          System.out.println(err);
          yal2jvm.error_counter++;
            return false;
        }
        else{
            /* check the number of parameters */
            int nArgs=0;
            if( call.jjtGetNumChildren()!=0 ){

                nArgs = call.jjtGetNumChildren();
            }
            if(nArgs != names.size()){
              err="Semantic error - number of arguments in function "+call_name +"on line "+call.getToken().beginLine;
              System.out.println(err);
              yal2jvm.error_counter++;
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
                      System.out.println(err);
                      yal2jvm.error_counter++;
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
      String err;
        if(nd.jjtGetNumChildren()==1 ||nd.jjtGetNumChildren()==0)
          return false;
        ASTAccessElement var = (ASTAccessElement) nd.jjtGetChild(0).jjtGetChild(0);
        ASTRhs rhs = (ASTRhs) nd.jjtGetChild(1);
        //check var
        if(var!=null){
          //System.out.println("Var name: "+var.getName()+" var function: "+var.getFuncName());
          if(checkVarExists(t, var.getName(), var.getFuncName(),var.getToken().beginLine )){
            if(!checkIfInt(t,var.getName(), var.getFuncName(),var)){
              err="Semantic Error- the var "+var.getName() +" cannot be matched to a INT type in line "+var.getToken().beginLine;
              System.out.println(err);
              yal2jvm.error_counter++;
        }
      }
}

        if(rhs!=null){
          if(rhs.jjtGetChild(0).getClass().getName()=="ASTTerm" && ((ASTTerm)rhs.jjtGetChild(0)).getValue()!=-99){
            return true;
          }
          if(rhs.jjtGetChild(0).getClass().getName()=="ASTScalarAccess"){
            return true;
          }
            else if(rhs.jjtGetChild(0).getClass().getName()=="ASTTerm"){
              if(rhs.jjtGetChild(0).jjtGetChild(0).getClass().getName()=="ASTAccessElement"){
                var=(ASTAccessElement)rhs.jjtGetChild(0).jjtGetChild(0);
                if(var!=null){
                  if(checkVarExists(t, var.getName(), var.getFuncName(),var.getToken().beginLine )){
                     if(var.jjtGetChild(0).getClass().getName().equals("ASTScalarAccess") && ((ASTScalarAccess)var.jjtGetChild(0)).getSize().equals("T"))
                     {
                      return true;
                    }
                       else if(!checkIfInt(t,var.getName(), var.getFuncName(),var)){
                      err="Semantic Error- the var "+var.getName() +" cannot be matched to a INT type to be compared in line "+var.getToken().beginLine;
                      System.out.println(err);
                      yal2jvm.error_counter++;
                }

              }
        }

              }
              else if(rhs.jjtGetChild(0).jjtGetChild(0).getClass().getName()=="ASTCall"){
                if(t.mainTable.get(((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName())==null)
                  return true;
                if(t.mainTable.get(((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName()).getReturnType()=="VOID"){
                err="Semantic Error- the function "+((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName() +" is void on line"+((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getToken().beginLine;
                System.out.println(err);
                yal2jvm.error_counter++;
              }
              }


          }


            }
    return false;
}


public static boolean assignment(SymbolTable t, SimpleNode nd)throws ParseException{
  String err;
    if(nd.jjtGetNumChildren()==1 ||nd.jjtGetNumChildren()==0)
      return false;
    ASTAccessElement var = (ASTAccessElement) nd.jjtGetChild(0).jjtGetChild(0);
    ASTRhs rhs = (ASTRhs) nd.jjtGetChild(1);
    //check var

    if(rhs!=null){
      if(rhs.jjtGetChild(0).getClass().getName()=="ASTTerm" && ((ASTTerm)rhs.jjtGetChild(0)).getValue()!=-99){
        return true;
      }
      else if(rhs.jjtGetChild(0).getClass().getName()=="ASTArraySize"){
        return true;
      }
        else if(rhs.jjtGetChild(0).getClass().getName()=="ASTTerm"){
          if(rhs.jjtGetChild(0).jjtGetChild(0).getClass().getName()=="ASTAccessElement"){
            var=(ASTAccessElement)rhs.jjtGetChild(0).jjtGetChild(0);
            if(var!=null){
              if(checkVarExists(t, var.getName(), var.getFuncName(),var.getToken().beginLine )){
                 if(var.jjtGetChild(0).getClass().getName().equals("ASTScalarAccess") && ((ASTScalarAccess)var.jjtGetChild(0)).getSize().equals("T"))
                 {
                  return true;
                }
                   else if(!checkIfInt(t,var.getName(), var.getFuncName(),var)){
                  err="Semantic Error- the var "+var.getName() +" cannot be matched to a INT type in line "+var.getToken().beginLine;
                  System.out.println(err);
                  yal2jvm.error_counter++;
            }

          }
    }

          }
          else if(rhs.jjtGetChild(0).jjtGetChild(0).getClass().getName()=="ASTCall"){
            if(t.mainTable.get(((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName())==null)
              return true;
            if(t.mainTable.get(((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName()).getReturnType()=="VOID"){
            err="Semantic Error- the function "+((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getName() +" is void on line"+((SimpleNode)rhs.jjtGetChild(0).jjtGetChild(0)).getToken().beginLine;
            System.out.println(err);
            yal2jvm.error_counter++;
          }
          }


      }


        }
return false;
}




}
