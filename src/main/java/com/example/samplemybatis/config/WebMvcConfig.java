//package com.example.samplemybatis.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@RequiredArgsConstructor
////@PropertySource("classpath:${spring.profiles.active}workscanadmin.properties")
////@PropertySource("classpath:/workscanadmin.properties")
////@PropertySource("classpath:/workscanadmin${spring.profiles.active}.properties")
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/test").setViewName("home");
//        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/").setViewName("home");
//        registry.addViewController("/hello").setViewName("hello");
//        registry.addViewController("/login").setViewName("login");
//    }
//
//    //	@Bean
////    public static PropertySourcesPlaceholderConfigurer properties() {
////        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
////        return propertySourcesPlaceholderConfigurer;
////    }
////
//////	@Bean
//////	public FilterRegistrationBean<XssEscapeServletFilter> xssEscapeServletFilterBean() {
//////		FilterRegistrationBean<XssEscapeServletFilter> xssEscapeServletFilter = new FilterRegistrationBean<>();
//////		xssEscapeServletFilter.setFilter(new XssEscapeServletFilter());
//////		xssEscapeServletFilter.setOrder(1);
//////		xssEscapeServletFilter.addUrlPatterns("/*");
//////		return xssEscapeServletFilter;
//////	}
////
////	@Bean
////	public FilterRegistrationBean<XSSPreventionFilter> xSSPreventionFilterBean() {
////		FilterRegistrationBean<XSSPreventionFilter> xSSPreventionFilter = new FilterRegistrationBean<>();
////		xSSPreventionFilter.setFilter(new XSSPreventionFilter());
////		xSSPreventionFilter.setOrder(1);
////		xSSPreventionFilter.addUrlPatterns("/*");
////		return xSSPreventionFilter;
////	}
////
//////	@Bean
//////	public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
//////		ObjectMapper copy = objectMapper.copy();
//////		copy.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
//////		return new MappingJackson2HttpMessageConverter(copy);
//////	}
//
////	@Override
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////
//////		registry.addResourceHandler("/*.js").addResourceLocations("/").setCachePeriod(86400);
//////		registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(86400);
////	}
//
////	@Override
////	public void addInterceptors(InterceptorRegistry registry) {
////
////		List<String> notLoadList = new ArrayList<>();
////		notLoadList.add("/");
////		notLoadList.add("/connTest");
////		notLoadList.add("/ping");
////		notLoadList.add("/error");
////		notLoadList.add("/login");
////		notLoadList.add("/loginNew");
////		notLoadList.add("/loginCheck");
////		notLoadList.add("/actionLogout");
////		notLoadList.add("/logout");
////		notLoadList.add("/account/**");
////		notLoadList.add("/static/**");
////		notLoadList.add("/batch/**");
////		notLoadList.add("/api/**");
////		notLoadList.add("/test/**");
////		notLoadList.add("/testApi/**");
////		notLoadList.add("/fwApproval/approvalProcessPopupLink"); //컨트롤러에서 자체 처리
////		notLoadList.add("/fwApproval/approvalLogin");
////		notLoadList.add("/fwApproval/approvalTempPw");
////		notLoadList.add("/fwApproval/approvalPwReset");
////		notLoadList.add("/personnel/resetPassword/**");	 // 비밀번호 초기화(생년월일)를 url 이용하여 수동으로 처리하기 위해 예외 처리(임시)
////
////		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(notLoadList);
////
////	}
//}