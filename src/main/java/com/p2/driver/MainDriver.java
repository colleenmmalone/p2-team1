package com.p2.driver;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainDriver {
	static Javalin app;

	public static void main(String[] args) {

		
		//make Javalin app from Jas's demo
		app = Javalin.create(ctx->{ 
			ctx.enableCorsForAllOrigins();
			ctx.addStaticFiles("HTML/p2-react-app/src/index.js", Location.CLASSPATH);
		}).start(7001);

	}

}
