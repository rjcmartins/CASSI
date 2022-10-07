package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoCEP {

public static final int TIMEOUT = 300;

/**
 *
 * BlocoCEP
 *
 * @author Rafael Juan Cardoso Martins
 * @since 04/10/2022 12:10:52
 *
 */
public static Var ConsultarCEP() throws Exception {
 return new Callable<Var>() {

   private Var Json = Var.VAR_NULL;

   public Var call() throws Exception {
    Json =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/x-www-form-urlencoded"),
    Var.valueOf(
    Var.valueOf("https://viacep.com.br/ws/").getObjectAsString() +
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.CEP")).getObjectAsString() +
    Var.valueOf("/json/").getObjectAsString()), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.Logradouro"),
    cronapi.json.Operations.getJsonOrMapField(Json,
    Var.valueOf("logradouro")));
    return Var.VAR_NULL;
   }
 }.call();
}

}

