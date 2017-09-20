package br.com.ana.alves.araujo.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author geraldo.matos
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String REST_API_POKEMON = "REST API - Pokemon";

	private static final String BR_COM_POKEMON = "br.com.ana.alves.araujo.pokemon";

	private Contact contact = new Contact("Pokemon", "https://pokemon.anaaraujo.com.br", "ana.karol1985@gmail.com.br");

	private ApiInfo apiInfoPokemon = new ApiInfoBuilder().title("Pokemon").description(REST_API_POKEMON)
			.version("1.0.0.beta").contact(contact).license("Apache License 2.0")
			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").build();

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket apiPokemon() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Pokemon").apiInfo(apiInfoPokemon).select()
				.apis(RequestHandlerSelectors.basePackage(BR_COM_POKEMON))
				.paths(PathSelectors.ant("/api/v1/pokemon/**")).build();
	}
}
