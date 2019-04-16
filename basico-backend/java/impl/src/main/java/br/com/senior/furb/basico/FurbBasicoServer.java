package br.com.senior.furb.basico;

import br.com.senior.messaging.model.Server;
import br.com.senior.messaging.model.ServiceDescription;

//http://dontpad.com/pomxmlserver
//http://dontpad.com/serverconf
@ServiceDescription(domain = BasicoConstants.DOMAIN, name = BasicoConstants.SERVICE, packages = {
		"br.com.senior.furb.basico" })
public class FurbBasicoServer extends Server {

	public static void main(String[] args) {
		bootstrap(new FurbBasicoServer());
	}
}