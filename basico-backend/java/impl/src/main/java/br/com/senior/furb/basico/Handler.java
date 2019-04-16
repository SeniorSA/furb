package br.com.senior.furb.basico;

import org.apache.commons.lang3.StringUtils;

import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class Handler implements HelloWorld {

	@Override
	public HelloWorldOutput helloWorld(HelloWorldInput request) {
		if (StringUtils.isBlank(request.who)) {
			return new HelloWorldOutput("Olá mundo!");
		}
		
		return new HelloWorldOutput("Olá " + request.who);
	}
}
