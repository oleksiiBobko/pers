package org.op.pers.config;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class, SpringSecurityConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

//   @Override
//   protected void customizeRegistration(Dynamic registration) {
//      MultipartConfigElement multipartConfig = new MultipartConfigElement("D:/data", -1, -1, 0);
//      registration.setMultipartConfig(multipartConfig);
//   }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ShallowEtagHeaderFilter shallowEtagFilter = new ShallowEtagHeaderFilter();
//        shallowEtagFilter.setWriteWeakETag(false);
//        FilterConfig filterConfig = new FilterConfig();
//        shallowEtagFilter.init(filterConfig);
        servletContext.addFilter("shallowEtagHeaderFilter", shallowEtagFilter)
                      .addMappingForUrlPatterns(null, true, "/empire");
    }

}
