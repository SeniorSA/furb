package br.com.senior.furb.basico;

import br.com.senior.messaging.model.Server;
import br.com.senior.messaging.model.ServiceDescription;
import br.com.senior.furb.basico.BasicoConstants;
import br.com.senior.furb.basico.properties.FurbBasicoPropertyConsts;

@ServiceDescription(domain=BasicoConstants.DOMAIN, name=BasicoConstants.SERVICE, packages={"br.com.senior.furb.basico" })
public class FurbBasicoServer extends Server {

	public static void main(String[] args) {
		System.setProperty("db.migration.ondemand", "true");
		
		System.setProperty(FurbBasicoPropertyConsts.Service.DB_URL, "dbinstance.cvbthtviuesj.us-west-2.rds.amazonaws.com");
		System.setProperty(FurbBasicoPropertyConsts.Service.DB_USERNAME, "masteradmin");
		System.setProperty(FurbBasicoPropertyConsts.Service.DB_PASSWORD, "masteradmin");
		System.setProperty(FurbBasicoPropertyConsts.Service.DB_SCHEMA_NAME, "test");
		
		bootstrap(new FurbBasicoServer());
	}
}