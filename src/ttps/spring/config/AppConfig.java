package ttps.spring.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@EnableWebMvc
//@ComponentScan(basePackages = "ttps.spring")
//@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ServiceImpl.class)
//@ComponentScan (basePackages = {"ttps.spring"}, excludeFilters = {@Filter (type = FilterType.ANNOTATION, value = Configuration.class)})
@Configuration
@EnableJpaRepositories(basePackages = { "ttps.spring" }, transactionManagerRef="transactionManager")
@ComponentScan (basePackages = {"ttps.spring"})
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}
}
