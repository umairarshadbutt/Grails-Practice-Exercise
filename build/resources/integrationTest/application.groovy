

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.asciibooks.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.asciibooks.UserRole'
grails.plugin.springsecurity.authority.className = 'com.asciibooks.Role'
grails.plugin.springsecurity.userLookup.usernamePropertyName = 'email'
grails.plugin.springsecurity.userLookup.usernameIgnoreCase = true
grails.plugin.springsecurity.rest.login.active=true
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'email'
grails.plugin.springsecurity.rest.login.useJsonCredentials=true
grails.plugin.springsecurity.rest.login.endpointUrl='/api/login'
grails.plugin.springsecurity.rest.logout.endpointUrl='/api/logout'
grails.plugin.springsecurity.rest.token.validation.headerName='X-Auth-Token'
grails.plugin.springsecurity.rest.login.useRequestParamsCredentials=false

grails.plugin.springsecurity.useSecurityEventListener = true

grails.plugin.springsecurity.rest.login.failureStatusCode=401

grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName='practiceexercise.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName='tokenValue'

grails.plugin.springsecurity.rest.token.generation.useSecureRandom=true
grails.plugin.springsecurity.rest.token.generation.useUUID=false


grails.plugin.springsecurity.rest.token.rendering.usernamePropertyName = 'login'
grails.plugin.springsecurity.rest.token.rendering.authoritiesPropertyName = 'permissions'

grails.plugin.springsecurity.onRestTokenCreationEvent = { e, appCtx ->
	// handle RestTokenCreationEvent
}


grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
		//Stateless chain
		[
				pattern: '/api/**',filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
		],

		//Traditional chain
		[
				pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
		]
]
