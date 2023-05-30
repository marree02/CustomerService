plugins {
	java
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.springdoc.openapi-gradle-plugin") version "1.6.0"

}
java {
	sourceCompatibility = JavaVersion.VERSION_17
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("org.hibernate.validator:hibernate-validator:7.0.1.Final")
	annotationProcessor ("org.hibernate.validator:hibernate-validator-annotation-processor:7.0.1.Final")
	implementation ("javax.validation:validation-api:2.0.1.Final")

}


//tasks.withType<Test> {
//	useJUnitPlatform()
//}
