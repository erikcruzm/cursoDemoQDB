package com.ipcom.demoqdb.routes;

import javax.sql.DataSource;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;



@Component
public class ActiveMQRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
    	
    	from("{{fromNewQueue}}")
    		.log("Mensaje leido de sqlqueue : + ${body}")
    		.log("Leyendo headers : ${headers}")
    		.choice()
    			.when(simple("${header.operacion} == 'ADD'"))
    				.log("Es agregar")
    				.to("{{toMysql}}")
    			.when(simple("${header.operacion} == 'UPDATE'"))
    				.log("Es ACTUALIZAR")
    				.to("{{toMysql}}")
    			.when(simple("${header.operacion} == 'DELETE'"))
    				.log("Es ELIMINAR")
    				.to("{{toMysql}}")
    			.otherwise()
    				.log("No se encontro la operacion");
    		
    
    }

}
