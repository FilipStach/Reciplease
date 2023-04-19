package appConfiguration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import appConfiguration.RcWebMvcConfigurer;

public class RcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public RcDispatcherServletInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[] = {RcWebMvcConfigurer.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/"};
		return arr;
	}

}